package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Categoria;
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
        String sql = "SELECT e.*, c.cat_nombre FROM eventos as e " +
                    "LEFT JOIN evento_categoria as ec ON e.evt_id = ec.evt_id " +
                    "LEFT JOIN categorias as c ON ec.cat_id = c.cat_id " +
                    "ORDER BY e.evt_id ASC";
        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            ResultSet resultSet = jdbcTemplate.getDataSource().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);

            resultSet.first();
            int idAnterior = resultSet.getInt("evt_id");
            Evento evento = construirEvento(resultSet);
            Categoria categoria = new Categoria(resultSet.getString("cat_nombre"));
            evento.getCategorias().add(categoria);
            while (resultSet.next()) {
                int idActual = resultSet.getInt("evt_id");
                if (idAnterior != idActual) {
                    eventos.add(evento);    //Evento anterior

                    evento = construirEvento(resultSet);    //Crea evento actual
                    categoria = new Categoria(resultSet.getString("cat_nombre"));
                    evento.getCategorias().add(categoria);
                    idAnterior = idActual;

                } else {
                    //Si son el mismo evento, añade la categoría
                    categoria = new Categoria(resultSet.getString("cat_nombre"));
                    evento.getCategorias().add(categoria);
                }
            }
            eventos.add(evento);    //Añade el último evento
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
                id = resultSet.getInt(1);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
