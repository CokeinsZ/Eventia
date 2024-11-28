package com.eventia.serverback.models;

import java.time.LocalDateTime;

public class Reserva {
    private int rsv_id;
    private int rsv_usuario;
    private int rsv_agenda;
    private LocalDateTime rsv_fecha;
    private String rsv_asiento;
    private String rsv_estado;

    public int getRsv_id() {
        return rsv_id;
    }

    public void setRsv_id(int rsv_id) {
        this.rsv_id = rsv_id;
    }

    public int getRsv_usuario() {
        return rsv_usuario;
    }

    public void setRsv_usuario(int rsv_usuario) {
        this.rsv_usuario = rsv_usuario;
    }

    public int getRsv_agenda() {
        return rsv_agenda;
    }

    public void setRsv_agenda(int rsv_agenda) {
        this.rsv_agenda = rsv_agenda;
    }

    public LocalDateTime getRsv_fecha() {
        return rsv_fecha;
    }

    public void setRsv_fecha(LocalDateTime rsv_fecha) {
        this.rsv_fecha = rsv_fecha;
    }

    public String getRsv_asiento() {
        return rsv_asiento;
    }

    public void setRsv_asiento(String rsv_asiento) {
        this.rsv_asiento = rsv_asiento;
    }

    public String getRsv_estado() {
        return rsv_estado;
    }

    public void setRsv_estado(String rsv_estado) {
        this.rsv_estado = rsv_estado;
    }
}
