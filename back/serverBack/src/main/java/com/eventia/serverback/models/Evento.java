package com.eventia.serverback.models;

import java.util.ArrayList;

public class Evento {
    private int evt_id;
    private int evt_organizador;
    private String evt_nombre;
    private String evt_descripcion;
    private float evt_precio;
    private ArrayList<Categoria> categorias;
    private double promedioCalificaciones;

    public Evento() {
        this.categorias = new ArrayList<>();
    }

    public Evento(int evt_organizador, String evt_nombre, String evt_descripcion, float evt_precio, double promedioCalificaciones) {
        this.evt_organizador = evt_organizador;
        this.evt_nombre = evt_nombre;
        this.evt_descripcion = evt_descripcion;
        this.evt_precio = evt_precio;
        this.categorias = new ArrayList<>();
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public int getEvt_id() {
        return evt_id;
    }

    public void setEvt_id(int evt_id) {
        this.evt_id = evt_id;
    }

    public int getEvt_organizador() {
        return evt_organizador;
    }

    public void setEvt_organizador(int evt_organizador) {
        this.evt_organizador = evt_organizador;
    }

    public String getEvt_nombre() {
        return evt_nombre;
    }

    public void setEvt_nombre(String evt_nombre) {
        this.evt_nombre = evt_nombre;
    }

    public String getEvt_descripcion() {
        return evt_descripcion;
    }

    public void setEvt_descripcion(String evt_descripcion) {
        this.evt_descripcion = evt_descripcion;
    }

    public float getEvt_precio() {
        return evt_precio;
    }

    public void setEvt_precio(float evt_precio) {
        this.evt_precio = evt_precio;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }
}
