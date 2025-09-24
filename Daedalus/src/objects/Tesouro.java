package objects;
import structures.Coordenada;

public class Tesouro extends Item{
    public int value;
    public Tesouro(Coordenada position) {
        super('$', position);
    }
    public void onTouch() {
        return;
    }
    public int getValue() {
        return value;
    }
    
}
