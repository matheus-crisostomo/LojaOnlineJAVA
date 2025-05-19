package com.commitbuy.service;

import com.commitbuy.model.Usuario;
import com.commitbuy.view.MenuAdministrador;

public class MenuService {
    public static void exibirMenu(Usuario usuario) {
        switch (usuario.rule()){
            case "ADMIN":
                MenuAdministrador.exibir();
                break;
            case "CLIENTE":

                break;
            default:
                System.out.println("Tipo de ususario invalido!");
        }
    }
}
