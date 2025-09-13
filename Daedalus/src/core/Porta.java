package objects;
import core.Tile;
import model.Inventario;
import structures.Coordenada;


public class Porta extends Tile{
    private Chave chave;
    public Porta(char symbol, Coordenada position) {
        super(symbol, position, false);
    }
    public Porta(char symbol, Coordenada position, Coordenada keyPosition){
        super(symbol, position, false);
        this.chave = new Chave(Character.toLowerCase(symbol), keyPosition);
    }
    public boolean tryWalk() {
        Chave topKey = Inventario.pop();
    }
    public void unlock() {
        return;
    }

}
