package objects;

public abstract class Item extends Tile{
    public void onTouch() {
        super.setPositionNull();
    };
    public Item(char symbol, structures.Coordenada position) {
        super(symbol, position, true);
    }
}
