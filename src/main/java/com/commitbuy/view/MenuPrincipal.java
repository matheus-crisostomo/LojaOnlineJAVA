package com.commitbuy.view;

import com.commitbuy.controller.UsuarioController;
import com.commitbuy.model.Usuario;
import com.commitbuy.service.AuthService;
import com.commitbuy.service.MenuService;
import com.commitbuy.util.InputUtils;


public class MenuPrincipal {
    public static void exibirMenu() {
        boolean executando = true;

        while (executando) {
            System.out.println("===== COMMIT & BUY =====");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastrar-se");
            System.out.println("[0] Sair");

            int opt = InputUtils.lerInt("");

            switch (opt) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void login() {
        System.out.println("==== LOGIN ====");
        String username = InputUtils.lerTexto("Username: ");
        String senha = InputUtils.lerTexto("Senha: ");

        Usuario usuario = AuthService.login(username, senha);

        if (usuario != null) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Bem-vindo " + usuario.getNome() + "!");
            MenuService.exibirMenu(usuario);
        } else {
            System.out.println("Login falhou! Username ou senha incorretos.");
        }
    }
    private static void cadastrarCliente() {
        System.out.println("==== CADASTRO ====");
        String nome = InputUtils.lerTexto("Nome: ");
        String username = InputUtils.lerTexto("Username: ");
        String email = InputUtils.lerTexto("Email: ");
        String senha = InputUtils.lerTexto("Senha: ");

        UsuarioController.cadastrarCliente(nome, email, username, senha);
    }
}
