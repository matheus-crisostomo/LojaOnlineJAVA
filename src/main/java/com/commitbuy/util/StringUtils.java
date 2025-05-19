package com.commitbuy.util;

public class StringUtils {
    public static boolean isEmailValido(String email){
        return email.contains("@")&&email.contains(".");
    }

    public static boolean isSenhaValida(String senha){
        return senha.length()>=5;
    }
}
