package com.eventia.serverback.models;

import java.time.LocalDateTime;

public class Agenda {
    private int agd_id;
    private int ubc_id;
    private String ubc_nombre;
    private String ubc_ciudad;
    private int evt_id;
    private int entradas_disponibles;
    private LocalDateTime agd_fecha_inicio;
    private LocalDateTime agd_fecha_fin;

    public Agenda() {
    }

    public Agenda(int agd_id, int ubc_id, String ubc_nombre, String ubc_ciudad, int evt_id, LocalDateTime agd_fecha_inicio, LocalDateTime agd_fecha_fin) {
        this.agd_id = agd_id;
        this.ubc_id = ubc_id;
        this.ubc_nombre = ubc_nombre;
        this.ubc_ciudad = ubc_ciudad;
        this.evt_id = evt_id;
        this.agd_fecha_inicio = agd_fecha_inicio;
        this.agd_fecha_fin = agd_fecha_fin;
    }


    public int getAgd_id() {
        return agd_id;
    }

    public void setAgd_id(int agd_id) {
        this.agd_id = agd_id;
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

    public int getEvt_id() {
        return evt_id;
    }

    public void setEvt_id(int evt_id) {
        this.evt_id = evt_id;
    }

    public LocalDateTime getAgd_fecha_inicio() {
        return agd_fecha_inicio;
    }

    public void setAgd_fecha_inicio(LocalDateTime agd_fecha_inicio) {
        this.agd_fecha_inicio = agd_fecha_inicio;
    }

    public LocalDateTime getAgd_fecha_fin() {
        return agd_fecha_fin;
    }

    public void setAgd_fecha_fin(LocalDateTime agd_fecha_fin) {
        this.agd_fecha_fin = agd_fecha_fin;
    }
}
