package objects;

import core.Tile;

public abstract class Item extends Tile{
    public abstract void onTouch();
    public Item(char symbol, structures.Coordenada position) {
        super(symbol, position, true);
    }
}
