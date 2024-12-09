package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Calificacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

@Repository
public class CalificacionRepository {
    private final JdbcTemplate jdbcTemplate;

    public CalificacionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Calificacion getCalificacion(int idEvento, int idUsuario) {
        String sql = "SELECT * FROM calificaciones WHERE cal_evento = ? AND cal_usuario = ?";
        Calificacion calificacion = new Calificacion();
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            preparedStatement.setInt(2, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                calificacion = new Calificacion(
                        resultSet.getInt("cal_usuario"),
                        resultSet.getInt("cal_evento"),
                        resultSet.getString("cal_comentario"),
                        resultSet.getInt("cal_num_estrellas")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return calificacion;
    }

    public ArrayList<Calificacion> getCalificacionesEvento(int idEvento) {
        String sql = "SELECT * FROM calificaciones WHERE cal_evento = ?";
        ArrayList<Calificacion> calificaciones = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Calificacion calificacion = new Calificacion(
                        resultSet.getInt("cal_usuario"),
                        resultSet.getInt("cal_evento"),
                        resultSet.getString("cal_comentario"),
                        resultSet.getInt("cal_num_estrellas")
                );
                calificaciones.add(calificacion);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return calificaciones;
    }

    public ArrayList<Calificacion> getCalificacionesUsuario(int idUsuario) {
        String sql = "SELECT * FROM calificaciones WHERE cal_usuario = ?";
        ArrayList<Calificacion> calificaciones = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Calificacion calificacion = new Calificacion(
                        resultSet.getInt("cal_usuario"),
                        resultSet.getInt("cal_evento"),
                        resultSet.getString("cal_comentario"),
                        resultSet.getInt("cal_num_estrellas")
                );
                calificaciones.add(calificacion);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return calificaciones;
    }

    public String addCalificacion(int idEvento, int idUsuario, Calificacion calificacion) {
        String sql = "INSERT INTO calificaciones (cal_usuario, cal_evento, cal_comentario, cal_num_estrellas) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setInt(2, idEvento);
            preparedStatement.setString(3, calificacion.getCal_comentario());
            preparedStatement.setInt(4, calificacion.getCal_num_estrellas());

            preparedStatement.executeUpdate();
            return "Calificación agregada correctamente";

        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "El usuario ya ha calificado este evento";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos al agregar calificación";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error desconocido al agregar calificación";
        }
    }

    public String updateCalificacion(int idEvento, int idUsuario, Calificacion calificacion) {
        String sql = "UPDATE calificaciones SET cal_comentario = ?, cal_num_estrellas = ? WHERE cal_evento = ? AND cal_usuario = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, calificacion.getCal_comentario());
            preparedStatement.setInt(2, calificacion.getCal_num_estrellas());
            preparedStatement.setInt(3, idEvento);
            preparedStatement.setInt(4, idUsuario);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Calificación actualizada correctamente";
            }

            return "No se encontró la calificación a actualizar";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos al actualizar calificación";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error desconocido al actualizar calificación";
        }
    }

    public String deleteCalificacion(int idEvento, int idUsuario) {
        String sql = "DELETE FROM calificaciones WHERE cal_evento = ? AND cal_usuario = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            preparedStatement.setInt(2, idUsuario);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Calificación eliminada correctamente";
            }

            return "No se encontró la calificación a eliminar";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos al eliminar calificación";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error desconocido al eliminar calificación";
        }
    }

    public double getPromedioCalificaciones(int idEvento) {
        String sql = "SELECT AVG(cal_num_estrellas) FROM calificaciones WHERE cal_evento = ?";
        double promedio = 0;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                promedio = resultSet.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promedio;
    }
}
