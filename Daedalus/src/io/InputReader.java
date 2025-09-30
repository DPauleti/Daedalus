package io;

import java.util.Scanner;

public class InputReader {
    // Modos:

    private static Scanner sc = new Scanner(System.in);
    // Ler caracter para comandos
    public char lerChar() {
        try {
            String input = sc.nextLine().toLowerCase();
            return input.charAt(0);
        } catch (Exception e) {
            return ' ';
        }

    }
    // Ler string para nomes
    public String lerString() {
        try{
            String input = sc.nextLine();
            return input;
        } catch (Exception e) {
            return "";
        }

    }

    public int lerInt() {
        try {
            String input = sc.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            return -1;
        }
    }

}

