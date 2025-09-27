package factories;

import model.Labirinto;
import structures.Coordenada;

public abstract class LabirintoFactory {
    public static Labirinto createLabirinto(int rows, int cols, char[][] layout) {
        Labirinto labirinto = new Labirinto(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char symbol = layout[i][j];
                Coordenada position = Coordenada.toCoord(j, i);
                labirinto.setTileAt(position, TileFactory.createTile(symbol, position));
            }
        }
        return labirinto;
    }
}
