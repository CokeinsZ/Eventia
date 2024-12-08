package com.eventia.serverback.models;

public class LoginResponse {
    private int usr_id;
    private String rol;
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(int usr_id, String rol, String token) {
        this.usr_id = usr_id;
        this.rol = rol;
        this.token = token;
    }

    public int getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
