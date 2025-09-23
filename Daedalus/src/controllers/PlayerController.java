package controllers;

import model.Labirinto;
import objects.Jogador;
import structures.Coordenada;

public class PlayerController {
    private Jogador jogador;
    private Labirinto labirinto;
    private int step;

    public PlayerController(Jogador jogador, Labirinto labirinto) {
        this.jogador = jogador;
        this.labirinto = labirinto;
        this.step = 1;
    }

    public void move(Coordenada position) {
        
    }

    public boolean commandInput(char command) {
        if (command == 'w') {
            move(new Coordenada(jogador.getPosition().getX() - step, jogador.getPosition().getY()));
            return true;
        } else if (command == 's') {
            move(new Coordenada(jogador.getPosition().getX() + step, jogador.getPosition().getY()));
            return true;
        } else if (command == 'a') {
            move(new Coordenada(jogador.getPosition().getX(), jogador.getPosition().getY() - step));
            return true;
        } else if (command == 'd') {
            move(new Coordenada(jogador.getPosition().getX(), jogador.getPosition().getY() + step));
            return true;
        }
        return false; // Comando inválido
    }
}