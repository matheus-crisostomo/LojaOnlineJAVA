package com.commitbuy.controller;
import com.commitbuy.model.Carrinho;
import com.commitbuy.model.Produto;
public class CarrinhoController {
    public static void adicionarAoCarrinho(Carrinho carrinho, Produto produto) {
        carrinho.addProduto(produto);
    }
    public static void removerDoCarrinho(Carrinho carrinho, int index) {
        carrinho.removeProduto(index);
    }
    public static void listarCarrinho(Carrinho carrinho) {
        carrinho.listarProdutos();
        System.out.printf("Total atual: R$ %.2f%n", carrinho.getTotal());
    }

}
