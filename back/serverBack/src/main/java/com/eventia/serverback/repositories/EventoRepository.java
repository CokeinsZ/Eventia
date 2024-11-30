package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.ArrayList;

@Repository
public class EventoRepository {
    private final JdbcTemplate jdbcTemplate;

    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Evento> getEventos() {
        String sql = "SELECT * FROM eventos";
        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            // Ejecutar la consulta
            ResultSet resultSet = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Evento evento = construirEvento(resultSet);
                eventos.add(evento);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    private Evento construirEvento(ResultSet rs) throws SQLException {
        Evento evento = new Evento();
        evento.setEvt_id(rs.getInt("evt_id"));
        evento.setEvt_organizador(rs.getInt("evt_organizador"));
        evento.setEvt_nombre(rs.getString("evt_nombre"));
        evento.setEvt_descripcion(rs.getString("evt_descripcion"));
        evento.setEvt_precio(rs.getFloat("evt_precio"));

        return evento;
    }

    public Evento getEventoById(int id) {
        String sql = "SELECT * FROM eventos WHERE evt_id = ?";
        Evento evento = null;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                evento = construirEvento(resultSet);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evento;
    }

    public int addEvento(Evento evento) {
        String sql = "INSERT INTO eventos (evt_organizador, evt_nombre, evt_descripcion, evt_precio) VALUES (?, ?, ?, ?)";
        int id = -1;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, evento.getEvt_organizador());
            preparedStatement.setString(2, evento.getEvt_nombre());
            preparedStatement.setString(3, evento.getEvt_descripcion());
            preparedStatement.setFloat(4, evento.getEvt_precio());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("Evento insertado con : " + resultSet);
                id = resultSet.getInt(1);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
