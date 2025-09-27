package controllers;

import model.Inventario;
import model.Labirinto;
import objects.Chave;
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

    public boolean move(Coordenada position) {
        if (tryWalk(labirinto.getTileAt(position))) {
            setPlayerPosition(position);
            return true;
        } // Implementar feedback de movimento inválido
        return false;
    }

    public boolean commandInput(String command) {
        if (command.equals("up")) {
            return move(new Coordenada(getPlayerPosition().getX(), getPlayerPosition().getY() - step));
        } else if (command.equals("down")) {
            return move(new Coordenada(getPlayerPosition().getX(), getPlayerPosition().getY() + step));
        } else if (command.equals("left")) {
            return move(new Coordenada(getPlayerPosition().getX() - step, getPlayerPosition().getY()));
        } else if (command.equals("right")) {
            return move(new Coordenada(getPlayerPosition().getX() + step, getPlayerPosition().getY()));
        }
        if (command.equals("invalid")) {
            return false;
        }
        return false; // Comando inválido
    }

    public boolean tryWalk(Tile tile) {
        if (tile == null) return false; // Não pode andar em uma tile inexistente
        if (tile instanceof Porta) // Lógica para portas
            if (((Porta) tile).tryWalk(inventario.top())) {
                inventario.pop(); // Remove a chave do inventário
                return true;
            }
            else return false;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void collectChave(Chave chave) {
        inventario.push(chave);
    }

    public Tile getPlayerTile() {
        return labirinto.getTileAt(playerPosition);
    }

}