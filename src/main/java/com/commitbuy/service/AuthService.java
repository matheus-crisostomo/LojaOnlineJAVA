package com.commitbuy.service;

import com.commitbuy.database.UsuarioDB;
import com.commitbuy.model.Usuario;

public class AuthService {
    public static Usuario login(String username, String senha) {
        for (Usuario u : UsuarioDB.usuarios) {
            if (u.getUsername().equals(username) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
}
