package objects;

import model.Inventario;
import structures.Coordenada;

public class Jogador {
    private Coordenada position;
    private Inventario inventario;

    public boolean tryWalk(Tile tile) {
        if (tile instanceof Porta) {
            return ((Porta) tile).tryWalk(inventario.top());
        }
        return tile.tryWalk();
    }


}
