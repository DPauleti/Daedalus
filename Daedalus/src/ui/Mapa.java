package ui;

import model.Labirinto;
import structures.Coordenada;

public class Mapa {
    private Labirinto labirinto;
    private char[][] mapaVisual;

    public Mapa(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.mapaVisual = new char[labirinto.getRows()][labirinto.getCols()];
        initializeMapaVisual();
    }

    public void initializeMapaVisual() {
        for (int j = 0; j < labirinto.getCols(); j++) {
            for (int i = 0; i < labirinto.getRows(); i++) {
                mapaVisual[i][j] = labirinto.getCharAt(Coordenada.toCoord(i, j));
            }
        }
    }

    public void displayMapa() {
        for (int i = 0; i < mapaVisual.length; i++) {
            for (int j = 0; j < mapaVisual[i].length; j++) {
                //System.out.println("("+j + "," + i + "): "); // Debug: imprime coordenadas e caracteres
                System.out.print(mapaVisual[i][j]);
            }
            System.out.println();
        }
    }
}
