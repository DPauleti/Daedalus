package app;

import java.io.File;

import controllers.MenuController;
import controllers.PlayerController;
import factories.*;
import io.*;
import model.*;
import validation.LabirintoValidator;

public class Game {
    private FileLoader fileLoader;
    private Mapa mapa;
    private Labirinto labirinto;
    private PlayerController playerController;
    private char playerSymbol = '@';
    private MenuController menuController;
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.initializeMap("src/labirintos/labirinto1.txt");
            game.initializePlayer();
            game.drawMap();
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o jogo: " + e.getMessage());
        }
    }

    public Game() {
        
    }

    public void initializeMap(String mapFile) throws Exception {
        this.fileLoader = new FileLoader(mapFile);
        this.labirinto = LabirintoFactory.createLabirinto(fileLoader.getRows(), fileLoader.getCols(), fileLoader.getMapData());
        LabirintoValidator.validate(labirinto);
        this.mapa = new Mapa(labirinto);
        //mapa.displayMapa();
    }

    public void initializeMenu() {
        this.menuController = new MenuController();
        menuController.nome();
    }

    public void initializePlayer() {
        this.playerController = new PlayerController(labirinto, fileLoader.getInventorySize());
        this.playerController.setPlayerPosition(playerController.getStartPosition());
    }

    public void drawMap() {
        mapa.drawPlayer(playerController.getPlayerPosition(), playerSymbol);
        mapa.displayMapa();
    }
}
