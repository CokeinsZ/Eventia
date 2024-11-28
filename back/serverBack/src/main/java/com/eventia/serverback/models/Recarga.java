package com.eventia.serverback.models;

import java.time.LocalDateTime;

public class Recarga {
    private int rec_id;
    private int usr_id;
    private LocalDateTime rec_fecha;
    private float rec_monto;
    private String rec_estado;

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public int getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }

    public LocalDateTime getRec_fecha() {
        return rec_fecha;
    }

    public void setRec_fecha(LocalDateTime rec_fecha) {
        this.rec_fecha = rec_fecha;
    }

    public float getRec_monto() {
        return rec_monto;
    }

    public void setRec_monto(float rec_monto) {
        this.rec_monto = rec_monto;
    }

    public String getRec_estado() {
        return rec_estado;
    }

    public void setRec_estado(String rec_estado) {
        this.rec_estado = rec_estado;
    }
}
