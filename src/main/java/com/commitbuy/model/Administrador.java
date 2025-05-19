package com.commitbuy.model;

public class Administrador extends Usuario {

    public Administrador(String email, String nome, String username, String senha) {
        super(email, nome, username, senha);
    }

    @Override
    public String rule() {
        return "ADMIN";
    }
}