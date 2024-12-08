package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Ubicacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class UbicacionRepository {
    private final JdbcTemplate jdbcTemplate;

    public UbicacionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        String sql = "SELECT * FROM ubicacion";
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

        try {
            ResultSet resultSet = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Ubicacion ubicacion = new Ubicacion(
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("ubc_nombre"),
                        resultSet.getString("ubc_ciudad"),
                        resultSet.getString("ubc_direccion"),
                        resultSet.getInt("ubc_capacidad")
                );
                ubicaciones.add(ubicacion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ubicaciones;
    }

    public Ubicacion getUbicacionById(int id) {
        String sql = "SELECT * FROM ubicacion WHERE ubc_id = ?";
        Ubicacion ubicacion = new Ubicacion();

        try {
            ResultSet resultSet = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(sql);

            if (resultSet.next()) {
                ubicacion = new Ubicacion(
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("ubc_nombre"),
                        resultSet.getString("ubc_ciudad"),
                        resultSet.getString("ubc_direccion"),
                        resultSet.getInt("ubc_capacidad")
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ubicacion;
    }

    public String addUbicacion(Ubicacion ubicacion) {
        String sql = "INSERT INTO ubicacion (ubc_nombre, ubc_ciudad, ubc_direccion, ubc_capacidad) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, ubicacion.getUbc_nombre());
            preparedStatement.setString(2, ubicacion.getUbc_ciudad());
            preparedStatement.setString(3, ubicacion.getUbc_direccion());
            preparedStatement.setInt(4, ubicacion.getUbc_capacidad());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Ubicación añadida con id: " + preparedStatement.getGeneratedKeys().getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al añadir ubicación";
        }

        return "Error al añadir ubicación";
    }

    public String updateUbicacion(int id, Ubicacion ubicacion) {
        String sql = "UPDATE ubicacion SET ubc_nombre = ?, ubc_ciudad = ?, ubc_direccion = ?, ubc_capacidad = ? WHERE ubc_id = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, ubicacion.getUbc_nombre());
            preparedStatement.setString(2, ubicacion.getUbc_ciudad());
            preparedStatement.setString(3, ubicacion.getUbc_direccion());
            preparedStatement.setInt(4, ubicacion.getUbc_capacidad());
            preparedStatement.setInt(5, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Ubicación actualizada";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar ubicación";
        }

        return "Error al actualizar ubicación";
    }

    public String deleteUbicacion(int id) {
        String sql = "DELETE FROM ubicacion WHERE ubc_id = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Ubicación eliminada";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar ubicación";
        }

        return "Error al eliminar ubicación";
    }
}
