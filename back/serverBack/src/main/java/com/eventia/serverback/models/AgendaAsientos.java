package com.eventia.serverback.models;

public class AgendaAsientos {
    private int agd_id;
    private String ast_id;
    private int ubc_id;
    private String estado;

    public AgendaAsientos() {
    }

    public AgendaAsientos(int agd_id, String ast_id, int ubc_id, String estado) {
        this.agd_id = agd_id;
        this.ast_id = ast_id;
        this.ubc_id = ubc_id;
        this.estado = estado;
    }

    public int getAgd_id() {
        return agd_id;
    }

    public void setAgd_id(int agd_id) {
        this.agd_id = agd_id;
    }

    public String getAst_id() {
        return ast_id;
    }

    public void setAst_id(String ast_id) {
        this.ast_id = ast_id;
    }

    public int getUbc_id() {
        return ubc_id;
    }

    public void setUbc_id(int ubc_id) {
        this.ubc_id = ubc_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
