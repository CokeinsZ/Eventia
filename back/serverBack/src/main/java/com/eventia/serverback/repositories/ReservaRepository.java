package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;

@Repository
public class ReservaRepository {
    private final JdbcTemplate jdbcTemplate;

    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Reserva> getReservasEvt(int idEvento) {
        String sql = "SELECT r.* FROM reservas r " +
                "JOIN agendas a ON r.rsv_agenda = a.agd_id " +
                "JOIN eventos e ON a.evt_id = e.evt_id " +
                "WHERE e.evt_id = ?";

        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setRsv_id(resultSet.getInt("rsv_id"));
                reserva.setRsv_usuario(resultSet.getInt("rsv_usuario"));
                reserva.setRsv_agenda(resultSet.getInt("rsv_agenda"));
                reserva.setRsv_fecha(resultSet.getTimestamp("rsv_fecha").toLocalDateTime());
                reserva.setRsv_asiento(resultSet.getString("rsv_asiento"));
                reserva.setRsv_estado(resultSet.getString("rsv_estado"));

                reservas.add(reserva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservas;
    }

    public ArrayList<Reserva> getReservasUsr(int idUsuario) {
        String sql = "SELECT * FROM reservas WHERE rsv_usuario = ?";

        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setRsv_id(resultSet.getInt("rsv_id"));
                reserva.setRsv_usuario(resultSet.getInt("rsv_usuario"));
                reserva.setRsv_agenda(resultSet.getInt("rsv_agenda"));
                reserva.setRsv_fecha(resultSet.getTimestamp("rsv_fecha").toLocalDateTime());
                reserva.setRsv_asiento(resultSet.getString("rsv_asiento"));
                reserva.setRsv_estado(resultSet.getString("rsv_estado"));

                reservas.add(reserva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservas;
    }

    public Reserva getReserva(int idReserva) {
        String sql = "SELECT * FROM reservas WHERE rsv_id = ?";

        Reserva reserva = new Reserva();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idReserva);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                reserva.setRsv_id(resultSet.getInt("rsv_id"));
                reserva.setRsv_usuario(resultSet.getInt("rsv_usuario"));
                reserva.setRsv_agenda(resultSet.getInt("rsv_agenda"));
                reserva.setRsv_fecha(resultSet.getTimestamp("rsv_fecha").toLocalDateTime());
                reserva.setRsv_asiento(resultSet.getString("rsv_asiento"));
                reserva.setRsv_estado(resultSet.getString("rsv_estado"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reserva;
    }

    public int addReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (rsv_usuario, rsv_agenda, rsv_fecha, rsv_asiento, rsv_estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reserva.getRsv_usuario());
            preparedStatement.setInt(2, reserva.getRsv_agenda());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reserva.getRsv_fecha()));
            preparedStatement.setString(4, reserva.getRsv_asiento());
            preparedStatement.setString(5, reserva.getRsv_estado());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return -1;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                return -1;
            }

            return generatedKeys.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public String updateReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET rsv_usuario = ?, rsv_agenda = ?, rsv_fecha = ?, rsv_asiento = ?, rsv_estado = ? WHERE rsv_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, reserva.getRsv_usuario());
            preparedStatement.setInt(2, reserva.getRsv_agenda());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reserva.getRsv_fecha()));
            preparedStatement.setString(4, reserva.getRsv_asiento());
            preparedStatement.setString(5, reserva.getRsv_estado());
            preparedStatement.setInt(6, reserva.getRsv_id());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "Error al actualizar reserva";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar reserva";
        }

        return "Reserva actualizada";
    }

    public String deleteReserva(int idReserva) {
        String sql = "DELETE FROM reservas WHERE rsv_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idReserva);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "Error al eliminar reserva";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar reserva";
        }

        return "Reserva eliminada";
    }

    public float getIngresosEvento(int idEvento) {
        String sql = "SELECT SUM(evt_precio) FROM reservas r " +
                "JOIN agendas a ON r.rsv_agenda = a.agd_id " +
                "JOIN eventos e ON a.evt_id = e.evt_id " +
                "WHERE e.evt_id = ? AND (r.rsv_estado = 'confirmada' OR r.rsv_estado = 'completada') ";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getFloat(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
