package app;

import controllers.MenuController;
import controllers.PlayerController;
import factories.*;
import io.*;
import model.*;
import objects.Chave;
import validation.LabirintoValidator;

public class Game {
    private FileLoader fileLoader;
    private Mapa mapa;
    private Labirinto labirinto;
    private PlayerController playerController;
    private char playerSymbol = '@';
    private MenuController menuController;
    private boolean gameActive = true;
    public static void main(String[] args) {
        Game game = new Game();
        try { 
            game.initializeGame("src/labirintos/labirinto1.txt");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o jogo: " + e.getMessage());
        }

        game.initialPrints();
        game.gameActive = true;

        while (game.gameActive) {
            game.drawMap();
            System.out.println();
            String comando = game.menuController.comando();
            if (comando.equals("invalid")) {
                System.out.println("Comando inválido! Use W, A, S, D para se mover.");
                continue;
            }
            boolean moved = game.playerController.commandInput(comando);
            if (moved) {
                // Check for exit
                // Subtract walking points
                // Check for item interaction
                // Log item interaction
            } else {
                System.out.println("Movimento inválido! Tente outra direção.");
            }
            System.out.println();
        }

    }

    public Game() {
        
    }

    public void initializeGame(String mapFile) throws Exception {
        initializeMenu();
        initializeMap(mapFile);
        initializePlayer();
    }

    public void initialPrints() {
        menuController.nome();
        System.out.println();
        menuController.instrucoes();
        System.out.println();
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
