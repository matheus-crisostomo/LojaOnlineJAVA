package com.commitbuy.controller;

import com.commitbuy.database.ProdutoDB;
import com.commitbuy.model.Produto;

public class ProdutoController {
    public static void cadastrarProduto(String nome, String descricao, double preco, int quantidade)  {
        Produto produtoNovo = new Produto(nome, preco, quantidade, descricao);
        ProdutoDB.produtos.add(produtoNovo);
        System.out.println("Produto cadastrado com sucesso!");
    }
    public static void cadastrarProduto(String nome, double preco, int quantidade)  {
        Produto produtoNovo = new Produto(nome, preco, quantidade);
        ProdutoDB.produtos.add(produtoNovo);
        System.out.println("Produto cadastrado com sucesso!");
    }
    public static void listarProdutos() {
        if (ProdutoDB.produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        System.out.println("<------- LISTA DE PRODUTOS ------->");
        for (int i = 0; i < ProdutoDB.produtos.size(); i++) {
            Produto p = ProdutoDB.produtos.get(i);
            System.out.printf("[%d] %s - R$ %.2f%n", i+1, p.getNome(), p.getPreco());
            System.out.printf("    Unidades - %d%nx", p.getQuantidade());
        }
    }
    public static void deletarProduto(int index) {
        if (index < 1 || index > ProdutoDB.produtos.size()) {
            System.out.println("Index invalido!");
            return;
        }
        ProdutoDB.produtos.remove(index);
        System.out.println("Produto deletado com sucesso!");
    }
    public static void altQuantidade(int index, int quantidade) {
        if (index < 1 || index > ProdutoDB.produtos.size()) {
            System.out.println("Index invalido!");
            return;
        }
        Produto p = ProdutoDB.produtos.get(index);
        p.setQuantidade(quantidade);
        System.out.println("Quantidade atualizada com sucesso!");
    }
    public static void altPreco(int index, double preco) {
        if (index < 1 || index > ProdutoDB.produtos.size()) {
            System.out.println("Index invalido!");
            return;
        }
        Produto p = ProdutoDB.produtos.get(index);
        p.setPreco(preco);
        System.out.println("Preco atualizado com sucesso!");
    }
}
