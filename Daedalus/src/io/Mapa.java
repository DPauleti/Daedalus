package io;

import model.Labirinto;
import structures.Coordenada;

public class Mapa {
    private char[][] mapaVisual;
    private Labirinto labirinto;

    public Mapa(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.mapaVisual = new char[labirinto.getRows()][labirinto.getCols()];
        gerarMapaVisual(labirinto);
    }

    public void gerarMapaVisual(Labirinto labirinto) {
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

    public void drawPlayer(Coordenada position, char symbol) {
        gerarMapaVisual(labirinto); // Redesenha o mapa para limpar a posição anterior do jogador
        mapaVisual[position.getX()][position.getY()] = symbol;
    }
}
