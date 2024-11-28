package com.eventia.serverback.models;

import java.time.LocalDateTime;

public class Transaccion {
    private int trn_id;
    private int trn_usuario;
    private int trn_reserva;
    private LocalDateTime trn_fecha;
    private String trn_tipo;
    private float trn_saldo_anterior;
    private float trn_saldo_nuevo;

    public int getTrn_id() {
        return trn_id;
    }

    public void setTrn_id(int trn_id) {
        this.trn_id = trn_id;
    }

    public int getTrn_usuario() {
        return trn_usuario;
    }

    public void setTrn_usuario(int trn_usuario) {
        this.trn_usuario = trn_usuario;
    }

    public int getTrn_reserva() {
        return trn_reserva;
    }

    public void setTrn_reserva(int trn_reserva) {
        this.trn_reserva = trn_reserva;
    }

    public LocalDateTime getTrn_fecha() {
        return trn_fecha;
    }

    public void setTrn_fecha(LocalDateTime trn_fecha) {
        this.trn_fecha = trn_fecha;
    }

    public String getTrn_tipo() {
        return trn_tipo;
    }

    public void setTrn_tipo(String trn_tipo) {
        this.trn_tipo = trn_tipo;
    }

    public float getTrn_saldo_anterior() {
        return trn_saldo_anterior;
    }

    public void setTrn_saldo_anterior(float trn_saldo_anterior) {
        this.trn_saldo_anterior = trn_saldo_anterior;
    }

    public float getTrn_saldo_nuevo() {
        return trn_saldo_nuevo;
    }

    public void setTrn_saldo_nuevo(float trn_saldo_nuevo) {
        this.trn_saldo_nuevo = trn_saldo_nuevo;
    }
}
