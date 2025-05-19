package com.commitbuy.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private Cliente cliente;
    private List<Produto> carrinhoProdutos;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.carrinhoProdutos = new ArrayList<>();
    }

    public void addProduto(Produto produto) {
        this.carrinhoProdutos.add(produto);
        System.out.println("Produto adicionado ao carrinho");
    }

    public void removeProduto(int index) {
        if (index < this.carrinhoProdutos.size() && index >= 0) {
            Produto removido = this.carrinhoProdutos.remove(index);
            System.out.println("Produto removido: " + removido.getNome());
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void listarProdutos() {
        if (this.carrinhoProdutos.isEmpty()) {
            System.out.println("Carrinho vazio");
        } else {
            for (int i = 0; i < this.carrinhoProdutos.size(); i++) {
                Produto p = this.carrinhoProdutos.get(i);
                System.out.printf("[%d] %s - R$ %.2f%n", i+1, p.getNome(), p.getPreco());
            }
        }
    }
    public double getTotal() {
        double total = 0;
        for (Produto p : this.carrinhoProdutos) {
            total += p.getPreco();
        }
        return total;
    }
    public void limparCarrinho() {
        this.carrinhoProdutos.clear();
        System.out.println("Carrinho limpo");
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<Produto> getCarrinhoProdutos() {
        return carrinhoProdutos;
    }
}
