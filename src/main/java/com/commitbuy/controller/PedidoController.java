package com.commitbuy.controller;

import com.commitbuy.database.PedidoDB;
import com.commitbuy.model.Carrinho;
import com.commitbuy.model.Cliente;
import com.commitbuy.model.Pedido;
import com.commitbuy.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    public static void finalizarPedido(Pedido pedido) {
        if (pedido.getCarrinho().getCarrinhoProdutos().isEmpty()){
            System.out.println("Carrinho vazio! Não é possivel finalizar o pedido.");
            return;
        }
        Cliente cliente = pedido.getCliente();
        List<Produto> itens = new ArrayList<>(pedido.getCarrinho().getCarrinhoProdutos());
        double total = pedido.getCarrinho().getTotal();

        Pedido novoPedido = new Pedido(cliente, pedido.getCarrinho());
        PedidoDB.pedidos.add(novoPedido);

        pedido.getCarrinho().limparCarrinho();

        System.out.println("Pedido finalizado com sucesso!");
        novoPedido.exibirResumo();
    }

    public static void exibirPedidosPorCliente(Cliente cliente) {
        boolean achou = false;
        for (Pedido pedido : PedidoDB.pedidos) {
            if (pedido.getCliente().getUsername().equalsIgnoreCase(cliente.getUsername())) {
                achou = true;
                pedido.exibirResumo();
            }
        }
        if (!achou){
            System.out.println("Nenhum pedido encontrado para o cliente:"+ cliente.getUsername());
        }
    }
}
