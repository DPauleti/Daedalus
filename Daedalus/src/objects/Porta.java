package objects;
import structures.Coordenada;


public class Porta extends Item{
    private Chave chave;

    public Porta(char symbol, Coordenada position){
        super(symbol, position, false);
    }

    public Porta(char symbol, Coordenada position, Chave chave){
        super(symbol, position, false);
        this.chave = chave;
    }
    
    public boolean tryWalk(Chave topChave) {
        if (topChave != null && topChave == chave) {
            this.unlock(); // Destranca a porta
        }
        return walkable;
    }

    public void unlock() {
        super.onTouch(); // Virar chão
        this.setWalkable(true); // Torna a porta caminhável
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }

    public Chave getChave() {
        return chave;
    }

}
