package com.eventia.serverback.models;

public class Categoria {
    private String cat_nombre;

    public Categoria() {
    }

    public Categoria(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }
}
