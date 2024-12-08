package com.eventia.serverback.models;

public class Usuario {
    private int usr_id;
    private String usr_correo;
    private String usr_contrasena;
    private float usr_saldo;
    private String usr_nombre1;
    private String usr_nombre2;
    private String usr_apellido1;
    private String usr_apellido2;
    private String usr_telefono;
    private String usr_cedula;
    private int usr_rol;
    private String rol_nombre;
    private String usr_estado;

    public Usuario() {
    }

    public Usuario(String usr_correo, String usr_contrasena) {
        this.usr_correo = usr_correo;
        this.usr_contrasena = usr_contrasena;
    }

    public Usuario(int usr_id, String usr_correo, String usr_contrasena, float usr_saldo, String usr_nombre1, String usr_nombre2, String usr_apellido1, String usr_apellido2, String usr_telefono, String usr_cedula, String rol_nombre, String usr_estado) {
        this.usr_id = usr_id;
        this.usr_correo = usr_correo;
        this.usr_contrasena = usr_contrasena;
        this.usr_saldo = usr_saldo;
        this.usr_nombre1 = usr_nombre1;
        this.usr_nombre2 = usr_nombre2;
        this.usr_apellido1 = usr_apellido1;
        this.usr_apellido2 = usr_apellido2;
        this.usr_telefono = usr_telefono;
        this.usr_cedula = usr_cedula;
        this.rol_nombre = rol_nombre;
        this.usr_estado = usr_estado;
    }

    public int getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_correo() {
        return usr_correo;
    }

    public void setUsr_correo(String usr_correo) {
        this.usr_correo = usr_correo;
    }

    public String getUsr_contrasena() {
        return usr_contrasena;
    }

    public void setUsr_contrasena(String usr_contrasena) {
        this.usr_contrasena = usr_contrasena;
    }

    public float getUsr_saldo() {
        return usr_saldo;
    }

    public void setUsr_saldo(float usr_saldo) {
        this.usr_saldo = usr_saldo;
    }

    public String getUsr_nombre1() {
        return usr_nombre1;
    }

    public void setUsr_nombre1(String usr_nombre1) {
        this.usr_nombre1 = usr_nombre1;
    }

    public String getUsr_nombre2() {
        return usr_nombre2;
    }

    public void setUsr_nombre2(String usr_nombre2) {
        this.usr_nombre2 = usr_nombre2;
    }

    public String getUsr_apellido1() {
        return usr_apellido1;
    }

    public void setUsr_apellido1(String usr_apellido1) {
        this.usr_apellido1 = usr_apellido1;
    }

    public String getUsr_apellido2() {
        return usr_apellido2;
    }

    public void setUsr_apellido2(String usr_apellido2) {
        this.usr_apellido2 = usr_apellido2;
    }

    public String getUsr_telefono() {
        return usr_telefono;
    }

    public void setUsr_telefono(String usr_telefono) {
        this.usr_telefono = usr_telefono;
    }

    public String getUsr_cedula() {
        return usr_cedula;
    }

    public void setUsr_cedula(String usr_cedula) {
        this.usr_cedula = usr_cedula;
    }

    public int getUsr_rol() {
        return usr_rol;
    }

    public void setUsr_rol(int usr_rol) {
        this.usr_rol = usr_rol;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getUsr_estado() {
        return usr_estado;
    }

    public void setUsr_estado(String usr_estado) {
        this.usr_estado = usr_estado;
    }
}
