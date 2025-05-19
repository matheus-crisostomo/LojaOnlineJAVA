package com.commitbuy.view;

import com.commitbuy.controller.PedidoController;
import com.commitbuy.controller.ProdutoController;
import com.commitbuy.controller.UsuarioController;
import com.commitbuy.database.UsuarioDB;
import com.commitbuy.model.Usuario;
import com.commitbuy.util.InputUtils;

public class MenuAdministrador {

    public static void exibir() {
        boolean executando = true;
        while (executando) {
            System.out.println("=== MENU ADMINISTRADOR ===");
            System.out.println("[1] Cadastrar produto");
            System.out.println("[2] Listar produtos");
            System.out.println("[3] Remover produto do catalogo");
            System.out.println("[4] Atualizar um produto");
            System.out.println("[5] Listar Usuarios");
            System.out.println("[6] Buscar usuario pelo username");
            System.out.println("[7] Listar todos os pedidos");
            System.out.println("[8] Buscar pedido por cliente");
            System.out.println("[9] Alterar rule");
            System.out.println("[0] Sair");

            int opt = InputUtils.lerInt("");

            switch (opt) {
                case 1:
                    String nome = InputUtils.lerTexto("Nome: ");
                    double preco = InputUtils.lerDouble("Preço: ");
                    int quantidade = InputUtils.lerInt("Quantidade: ");
                    String descricao = InputUtils.lerTexto("Descrição: ");

                    if (descricao.isEmpty()) {
                        ProdutoController.cadastrarProduto(nome, preco, quantidade);
                    } else {
                        ProdutoController.cadastrarProduto(nome, descricao, preco, quantidade);
                    }
                    break;
                case 2:
                    ProdutoController.listarProdutos();
                    break;
                case 3:
                    ProdutoController.listarProdutos();
                    int optP = InputUtils.lerInt("Qual produto deseja deletar? (por indice)");
                    ProdutoController.deletarProduto(optP + 1);
                    break;
                case 4:
                    boolean executandoInterno = true;
                    while (executandoInterno) {
                        System.out.println("=== Atualizar produto ===");
                        System.out.println("[1] Atualizar preço");
                        System.out.println("[2] Atualizar quantidade");
                        System.out.println("[0] Voltar");
                        int optA = InputUtils.lerInt("");

                        switch (optA) {
                            case 1:
                                ProdutoController.listarProdutos();
                                int optPr = InputUtils.lerInt("Qual produto deseja alterar o preço? (por indice)");
                                double novoPreco = InputUtils.lerDouble("Digite o novo preço: ");
                                ProdutoController.altPreco(optPr + 1, novoPreco);
                                break;
                            case 2:
                                ProdutoController.listarProdutos();
                                int optQu = InputUtils.lerInt("Qual produto deseja alterar a quantidade? (por indice)");
                                int novaQuantidade = InputUtils.lerInt("Digite a nova quantidade: ");
                                ProdutoController.altQuantidade(optQu + 1, novaQuantidade);
                                break;
                            case 0:
                                executandoInterno = false;
                                break;
                            default:
                                System.out.println("Opção não encontrada");
                        }
                    }
                case 5:
                    UsuarioController.listarUsuarios();
                    break;
                case 6:
                    boolean executandoInterno2 = true;
                    while (executandoInterno2) {
                        String username = InputUtils.lerTexto("Digite o username desejado: ");
                        System.out.println("[1] Ver Dados");
                        System.out.println("[2] Deletar Usuario");
                        System.out.println("[0] Voltar");
                        int optU = InputUtils.lerInt("");
                        Usuario userSelect = UsuarioController.buscarUsuarioPorUsername(username);

                        switch (optU) {
                            case 1:
                                UsuarioController.exibirDadosUsuario(userSelect);
                                break;
                            case 2:
                                UsuarioController.deletarUsuario(username);
                                break;
                            case 0:
                                executandoInterno2 = false;
                                break;
                            default:
                                System.out.println("Opção não encontrada");
                        }
                    }
                case 7:
                    PedidoController.exibirPedidos();
                    break;
                case 8:
                    PedidoController.exibirPedidosPorCliente();
                    break;
                case 9:
                    UsuarioController.listarUsuarios();
                    int optUserRule = InputUtils.lerInt("Qual Usuario deseja alterar a rule? (por indice)");
                    System.out.println("Deseja alterar para: ");
                    System.out.println("[1] ADMIN");
                    System.out.println("[2] CLIENTE");
                    int optRule = InputUtils.lerInt("");
                    switch (optRule) {
                        case 1:
                            UsuarioController.tornarAdm(UsuarioDB.usuarios.get(optUserRule - 1));
                            break;
                        case 2:
                            UsuarioController.tornarCliente(UsuarioDB.usuarios.get(optUserRule - 1));
                            break;
                        default:
                            System.out.println("Opção não encontrada");
                    }
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção não encontrada");
            }
        }
    }
}
