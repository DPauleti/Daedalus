package objects;
import core.Item;
import structures.Coordenada;

public class Chave extends Item{
    public Chave(char symbol, Coordenada position) {
        super(symbol, position);
    }
    public void onTouch() {
        return;
    }
}
