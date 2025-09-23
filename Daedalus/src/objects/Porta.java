package objects;
import structures.Coordenada;


public class Porta extends Tile{
    private Chave chave;
    public Porta(char symbol, Coordenada position, Chave chave){
        super(symbol, position, false);
        this.chave = chave;
    }
    public boolean tryWalk(Chave topChave) {
        if (topChave != null && topChave.getSymbol() == this.chave.getSymbol()) {
            this.unlock(); // Destranca a porta
        }
        return walkable;
    }
    public void unlock() {
        super.setPositionNull(); // Remove a porta do mapa
        this.setWalkable(true); // Torna a porta caminhável
    }

}
