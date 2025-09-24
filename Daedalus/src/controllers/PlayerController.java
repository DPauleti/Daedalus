package controllers;

import model.Inventario;
import model.Labirinto;
import objects.Porta;
import objects.Tile;
import structures.Coordenada;

public class PlayerController {
    private Coordenada playerPosition;
    private Labirinto labirinto;
    private int step;
    private Inventario inventario;

    public PlayerController(Labirinto labirinto, int inventorySize) {
        this.labirinto = labirinto;
        this.playerPosition = getStartPosition();
        this.step = 1;
        this.inventario = new Inventario(inventorySize);
    }

    public void move(Coordenada position) {
        if (tryWalk(labirinto.getTileAt(position))) {
            setPlayerPosition(position);
        } // Implementar feedback de movimento inválido
    }

    public boolean commandInput(String command) {
        if (command == "up") {
            move(new Coordenada(getPlayerPosition().getX() - step, getPlayerPosition().getY()));
            return true;
        } else if (command == "down") {
            move(new Coordenada(getPlayerPosition().getX() + step, getPlayerPosition().getY()));
            return true;
        } else if (command == "left") {
            move(new Coordenada(getPlayerPosition().getX(), getPlayerPosition().getY() - step));
            return true;
        } else if (command == "right") {
            move(new Coordenada(getPlayerPosition().getX(), getPlayerPosition().getY() + step));
            return true;
        }
        return false; // Comando inválido
    }

    public boolean tryWalk(Tile tile) {
        if (tile instanceof Porta) return ((Porta) tile).tryWalk(inventario.top());
        return tile.tryWalk();
    }

    public Coordenada getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Coordenada position) {
        playerPosition = position;
    }

    public Coordenada getStartPosition() {
        for (int i = 0; i < labirinto.getRows(); i++) {
            for (int j = 0; j < labirinto.getCols(); j++) {
                Tile tile = labirinto.getTileAt(new Coordenada(i, j));
                if (tile instanceof objects.Start) {
                    return new Coordenada(i, j);
                }
            }
        }
        return Coordenada.nullCoord(); // Retorna uma coordenada nula se não encontrar o ponto de início
    }

}