package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Asiento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

@Repository
public class AsientoRepository {
    private final JdbcTemplate jdbcTemplate;

    public AsientoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Asiento> getAsientosByUbc(int ubc_id) {
        String sql = "SELECT * FROM asientos WHERE ubc_id = ?";
        ArrayList<Asiento> asientos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, ubc_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Asiento asiento = new Asiento(
                        resultSet.getString("ast_id"),
                        resultSet.getInt("ubc_id")
                );
                asientos.add(asiento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return asientos;
    }

    public String addAsiento(Asiento asiento) {
        String sql = "INSERT INTO asientos (ast_id, ubc_id) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, asiento.getAst_id());
            preparedStatement.setInt(2, asiento.getUbc_id());
            preparedStatement.executeUpdate();

            return "Asiento agregado correctamente";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "Error: El ast_id ya existe";

        } catch (SQLException e) {
            return "Error: Estado inválido u otro error de SQL";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al agregar asiento";
        }

    }

    public String deleteAsiento(Asiento asiento) {
        String sql = "DELETE FROM asientos WHERE ast_id = ? AND ubc_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, asiento.getAst_id());
            preparedStatement.setInt(2, asiento.getUbc_id());
            preparedStatement.executeUpdate();

            return "Asiento eliminado correctamente";

        } catch (SQLException e) {
            return "Error al eliminar asiento. \n\t + " + e.getMessage();
        }
    }

    public String addAsientosDefault(int ubc_id, int numFilas, int numAsientosFila) {
        String sql = "INSERT INTO asientos (ast_id, ubc_id) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);

            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numAsientosFila; j++) {
                    String ast_id = "F" + (i + 1) + "A" + (j + 1);

                    preparedStatement.setString(1, ast_id);
                    preparedStatement.setInt(2, ubc_id);
                    preparedStatement.executeUpdate();
                }
            }

            return "Asientos agregados correctamente";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "Error: El ast_id ya existe";

        } catch (SQLException e) {
            return "Error: Estado inválido u otro error de SQL";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al agregar asientos";
        }
    }

    public String editAsiento(Asiento asiento, String idNuevo) {
        String sql = "UPDATE asientos SET ast_id = ? WHERE ast_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, idNuevo);
            preparedStatement.setString(2, asiento.getAst_id());
            preparedStatement.executeUpdate();

            return "Asiento actualizado correctamente";

        } catch (SQLException e) {
            return "Error al actualizar asiento. \n\t + " + e.getMessage();
        }
    }
}
