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
        System.out.println("--------------------------------------------------------");

        System.out.println("[W], [A], [S], [D] para se mover");
        System.out.println("[I] para mostrar seu inventário \n");

        System.out.println("Paredes são '#', caminhos são '.'");
        System.out.println("Portas são letras maiúsculas, chaves são letras minúsculas");
        System.out.println("Tesouros são representados por '$', armadilhas por 'T'");
        System.out.println("Seu personagem é representado por '@'\n");

        System.out.println("Você só pode usar a última chave do seu inventário");
        System.out.println("Tente chegar à saída 'E' com a maior pontuação possível!");
        System.out.println("--------------------------------------------------------");

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

    public void gameEnd(int points, int turns) {
        System.out.println("Você chegou na saída em " + turns +" movimentos!");
        System.out.println("Pontuação final: " + points);
    }

    public void logPrompt() {
        System.out.println("Gostaria de ver o resumo do seu jogo? [s/n] ");
    }

    public void displayLog(String log) {
        System.out.println("Eventos do jogo: ");
        System.out.println(log);
    }

    public void showPoints(String player, int points) {
        System.out.printf("[" + player + " --- Pontos: " + "%03d" + "]", points);
    }

    public void movimentoInvalido() {
        System.out.println("Movimento inválido! Tente outra direção.");
    }

    public void mainMenu() {
        System.out.println("1. Jogar");
        System.out.println("2. Pontuações");
        System.out.println("3. Sair");
    }

    public void scorePrompt() {
        System.out.println("Deseja salvar sua pontuação no ranking? [s/n]");
    }

    public void rankingMenu() {
        System.out.println("\n--- MENU RANKING ---");
        System.out.println("1. Ver ranking");
        System.out.println("2. Buscar nome");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void exit() {
        System.out.println("Obrigado por jogar!");
    }

}
