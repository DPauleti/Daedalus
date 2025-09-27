package objects;
import structures.Coordenada;

public class Chave extends Item{
    private char chave;
    public Chave(char symbol, Coordenada position) {
        super(symbol, position);
        this.chave = symbol;
    }

    public char chave() {
        return chave;
    }

}
