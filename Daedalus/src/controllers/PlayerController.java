package controllers;

import model.Inventario;
import model.Labirinto;
import objects.Jogador;
import objects.Porta;
import objects.Tile;
import structures.Coordenada;

public class PlayerController {
    private Jogador jogador;
    private Labirinto labirinto;
    private int step;
    private Inventario inventario;

    public PlayerController(Jogador jogador, Labirinto labirinto) {
        this.jogador = jogador;
        this.labirinto = labirinto;
        this.step = 1;
    }

    public void move(Coordenada position) {
        if (tryWalk(labirinto.getTileAt(position))) {
            jogador.setPosition(position);
        } // Implementar feedback de movimento inválido
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

    public boolean tryWalk(Tile tile) {
        if (tile instanceof Porta) return ((Porta) tile).tryWalk(inventario.top());
        return tile.tryWalk();
    }
}