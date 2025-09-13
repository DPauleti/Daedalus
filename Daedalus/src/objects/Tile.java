package objects;
import structures.Coordenada;

public abstract class Tile {
    protected char symbol;
    protected Coordenada position;
    protected boolean walkable;
    public char getSymbol() {
        return symbol;
    }
    public Coordenada getPosition() {
        return position;
    }
    public boolean tryWalk() {
        return walkable;
    }
    public Tile(char symbol, Coordenada position, boolean walkable) {
        this.symbol = symbol;
        this.position = position;
        this.walkable = walkable;
    }
}
