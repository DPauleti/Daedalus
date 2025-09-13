package objects;
import structures.Coordenada;


public class Porta extends Tile{
    private Chave chave;
    public Porta(char symbol, Coordenada position, Chave chave){
        super(symbol, position, false);
        this.chave = chave;
    }
    public Porta(char symbol, Coordenada position, Coordenada keyPosition){
        super(symbol, position, false);
        this.chave = new Chave(Character.toLowerCase(symbol), keyPosition);
    }
    public boolean tryWalk() {
        Inventario inventario = Inventario.getInstance();
    }
    public void unlock() {
        return;
    }

}
