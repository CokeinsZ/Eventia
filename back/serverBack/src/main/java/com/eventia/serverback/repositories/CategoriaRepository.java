package com.eventia.serverback.repositories;

import com.eventia.serverback.models.Categoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class CategoriaRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addEventoCategoria(int idEvento, int idCategoria) {
        String sql = "INSERT INTO evento_categoria (evt_id, cat_id) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idEvento);
            preparedStatement.setInt(2, idCategoria);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (cat_nombre) VALUES (?)";
        int id = -1;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, categoria.getCat_nombre().toUpperCase());
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

    public int searchCategoria(String catNombre) {
        String sql = "SELECT cat_id FROM categorias WHERE cat_nombre = ?";
        int catId = -1;
        try {
            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, catNombre.toUpperCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                catId = resultSet.getInt("cat_id");
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return catId;
    }
}
