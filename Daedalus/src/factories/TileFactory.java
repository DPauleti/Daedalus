package factories;

import objects.Tile;

public abstract class TileFactory {
    public static Tile createTile(char symbol, structures.Coordenada position) {
        switch (symbol) {
            case '#':
                return new objects.Parede(position);
            case '.':
                return new objects.Chao(position);
            case 'P':
                return new objects.Porta(symbol, position);
            case 'S':
                return new objects.Start(position); 
            case 'p':
                return new objects.Chave(symbol, position);
            case 'T':
                return new objects.Armadilha(position);
            case '$':
                return new objects.Tesouro(position);
            default:
                throw new IllegalArgumentException("Símbolo desconhecido: " + symbol + " na posição " + position.toString());
        }
    }
}
