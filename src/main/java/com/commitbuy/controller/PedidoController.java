package com.commitbuy.controller;

import com.commitbuy.database.PedidoDB;
import com.commitbuy.model.Cliente;
import com.commitbuy.model.Pedido;
import com.commitbuy.model.Produto;
import com.commitbuy.model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoController {
    public static void finalizarPedido(Pedido pedido) {
        if (pedido.getCarrinho().getCarrinhoProdutos().isEmpty()) {
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

    public static void exibirPedidos() {
        if (PedidoDB.pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado");
            return;
        }
        PedidoDB.pedidos.forEach(Pedido::exibirResumo);
    }

    public static void exibirPedidosPorCliente() {
        if (PedidoDB.pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado");
            return;
        }

        Map<String, List<Pedido>> pedidosPorCliente = new HashMap<>();

        for (Pedido pedido : PedidoDB.pedidos) {
            String username = pedido.getCliente().getUsername();

            pedidosPorCliente.computeIfAbsent(username, k -> new ArrayList<>()).add(pedido);
        }

        System.out.println("==== PEDIDOS AGRUPADOS POR CLIENTE ====");
        for (String username : pedidosPorCliente.keySet()) {
            List<Pedido> pedidos = pedidosPorCliente.get(username);
            Usuario cliente = pedidos.get(0).getCliente();

            System.out.println("\nCliente: " + cliente.getNome() + " (" + cliente.getUsername() + ")");
            System.out.println("Total de pedidos: " + pedidos.size());

            for (Pedido pedido : pedidos) {
                System.out.println("Data " + pedido.getData());
                System.out.println("Produtos:");
                pedido.getCarrinho().getCarrinhoProdutos().forEach(p -> System.out.printf("  - %s%n R$ - %.2f%n", p.getNome(), p.getPreco()));

                System.out.println("  Total: R$ " + pedido.getTotal());
                System.out.println("-----------------------------------");
            }
        }
    }

}
