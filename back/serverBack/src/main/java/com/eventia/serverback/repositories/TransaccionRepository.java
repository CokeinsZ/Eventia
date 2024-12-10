package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class TransaccionRepository {
    private final JdbcTemplate jdbcTemplate;

    public TransaccionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addTransaccion(int usuario, int idReserva, float saldoAnterior, float saldoNuevo, String tipo) {
        String sql = "INSERT INTO transacciones (trn_usuario, trn_reserva, trn_fecha, trn_tipo, trn_saldo_anterior, trn_saldo_nuevo) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, usuario);
            preparedStatement.setInt(2, idReserva);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(4, tipo);
            preparedStatement.setFloat(5, saldoAnterior);
            preparedStatement.setFloat(6, saldoNuevo);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "Error al agregar transacción";
            }

            return "Transacción agregada";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al agregar transacción: " + e.getMessage();
        }
    }


}
