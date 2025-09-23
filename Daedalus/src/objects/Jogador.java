package objects;

import model.Inventario;
import structures.Coordenada;

public class Jogador extends Tile{
    private Inventario inventario;

    public Jogador(char symbol, Coordenada position, Inventario inventario) {
        super(symbol, position, true);
        this.inventario = inventario;
    }

    public boolean tryWalk(Tile tile) {
        if (tile instanceof Porta) {
            return ((Porta) tile).tryWalk(inventario.top());
        }
        return tile.tryWalk();
    }

}
