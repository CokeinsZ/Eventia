package com.eventia.serverback.models;

public class Asiento {
    private String ast_id;
    private int ubc_id;

    public Asiento() {
    }

    public Asiento(String ast_id, int ubc_id) {
        this.ast_id = ast_id;
        this.ubc_id = ubc_id;
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

}
