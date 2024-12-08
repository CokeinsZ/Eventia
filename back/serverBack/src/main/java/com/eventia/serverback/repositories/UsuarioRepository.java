package com.eventia.serverback.repositories;

import com.eventia.serverback.models.LoginResponse;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.services.WebTokenProvider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioRepository {
    private final JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder passwordEncoder;
    private final WebTokenProvider webTokenProvider;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.passwordEncoder = new BCryptPasswordEncoder();
        this.webTokenProvider = new WebTokenProvider();
    }

    public Usuario getUsuario(int id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT u.*, r.rol_nombre FROM usuarios u " +
                "INNER JOIN roles r ON u.usr_rol = r.rol_id " +
                "WHERE usr_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("usr_id"),
                        resultSet.getString("usr_correo"),
                        resultSet.getString("usr_contrasena"),
                        resultSet.getFloat("usr_saldo"),
                        resultSet.getString("usr_nombre1"),
                        resultSet.getString("usr_nombre2"),
                        resultSet.getString("usr_apellido1"),
                        resultSet.getString("usr_apellido2"),
                        resultSet.getString("usr_telefono"),
                        resultSet.getString("usr_cedula"),
                        resultSet.getString("rol_nombre"),
                        resultSet.getString("usr_estado")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public Usuario getUsuario(String correo) {
        Usuario usuario = new Usuario();
        String sql = "SELECT u.*, r.rol_nombre FROM usuarios u " +
                "INNER JOIN roles r ON u.usr_rol = r.rol_id " +
                "WHERE usr_correo = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, correo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("usr_id"),
                        resultSet.getString("usr_correo"),
                        null, // No se necesita devolver la contraseña
                        resultSet.getFloat("usr_saldo"),
                        resultSet.getString("usr_nombre1"),
                        resultSet.getString("usr_nombre2"),
                        resultSet.getString("usr_apellido1"),
                        resultSet.getString("usr_apellido2"),
                        resultSet.getString("usr_telefono"),
                        resultSet.getString("usr_cedula"),
                        resultSet.getString("rol_nombre"),
                        resultSet.getString("usr_estado")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public String registerUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (usr_correo, usr_contrasena, usr_nombre1, usr_nombre2, usr_apellido1, usr_apellido2, usr_telefono, usr_cedula, usr_rol, usr_estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, (SELECT rol_id FROM roles WHERE rol_nombre LIKE ?), ?)";

        String contrasenaEncriptada = passwordEncoder.encode(usuario.getUsr_contrasena());

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getUsr_correo());
            preparedStatement.setString(2, contrasenaEncriptada);
            preparedStatement.setString(3, usuario.getUsr_nombre1());
            preparedStatement.setString(4, usuario.getUsr_nombre2());
            preparedStatement.setString(5, usuario.getUsr_apellido1());
            preparedStatement.setString(6, usuario.getUsr_apellido2());
            preparedStatement.setString(7, usuario.getUsr_telefono());
            preparedStatement.setString(8, usuario.getUsr_cedula());
            preparedStatement.setString(9, usuario.getRol_nombre());
            preparedStatement.setString(10, usuario.getUsr_estado());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return "" + generatedKeys.getInt(1); // Retorna el id del usuario registrado
                }
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("usr_correo")) {
                return "El correo ya está registrado.";
            } else if (e.getMessage().contains("usr_cedula")) {
                return "La cédula ya está registrada.";
            } else {
                e.printStackTrace();
                return "Error al registrar el usuario.";
            }
        }
        return "Error desconocido.";
    }

    public LoginResponse loginUsuario(Usuario usuario) {
        int usr_id = getUsuario(usuario.getUsr_correo()).getUsr_id();
        String contrasenaIngresada = usuario.getUsr_contrasena();
        String contrasenaEncriptada = "";

        LoginResponse loginResponse = new LoginResponse();

        String sql = "SELECT u.usr_contrasena, u.usr_estado, r.rol_nombre FROM usuarios u " +
                "INNER JOIN roles r ON u.usr_rol = r.rol_id " +
                "WHERE usr_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, usr_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                contrasenaEncriptada = resultSet.getString("usr_contrasena");
                String rol = resultSet.getString("rol_nombre");
                String estado = resultSet.getString("usr_estado");

                if (!estado.equalsIgnoreCase("activo")) {
                    loginResponse.setUsr_id(-1);
                    loginResponse.setResponse("Usuario inactivo o suspendido \nContacte servicio al cliente si cree que se trata de un error.");
                    return loginResponse;
                }

                if (!validarContrasena(contrasenaIngresada, contrasenaEncriptada)) {
                    loginResponse.setUsr_id(-1);
                    loginResponse.setResponse("Contraseña incorrecta.");
                    return loginResponse;
                }

                String token = webTokenProvider.createToken(usuario.getUsr_correo(), usr_id, rol);

                return new LoginResponse(usr_id, rol, token, "Login exitoso.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        loginResponse.setUsr_id(-1);
        loginResponse.setResponse("Error al iniciar sesión.");
        return loginResponse;
    }

    private Boolean validarContrasena(String contrasenaIngresada, String contrasenaEncriptada) {
        return passwordEncoder.matches(contrasenaIngresada, contrasenaEncriptada);
    }

    public String updatePersonalInfo(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET usr_correo = ?, usr_nombre1 = ?, usr_nombre2 = ?, usr_apellido1 = ?, usr_apellido2 = ?, usr_telefono = ?, usr_cedula = ?, usr_estado = ? WHERE usr_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, usuario.getUsr_correo());
            preparedStatement.setString(2, usuario.getUsr_nombre1());
            preparedStatement.setString(3, usuario.getUsr_nombre2());
            preparedStatement.setString(4, usuario.getUsr_apellido1());
            preparedStatement.setString(5, usuario.getUsr_apellido2());
            preparedStatement.setString(6, usuario.getUsr_telefono());
            preparedStatement.setString(7, usuario.getUsr_cedula());
            preparedStatement.setString(8, usuario.getUsr_estado());
            preparedStatement.setInt(9, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return "Usuario actualizado.";
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("usr_correo")) {
                return "El correo ya está registrado.";
            } else if (e.getMessage().contains("usr_cedula")) {
                return "La cédula ya está registrada.";
            } else {
                e.printStackTrace();
                return "Error al actualizar el usuario.";
            }
        }
        return "Error desconocido.";
    }

    public String updatePassword(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET usr_contrasena = ? WHERE usr_id = ?";

        String contrasenaEncriptada = passwordEncoder.encode(usuario.getUsr_contrasena());

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, contrasenaEncriptada);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return "Contraseña actualizada.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al actualizar la contraseña.";
    }

    public String updateRol(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET usr_rol = (SELECT rol_id FROM roles WHERE rol_nombre LIKE ?) WHERE usr_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, usuario.getRol_nombre());
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return "Rol actualizado.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al actualizar el rol.";
    }

    public String deleteUsuario(int id, String estado) {
        String sql = "UPDATE usuarios SET usr_estado = ? WHERE usr_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, estado);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return "Usuario eliminado.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al eliminar el usuario.";
    }
}
