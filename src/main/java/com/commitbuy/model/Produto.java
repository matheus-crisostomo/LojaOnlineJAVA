package com.commitbuy.model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;

    public Produto(String nome, double preco, int quantidade, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void altQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void exibirProduto(){
        System.out.println("Produto - "+getNome());
        System.out.println("Preço - "+getPreco());
        System.out.println("Quantidade - "+getQuantidade());
        if (descricao != null) {
            System.out.println("Descrição - "+getDescricao());
        }
    }
}
