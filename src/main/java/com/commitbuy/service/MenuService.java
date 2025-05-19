package com.commitbuy.service;

import com.commitbuy.model.Usuario;

public class MenuService {
    public static void exibirMenu(Usuario usuario) {
        switch (usuario.rule()){
            case "ADMIN":

                break;
            case "CLIENTE":

                break;
            default:
                System.out.println("Tipo de ususario invalido!");
        }
    }
}
