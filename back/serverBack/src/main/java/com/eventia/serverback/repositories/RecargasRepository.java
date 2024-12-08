package com.eventia.serverback.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class RecargasRepository {
    private final JdbcTemplate jdbcTemplate;

    public RecargasRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean recargarSaldo(int id, float monto) {
        if (monto <= 0) {
            return false;
        }

        String sql = "UPDATE usuarios SET usr_saldo = usr_saldo + ? WHERE usr_id = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setFloat(1, monto);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public String insertarRecarga(int id, float monto) {
        String insertRecargaSql = "INSERT INTO recargas (usr_id, rec_fecha, rec_monto, rec_estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertRecargaStmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(insertRecargaSql)) {
            insertRecargaStmt.setInt(1, id);
            insertRecargaStmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            insertRecargaStmt.setFloat(3, monto);
            insertRecargaStmt.setString(4, "aprobada");

            int affectedRows = insertRecargaStmt.executeUpdate();
            if (affectedRows > 0) {
                return "Recarga realizada con éxito";
            } else {
                return "Error al realizar la recarga";
            }

        } catch (Exception e) {
            return "Error al realizar la recarga";
        }
    }

}
