package com.eventia.serverback.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Filtro {
    private String nombre;
    private ArrayList<Categoria> categorias;
    private Ubicacion ubicacion;
    private LocalDateTime fecha;

    public Filtro() {
    }

    public Filtro(String nombre, ArrayList<Categoria> categorias, Ubicacion ubicacion, LocalDateTime fecha) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
