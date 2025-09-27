package io;

public class Menu {
    public void telaInicial(String nome) {
        System.out.println();
        System.out.println("DAEDALUS");
        System.out.println("Bem-Vindo, "+ nome + "!");
    }
    public void exibirComando(String comando) {
        System.out.println("Você andou para " + comando + "!");
    }
    public void instrucao() {
        System.out.println("[W], [A], [S], [D] para se mover");
        System.out.println("[I] para mostrar seu inventário");

        System.out.println("Paredes são '#', caminhos são '.'");
        System.out.println("Portas são letras maiúsculas, chaves são letras minúsculas");
        System.out.println("Tesouros são representados por '$', armadilhas por 'T'");
        System.out.println("Seu personagem é representado por '@'");

        System.out.println("Você só pode usar a última chave do seu inventário");
        System.out.println("Tente chegar à saída 'E' com a maior pontuação possível!");

    }
    public void nickname() {
        System.out.print("Digite seu nome: ");
    }

    public void gainPoints(int points) {
        System.out.println("Você ganhou " + points + " pontos!");
    }

    public void losePoints(int points) {
        System.out.println("Você perdeu " + points + " pontos!");
    }

    public void inventory(String inventory) {
        System.out.println(inventory);
    }

    public void invalid() {
        System.out.println("Comando inválido! Use W, A, S, D para se mover e I para acessar seu inventário.");
    }

    public void chave(char chave) {
        System.out.println("Você coletou a chave " + chave + "!");
    }



}
