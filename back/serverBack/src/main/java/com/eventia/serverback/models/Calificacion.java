package com.eventia.serverback.models;

public class Calificacion {
    private int cal_usuario;
    private int cal_evento;
    private String cal_comentario;
    private int cal_num_estrellas;


    public int getCal_usuario() {
        return cal_usuario;
    }

    public void setCal_usuario(int cal_usuario) {
        this.cal_usuario = cal_usuario;
    }

    public int getCal_evento() {
        return cal_evento;
    }

    public void setCal_evento(int cal_evento) {
        this.cal_evento = cal_evento;
    }

    public String getCal_comentario() {
        return cal_comentario;
    }

    public void setCal_comentario(String cal_comentario) {
        this.cal_comentario = cal_comentario;
    }

    public int getCal_num_estrellas() {
        return cal_num_estrellas;
    }

    public void setCal_num_estrellas(int cal_num_estrellas) {
        this.cal_num_estrellas = cal_num_estrellas;
    }
}
