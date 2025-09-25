package controllers;

import io.*;

public class MenuController {
    private Menu menu;
    private InputReader input;

    public MenuController() {
        this.menu = new Menu();
        this.input = new InputReader();
    }

    public void nome() {
        menu.nickname();
        String nome = input.lerString();
        menu.telaInicial(nome);
    }

    public char lerComando() {
        return input.lerChar();
    }

    public String comando() {
        char playerInput = lerComando();
        switch (playerInput) {
        case 'w':
            return "up";
        case 'a':
            return "left";
        case 's':
            return "down";
        case 'd':
            return "right";
        }
        return "invalid";
    }
}