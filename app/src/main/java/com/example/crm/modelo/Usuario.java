package com.example.crm.modelo;

public class Usuario {
    private int id;
    private String username;
    private String email;
    private String password;
    private int membresia;

    public Usuario(int id, String username, String email, String password, int membresia) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.membresia = membresia;
    }

    public String getUsername() {
        return this.username;
    }
}
