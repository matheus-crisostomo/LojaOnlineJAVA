package com.commitbuy.model;
import java.time.LocalDateTime;

public class Pedido {
    private Cliente cliente;
    private Carrinho carrinho;
    private double total;
    private LocalDateTime data;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.total = carrinho.getTotal();
        this.data = LocalDateTime.now();
    }

    public void exibirResumo() {
        System.out.println("----- RESUMO DO PEDIDO -----");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data: " + data);
        System.out.println("Itens:");
        carrinho.listarProdutos();
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.println("----------------------------");
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }
}
