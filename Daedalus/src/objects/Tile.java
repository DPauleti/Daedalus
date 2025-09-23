package objects;
import structures.Coordenada;

public abstract class Tile {
    protected char symbol;
    protected Coordenada position;
    protected boolean walkable;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public Coordenada getPosition() {
        return position;
    }

    public void setPosition(Coordenada position) {
        this.position = position;
    }

    public boolean tryWalk() {
        return walkable;
    }

    public void setPositionNull() {
        this.position = Coordenada.nullCoord();
    }

    public Tile(char symbol, Coordenada position, boolean walkable) {
        this.symbol = symbol;
        this.position = position;
        this.walkable = walkable;
    }
}
