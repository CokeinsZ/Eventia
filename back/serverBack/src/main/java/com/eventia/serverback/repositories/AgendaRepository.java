package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Agenda;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Repository
public class AgendaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AgendaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addAgenda(int idEvento, Agenda agenda) {
        String sql = "INSERT INTO agendas (ubc_id, evt_id, entradas_disponibles, agd_fecha_inicio, agd_fecha_fin) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, agenda.getUbc_id());
            preparedStatement.setInt(2, idEvento);
            preparedStatement.setInt(3, agenda.getEntradas_disponibles());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agenda.getAgd_fecha_inicio()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(agenda.getAgd_fecha_fin()));
            preparedStatement.executeUpdate();

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Agenda creada correctamente";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Error al crear la agenda";
    }
}
