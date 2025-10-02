package controllers;

import io.*;

public class MenuController {
    private Menu menu;
    private InputReader input;
    private String nome;
    
    public MenuController() {
        this.menu = new Menu();
        this.input = new InputReader();
    }
    
    public void nome() {
        menu.nickname();
        this.nome = input.lerString();
    }
    
    public char lerComando() {
        return input.lerChar();
    }
    
    public void instrucoes() {
        menu.instrucao();
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
            case 'i':
            return "inventory";
        }
        return "invalid";
    }
    
    public void points(int points) {
        if (points > 0) menu.gainPoints(points);
        if (points < 0) menu.losePoints(-points);
    }
    
    public void inventory(String inventario) {
        menu.inventory(inventario);
    }
    
    public void invalid() {
        menu.invalid();
    }
    
    public void chave(char chave) {
        menu.chave(chave);
    }
    
    public void gameEnd(int points, int turns) {
        menu.gameEnd(points, turns);
    }
    
    public void displayLog(String log) {
        menu.logPrompt();
        if (Character.toLowerCase(input.lerChar()) == 's') menu.displayLog(log);
    }
    
    public String getNome() {
        if (nome == null) return "";
        return nome;
    }
    
    public void showHUD(String player, int points) {       
        menu.showPoints(player, points);
        System.out.println();
    }
    
    public void movimentoInvalido() {
        menu.movimentoInvalido();
    }

    public boolean saveScore() {
        menu.scorePrompt();
        if (Character.toLowerCase(input.lerChar()) == 's') return true;
        return false;
    }

    public char mainMenu() {
        menu.telaInicial(nome);
        menu.mainMenu();
        return lerComando();
    }

    public void exit() {
        menu.exit();
    }
}