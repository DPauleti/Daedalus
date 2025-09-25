package controllers;

import io.*;

public class MenuController {
    private Menu menu;
    private InputReader input;

    public MenuController() {
        this.menu = new Menu();
        this.input = new InputReader();
    }

    public void iniciar() {
        menu.nickname();
        String nome = input.lerString();
        menu.telaInicial(nome);
    }
}