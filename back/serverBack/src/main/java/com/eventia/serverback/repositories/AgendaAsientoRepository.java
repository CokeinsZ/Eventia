package com.eventia.serverback.repositories;

import com.eventia.serverback.models.AgendaAsientos;
import com.eventia.serverback.models.Asiento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class AgendaAsientoRepository {
    private final JdbcTemplate jdbcTemplate;

    public AgendaAsientoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<AgendaAsientos> getAgendaAsientos(int idAgenda) {
        String sql = "SELECT * FROM agenda_asientos WHERE agd_id = ?";
        ArrayList<AgendaAsientos> agendaAsientos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idAgenda);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AgendaAsientos agendaAsiento = new AgendaAsientos(
                        resultSet.getInt("agd_id"),
                        resultSet.getString("ast_id"),
                        resultSet.getInt("ubc_id"),
                        resultSet.getString("estado")
                );
                agendaAsientos.add(agendaAsiento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return agendaAsientos;
    }

    public String addAgendaAsiento(int idAgenda, AgendaAsientos agendaAsientos) {
        String sql = "INSERT INTO agenda_asientos (agd_id, ast_id, ubc_id, estado) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idAgenda);
            preparedStatement.setString(2, agendaAsientos.getAst_id());
            preparedStatement.setInt(3, agendaAsientos.getUbc_id());
            preparedStatement.setString(4, agendaAsientos.getEstado());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "No se asoció ningún asiento a la agenda";
            }

            return "Asiento asociado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al asociar asiento";
        }
    }

    public String updateAgendaAsiento(int idAgenda, AgendaAsientos agendaAsientos) {
        String sql = "UPDATE agenda_asientos SET estado = ? WHERE agd_id = ? AND ast_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, agendaAsientos.getEstado());
            preparedStatement.setInt(2, idAgenda);
            preparedStatement.setString(3, agendaAsientos.getAst_id());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "No se actualizó ningún asiento";
            }

            return "Asiento actualizado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar asiento";
        }
    }

    public String deleteAgendaAsiento(int idAgenda, String astId) {
        String sql = "DELETE FROM agenda_asientos WHERE agd_id = ? AND ast_id = ?";

        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idAgenda);
            preparedStatement.setString(2, astId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return "No se eliminó ningún asiento";
            }

            return "Asiento eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar asiento";
        }
    }

    public String asociarAgendaAsientos(int idAgenda, ArrayList<Asiento> asientos) {
        String sql = "INSERT INTO agenda_asientos (agd_id, ast_id, ubc_id, estado) VALUES (?, ?, ?, ?)";

        try {
            for (Asiento asiento : asientos) {
                try (Connection connection = jdbcTemplate.getDataSource().getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, idAgenda);
                    preparedStatement.setString(2, asiento.getAst_id());
                    preparedStatement.setInt(3, asiento.getUbc_id());
                    preparedStatement.setString(4, "libre");

                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Error al asociar asientos";
                }
            }

            return "Asientos asociados correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al asociar asientos";
        }
    }

}
