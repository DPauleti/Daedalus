package app;

import factories.*;
import io.*;
import model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileLoader fileLoader = new FileLoader("src/app/labirinto.txt");
        Labirinto labirinto = LabirintoFactory.createLabirinto(fileLoader.getRows(), fileLoader.getCols(), fileLoader.getMapData());
        Mapa mapa = new Mapa(labirinto);

        mapa.displayMapa();
    }
}
