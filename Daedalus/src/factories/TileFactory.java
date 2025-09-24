package factories;

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

            char[] caracteresRestritos = {'S', 'E', 'T'}; // Estes caracteres não podem ser portas ou chaves

            char restrictedUpperSymbol = Character.toUpperCase(symbol);

            boolean isRestricted = false;
            for (char c : caracteresRestritos) {
                if (c == restrictedUpperSymbol) {
                    isRestricted = true;
                    break;
                }
            }

            if (Character.isUpperCase(symbol) && !isRestricted) {
                return new objects.Porta(symbol, position);
            }
            
            if (Character.isLowerCase(symbol) && !isRestricted) {
                return new objects.Chave(symbol, position);
            }

            throw new IllegalArgumentException("Símbolo desconhecido: " + symbol + " na posição " + position.toString());
    }
}
