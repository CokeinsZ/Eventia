package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Categoria;
import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.FiltroEvento;
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

    public ArrayList<Evento> getEventos(int pagina) {
        String sql = "SELECT e.*, u.usr_nombre1 as nombre_organizador, u.usr_apellido1 as apellido_organizador, c.cat_nombre, AVG(cal.cal_num_estrellas) as promedio_calificaciones FROM eventos as e " +
                "LEFT JOIN usuarios u ON e.evt_organizador = u.usr_id " +
                "LEFT JOIN evento_categoria as ec ON e.evt_id = ec.evt_id " +
                "LEFT JOIN categorias as c ON ec.cat_id = c.cat_id " +
                "LEFT JOIN calificaciones as cal ON cal.cal_evento = e.evt_id " +
                "GROUP BY cal.cal_evento, e.evt_id, ec.evt_id, c.cat_nombre, u.usr_id " +
                "LIMIT 10 OFFSET " + (pagina - 1) * 10;
        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            ResultSet resultSet = jdbcTemplate.getDataSource().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);

            if (resultSet.isBeforeFirst()) {    //Comprueba si hay resultados
                eventos = asociarCategoriasEventos(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return eventos;
    }

    private ArrayList<Evento> asociarCategoriasEventos(ResultSet resultSet) {
        ArrayList<Evento> eventos = new ArrayList<>();

        try {
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
        evento.setPromedioCalificaciones(rs.getFloat("promedio_calificaciones"));
        evento.setOrganizador_nombre(rs.getString("nombre_organizador") + " " + rs.getString("apellido_organizador"));
        return evento;
    }

    public Evento getEventoById(int id) {
        String sql = "SELECT e.*, u.usr_nombre1 as nombre_organizador, u.usr_apellido1 as apellido_organizador, c.cat_nombre, AVG(cal.cal_num_estrellas) as promedio_calificaciones FROM eventos as e " +
                "LEFT JOIN usuarios u ON e.evt_organizador = u.usr_id " +
                "LEFT JOIN evento_categoria as ec ON e.evt_id = ec.evt_id " +
                "LEFT JOIN categorias as c ON ec.cat_id = c.cat_id " +
                "LEFT JOIN calificaciones as cal ON cal.cal_evento = e.evt_id " +
                "WHERE e.evt_id = ? " +
                "GROUP BY cal.cal_evento, e.evt_id, ec.evt_id, c.cat_nombre, u.usr_id ";

        Evento evento = null;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);;
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                evento = asociarCategoriasEventos(resultSet).getFirst();
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

    public ArrayList<Evento> filtrarEventos(FiltroEvento filtros) {
        String sql = "SELECT e.*, c.cat_nombre FROM eventos as e " +
                    "LEFT JOIN evento_categoria as ec ON e.evt_id = ec.evt_id " +
                    "LEFT JOIN categorias as c ON ec.cat_id = c.cat_id " +
                    "WHERE 1 = 1";

        ArrayList<String> parametros = new ArrayList<>();

        if (filtros.getNombre() != null) {
            sql += " AND e.evt_nombre LIKE ?";
            parametros.add("%" + filtros.getNombre() + "%");
        }

        if (filtros.getCategorias() != null) {
            sql += " AND c.cat_nombre IN (";
            for (Categoria categoria : filtros.getCategorias()) {
                sql += "?, ";
                parametros.add(categoria.getCat_nombre());
            }
            sql += ")";
        }

        if (filtros.getUbicacion() != null) {
            sql += " AND e.evt_ubicacion = ?";
            parametros.add(filtros.getUbicacion().getUbc_nombre());
        }

        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            for (int i = 0; i < parametros.size(); i++) {
                preparedStatement.setString(i+1, parametros.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            eventos = asociarCategoriasEventos(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    public String updateEvento(int id, Evento evento) {
        String sql = "UPDATE eventos SET evt_nombre = ?, evt_descripcion = ?, evt_precio = ? WHERE evt_id = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, evento.getEvt_nombre());
            preparedStatement.setString(2, evento.getEvt_descripcion());
            preparedStatement.setFloat(3, evento.getEvt_precio());
            preparedStatement.setInt(4, id);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return "Evento actualizado correctamente";
            }

            return "No se ha actualizado ningún evento";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al actualizar el evento";
    }

    public String deleteEvento(int id) {
        String sql = "DELETE FROM eventos WHERE evt_id = ?";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Evento eliminado correctamente";
            }

            return "No se ha eliminado ningún evento";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al eliminar el evento";
    }

}
