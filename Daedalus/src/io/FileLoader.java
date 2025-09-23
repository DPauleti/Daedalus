package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import factory.TileFactory;
import model.Labirinto;
import objects.Tile;
import ui.Mapa;

public class FileLoader {
    private Labirinto labirinto;
    private Mapa mapa;

    public FileLoader(String mapFile) {
        this.labirinto = null;
        this.mapa = null;
        loadLabirinto(mapFile);
        loadMapa(mapFile);
    }

    public Labirinto loadLabirinto(String mapFile) {
        try {
            File file = new File(mapFile);
            Scanner scanner = new Scanner(file);
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            this.labirinto = new Labirinto(rows, cols);
            // Implementar leitura do tamanho do inventário
            scanner.nextLine();
            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    char symbol = line.charAt(j);

                    labirinto.setTileAt(i, j, TileFactory.createTile(symbol, new structures.Coordenada(i, j)));
                }

            } // Implementar verificação de mapa válido: uma entrada, uma saída, cada porta tem uma chave correspondente, etc.

            this.mapa = new Mapa(labirinto);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading the map file.");
            e.printStackTrace();
        }
    }

    public Labirinto getLabirinto() {
        return labirinto;
    }

    public void loadMapa(String mapFile) {

    }

    public Mapa getMapa() {
        return mapa;
    }
}