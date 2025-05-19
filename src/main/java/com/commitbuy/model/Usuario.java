package com.commitbuy.model;

public abstract class Usuario {
    protected String email;
    protected String nome;
    protected String username;
    protected String senha;

    public Usuario(String email, String nome, String username, String senha) {
        this.email = email;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public abstract String rule();
}
