package factories;

import java.util.List;

import objects.Tile;

public abstract class TileFactory {
    public static Tile createTile(char symbol, structures.Coordenada position) {
        switch (symbol) {
            case '#':
                return new objects.Parede(position);
            case '.':
                return new objects.Chao(position);
            case 'S':
                return new objects.Start(position);
            case 'E':
                return new objects.Exit(position);
            case 'T':
                return new objects.Armadilha(position);
            case '$':
                return new objects.Tesouro(position);
            }

            List<Character> caracteresRestritos = List.of('S', 'E', 'T'); // Estes caracteres não representam portas ou chaves

            char restrictedUpperSymbol = Character.toUpperCase(symbol);

            if (Character.isUpperCase(symbol) && !caracteresRestritos.contains(restrictedUpperSymbol)) {
                return new objects.Porta(symbol, position);
            }
            
            if (Character.isLowerCase(symbol) && !caracteresRestritos.contains(restrictedUpperSymbol)) {
                return new objects.Chave(symbol, position);
            }

            throw new IllegalArgumentException("Símbolo desconhecido: " + symbol + " na posição " + position.toString());
    }
}
