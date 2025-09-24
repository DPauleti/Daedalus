package model;

import objects.Tile;
import structures.Coordenada;
import structures.Matriz;

public class Labirinto extends Matriz {
    public Labirinto(int rows, int cols) {
        super(rows, cols);
    }

    public boolean isValidPosition(Coordenada position) {
        try {
            get(position.getX(), position.getY());
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Tile getTileAt(Coordenada position) {
        if (!isValidPosition(position)) {
            return null;
        }
        return (Tile) get(position.getX(), position.getY());
    }

    public char getCharAt(Coordenada position) {
        if (!isValidPosition(position)) return ' '; // Retorna um espaço se a posição for inválida
        Tile tile = getTileAt(position);
        if (tile != null) return tile.getSymbol();
        return '.'; // Retorna um ponto se não houver tile
    }

    public void setTileAt(Coordenada position, Tile tile) {
        if (isValidPosition(position)) {
            set(position.getX(), position.getY(), tile);
        }
    }

}
