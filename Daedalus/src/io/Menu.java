package io;

public class Menu {
    public void telaInicial(String nome) {
        System.out.println("DAEDALUS");
        System.out.println("Bem-Vindo, "+ nome + "!");
    }
    public void exibirComando(String comando) {
        System.out.println("Você andou para " + comando + "!");
    }
    public void instrucao() {
        System.out.println("[W], [A], [S], [D] para mover");
    }
    public void nickname() {
        System.out.println("Digite seu nome: ");
    }
    



}
