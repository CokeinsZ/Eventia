package com.eventia.serverback.models;

public class Ubicacion {
    private int ubc_id;
    private String ubc_nombre;
    private String ubc_ciudad;
    private String ubc_direccion;
    private int ubc_capacidad;

    public Ubicacion() {
    }

    public Ubicacion(int ubc_id, String ubc_nombre, String ubc_ciudad, String ubc_direccion, int ubc_capacidad) {
        this.ubc_id = ubc_id;
        this.ubc_nombre = ubc_nombre;
        this.ubc_ciudad = ubc_ciudad;
        this.ubc_direccion = ubc_direccion;
        this.ubc_capacidad = ubc_capacidad;
    }

    public int getUbc_id() {
        return ubc_id;
    }

    public void setUbc_id(int ubc_id) {
        this.ubc_id = ubc_id;
    }

    public String getUbc_nombre() {
        return ubc_nombre;
    }

    public void setUbc_nombre(String ubc_nombre) {
        this.ubc_nombre = ubc_nombre;
    }

    public String getUbc_ciudad() {
        return ubc_ciudad;
    }

    public void setUbc_ciudad(String ubc_ciudad) {
        this.ubc_ciudad = ubc_ciudad;
    }

    public String getUbc_direccion() {
        return ubc_direccion;
    }

    public void setUbc_direccion(String ubc_direccion) {
        this.ubc_direccion = ubc_direccion;
    }

    public int getUbc_capacidad() {
        return ubc_capacidad;
    }

    public void setUbc_capacidad(int ubc_capacidad) {
        this.ubc_capacidad = ubc_capacidad;
    }
}
