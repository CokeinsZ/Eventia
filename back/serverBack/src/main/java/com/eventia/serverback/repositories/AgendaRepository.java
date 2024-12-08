package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.models.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public class AgendaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AgendaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Agenda> getAgendas(int idEvento) {
        String sql = "SELECT a.*, u.ubc_nombre, u.ubc_ciudad FROM agendas a " +
                "INNER JOIN ubicaciones u ON a.ubc_id = u.ubc_id " +
                "WHERE a.evt_id = ?";
        ArrayList<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Agenda agenda = new Agenda(
                        resultSet.getInt("agd_id"),
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("ubc_nombre"),
                        resultSet.getString("ubc_ciudad"),
                        resultSet.getInt("evt_id"),
                        resultSet.getInt("entradas_disponibles"),
                        resultSet.getTimestamp("agd_fecha_inicio").toLocalDateTime(),
                        resultSet.getTimestamp("agd_fecha_fin").toLocalDateTime()
                );

                agendas.add(agenda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agendas;
    }

    public Agenda getAgendaById(int idEvento, int idAgenda) {
        String sql = "SELECT a.*, u.ubc_nombre, u.ubc_ciudad FROM agendas a " +
                "INNER JOIN ubicaciones u ON a.ubc_id = u.ubc_id " +
                "WHERE a.evt_id = ? AND a.agd_id = ?";
        Agenda agenda = new Agenda();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            preparedStatement.setInt(2, idAgenda);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                agenda = new Agenda(
                        resultSet.getInt("agd_id"),
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("ubc_nombre"),
                        resultSet.getString("ubc_ciudad"),
                        resultSet.getInt("evt_id"),
                        resultSet.getInt("entradas_disponibles"),
                        resultSet.getTimestamp("agd_fecha_inicio").toLocalDateTime(),
                        resultSet.getTimestamp("agd_fecha_fin").toLocalDateTime()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agenda;
    }

    public String addAgenda(int idEvento, Agenda agenda) {
        String sql = "INSERT INTO agendas (ubc_id, evt_id, agd_fecha_inicio, agd_fecha_fin) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, agenda.getUbc_id());
            preparedStatement.setInt(2, idEvento);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(agenda.getAgd_fecha_inicio()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agenda.getAgd_fecha_fin()));
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

    public String updateAgenda(int idEvento, Agenda agenda) {
        String sql = "UPDATE agendas SET ubc_id = ?, agd_fecha_inicio = ?, agd_fecha_fin = ? WHERE evt_id = ? AND agd_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, agenda.getUbc_id());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(agenda.getAgd_fecha_inicio()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(agenda.getAgd_fecha_fin()));
            preparedStatement.setInt(4, idEvento);
            preparedStatement.setInt(5, agenda.getAgd_id());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Agenda actualizada correctamente";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Error al actualizar la agenda";
    }

    public String deleteAgenda(int idEvento, int idAgenda) {
        String sql = "DELETE FROM agendas WHERE evt_id = ? AND agd_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            preparedStatement.setInt(2, idAgenda);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Agenda eliminada correctamente";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Error al eliminar la agenda";
    }
}
