package com.commitbuy.util;

import java.util.Scanner;

public class InputUtils {
    private static Scanner sc = new Scanner(System.in);

    public static String lerTexto(String mensagem){
        System.out.println(mensagem);
        return sc.nextLine();
    }
    public static int lerInt(String mensagem){
        System.out.println(mensagem);
        while(!sc.hasNextInt()){
            System.out.println("Entrada invalida! digite um número inteiro!");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
    public static double lerDouble(String mensagem){
        System.out.println(mensagem);
        while(!sc.hasNextDouble()){
            System.out.println("Entrada invalida! Digite um número real!");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }
}
