package objects;
import structures.Coordenada;

public class Tesouro extends Item{
    public Tesouro(Coordenada position) {
        super('$', position);
    }
    public void onTouch() {
        return;
    }
    
}
