package com.commitbuy.model;

public class Cliente extends Usuario {

    public Cliente(String email, String nome, String username, String senha) {
        super(email, nome, username, senha);
    }

    @Override
    public String rule() {
        return "CLIENTE";
    }
}
