package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public class AgendaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AgendaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Agenda> getAgendas(int idEvento) {
        String sql = "SELECT a.*, u.ubc_nombre, u.ubc_ciudad, COUNT(CASE WHEN agdast.estado = 'libre' THEN 1 END ) as entradas_disponibles " +
                "FROM agendas a " +
                "INNER JOIN ubicaciones u ON a.ubc_id = u.ubc_id " +
                "INNER JOIN agenda_asientos agdast ON a.agd_id = agdast.agd_id " +
                "WHERE a.evt_id = ? " +
                "GROUP BY a.agd_id";
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
                        resultSet.getTimestamp("agd_fecha_inicio").toLocalDateTime(),
                        resultSet.getTimestamp("agd_fecha_fin").toLocalDateTime(),
                        resultSet.getString("agd_estado")
                );
                agenda.setEntradas_disponibles(resultSet.getInt("entradas_disponibles"));

                agendas.add(agenda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agendas;
    }

    public Agenda getAgendaById(int idAgenda) {
        String sql = "SELECT a.*, u.ubc_nombre, u.ubc_ciudad FROM agendas a " +
                "INNER JOIN ubicaciones u ON a.ubc_id = u.ubc_id " +
                "WHERE a.agd_id = ?";
        Agenda agenda = new Agenda();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idAgenda);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                agenda = new Agenda(
                        resultSet.getInt("agd_id"),
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("ubc_nombre"),
                        resultSet.getString("ubc_ciudad"),
                        resultSet.getInt("evt_id"),
                        resultSet.getTimestamp("agd_fecha_inicio").toLocalDateTime(),
                        resultSet.getTimestamp("agd_fecha_fin").toLocalDateTime(),
                        resultSet.getString("agd_estado")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agenda;
    }

    public int addAgenda(int idEvento, Agenda agenda) {
        String sql = "INSERT INTO agendas (ubc_id, evt_id, agd_fecha_inicio, agd_fecha_fin) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, agenda.getUbc_id());
            preparedStatement.setInt(2, idEvento);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(agenda.getAgd_fecha_inicio()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agenda.getAgd_fecha_fin()));

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
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

    public String deleteAgendas(int idEvento) {
        String sql = "DELETE FROM agendas WHERE evt_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Agendas eliminadas correctamente";
            }

            return "No se han eliminado agendas";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Error al eliminar las agendas";
    }

    public boolean isFechaOcupada(int ubcId, LocalDateTime agdFechaInicio, LocalDateTime agdFechaFin) {
        String sql = "SELECT * FROM agendas WHERE ubc_id = ? AND " +
                "((agd_fecha_inicio BETWEEN ? AND ?) OR (agd_fecha_fin BETWEEN ? AND ?))";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, ubcId);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(agdFechaInicio));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(agdFechaFin));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agdFechaInicio));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(agdFechaFin));
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public float getEventoPrecio(int rsvAgenda) {
        String sql = "SELECT e.evt_precio FROM eventos e " +
                "INNER JOIN agendas a ON e.evt_id = a.evt_id " +
                "WHERE a.agd_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, rsvAgenda);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getFloat("evt_precio");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Evento getEvento(int agenda) {
        String sql = "SELECT e.* FROM eventos e " +
                "INNER JOIN agendas a ON e.evt_id = a.evt_id " +
                "WHERE a.agd_id = ?";
        Evento evento = new Evento();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, agenda);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                evento = new Evento(
                        resultSet.getInt("evt_organizador"),
                        resultSet.getString("evt_nombre"),
                        resultSet.getString("evt_descripcion"),
                        resultSet.getFloat("evt_precio"),
                        0
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return evento;
    }

    public String terminarAgenda(int id, int idAgenda) {
        String sql = "UPDATE agendas SET agd_estado = 'terminada' WHERE evt_id = ? AND agd_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idAgenda);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Agenda terminada correctamente";
            }

            return "No se ha terminado la agenda";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al terminar la agenda: " + e.getMessage();
        }
    }
}
