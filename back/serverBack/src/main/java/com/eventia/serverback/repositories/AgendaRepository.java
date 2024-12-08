package com.eventia.serverback.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AgendaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AgendaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addAgenda(int idEvento, int idAgenda) {
        String sql = "INSERT INTO agenda (evt_id, agd_id) VALUES (?, ?)";

    }
}
