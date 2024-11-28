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
            // Manejar excepciones adecuadamente en producción
        }

        return eventos;
    }

    private Evento construirEvento(ResultSet rs) throws SQLException {
        Evento evento = new Evento();
        evento.setEvt_id(rs.getInt("evt_id"));
        evento.setEvt_nombre(rs.getString("evt_nombre"));
        evento.setEvt_descripcion(rs.getString("evt_descripcion"));
        evento.setEvt_precio(rs.getFloat("evt_precio"));

        return evento;
    }

}
