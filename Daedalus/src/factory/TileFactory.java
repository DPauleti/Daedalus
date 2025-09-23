package factory;

import objects.Tile;

public abstract class TileFactory {
    public static Tile createTile(char symbol, structures.Coordenada position) {
        switch (symbol) {
            case '#':
                return new objects.Parede(position);
            case '.':
                return new objects.Chao(position);
            case '':
                return new objects.Porta(symbol, position);
            case 'S':
                return new objects.Jogador(symbol, position); // Jogador criado com símbolo 'S' por default, deve ser alterado depois
                                                              // Compilar lista de símbolos permitidos para jogador com base nas portas presentes
            case '':
                return new objects.Chave(symbol, position);
            case 'T':
                return new objects.Armadilha(position);
            default:
                throw new IllegalArgumentException("Símbolo desconhecido: " + symbol);
        }
    }
}
