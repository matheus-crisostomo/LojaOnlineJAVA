package com.commitbuy.app;

import com.commitbuy.database.UsuarioDB;
import com.commitbuy.model.Administrador;
import com.commitbuy.view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        Administrador userAdm = new Administrador("mth@gmail.com", "Matheus", "mth", "admin");
        UsuarioDB.usuarios.add(userAdm);
        MenuPrincipal.exibirMenu();
    }
}