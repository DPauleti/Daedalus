package io;

import java.util.Scanner;

public class InputReader {
    // Modos:

    private static Scanner sc = new Scanner(System.in);
    // Ler caracter para comandos
    public char lerChar() {
        String input = sc.nextLine().toLowerCase();
        return input.charAt(0);
    }
    // Ler string para nomes
    public String lerString() {
        String input = sc.nextLine();
        return input;
    }

}

