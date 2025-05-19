package com.commitbuy.controller;

import com.commitbuy.database.UsuarioDB;
import com.commitbuy.model.Administrador;
import com.commitbuy.model.Cliente;
import com.commitbuy.model.Usuario;
import com.commitbuy.util.StringUtils;

public class UsuarioController {
    public boolean cadastrarCliente(String nome, String email, String username, String senha) {
        if (!StringUtils.isEmailValido(email)) {
            System.out.println("Email invalido!");
            return false;
        }
        if (!StringUtils.isSenhaValida(senha)) {
            System.out.println("Senha fraca! Use uma com mais de 4 caracteres");
            return false;
        }
        for (Usuario u : UsuarioDB.usuarios) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                System.out.println(username + " ja existe!");
                return false;
            } else if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email ja cadastrado!");
                return false;
            }
        }
        Usuario usuarioNovo = new Cliente(email, nome, username, senha);
        UsuarioDB.usuarios.add(usuarioNovo);
        System.out.println("Cliente cadastrado com sucesso!");
        return true;
    }

    public static void listarUsuarios() {
        for (Usuario u : UsuarioDB.usuarios) {
            System.out.println(u.rule().toUpperCase() + " - " + u.getUsername());
        }
    }

    public static void deletarUsuario(String username) {
        for (Usuario u : UsuarioDB.usuarios) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                UsuarioDB.usuarios.remove(u);
                System.out.println("Usuario, " + username + ", deletado com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }

    public static void atualizarSenha(String username, String senha) {
        for (Usuario u : UsuarioDB.usuarios) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                u.setSenha(senha);
                System.out.println("Senha atualizada com sucesso!");
                return;
            }
            System.out.println("Usuario nao encontrado!");
        }
    }

    public static void tornarAdm(Usuario usuario) {
        String username = usuario.getUsername();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();
        String nome = usuario.getNome();
        Usuario novoUsuario = new Administrador(email, nome, username, senha);
        UsuarioDB.usuarios.add(novoUsuario);
        System.out.println("Usuario " + username + " tornou-se administrador com sucesso!");
    }
    public static void tornarCliente(Usuario usuario) {
        String username = usuario.getUsername();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();
        String nome = usuario.getNome();
        Usuario novoUsuario = new Cliente(email, nome, username, senha);
        UsuarioDB.usuarios.add(novoUsuario);
        System.out.println("Usuario " + username + " tornou-se cliente com sucesso!");
    }
}
