package app;

import controllers.*;
import factories.*;
import io.*;
import model.*;
import objects.*;
import validation.LabirintoValidator;

public class Game {
    private FileLoader fileLoader;
    private Mapa mapa;
    private Labirinto labirinto;
    private PlayerController playerController;
    private GamestateController gamestateController;
    private char playerSymbol = '@';
    private MenuController menuController;
    private boolean gameActive = true;
    public static void main(String[] args) {
        Game game = new Game();
        try { 
            game.initializeGame("src/labirintos/labirinto1.txt");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o jogo: " + e.getMessage());
            return;
        }

        game.initialPrints();
        game.gameActive = true;

        while (game.gameActive) {
            System.out.println();
            game.drawMap();
            System.out.println();
            String comando = game.menuController.comando();
            if (comando.equals("invalid")) {
                game.menuController.invalid();
                continue;
            }
            if (comando.equals("inventory")) {
                game.menuController.inventory(game.playerController.getInventario().toString());
                continue;
            }
            boolean moved = game.playerController.commandInput(comando);
            if (moved) {                
                Tile tile = game.playerController.getPlayerTile();
                boolean interacted;
                if (tile instanceof Item) { // Check for item interaction
                    interacted = ((Item) tile).interacted();
                    if (tile instanceof Chave && interacted == false) {
                        game.playerController.collectChave(((Chave) tile)); // Add key to inventory
                        game.menuController.chave(((Chave) tile).chave()); // Display key get message
                        // Log key collection
                    }
                    if (tile instanceof PointsItem && interacted == false){
                        game.menuController.points(((PointsItem) tile).getPoints()); // Display points message
                        game.gamestateController.addPoints(((PointsItem) tile).getPoints());// Alter points
                        // Log item interaction
                    }                    

                    // Log item interaction
                    ((Item) tile).interact(); // Interaction with item complete, prevent duplicate interactions
                    if (tile instanceof Exit) game.gameActive = false; // Implement game end logic
                }
                game.gamestateController.walk(); // Subtract walking points
                // Increment turn counter
            } else {
                System.out.println("Movimento inválido! Tente outra direção.");
            }

        }
        System.out.println();
        game.menuController.gameEnd(game.gamestateController.getPoints(), game.gamestateController.getTurn());



    }

    public Game() {
        
    }

    public void initializeGame(String mapFile) throws Exception {
        initializeMenu();
        initializeMap(mapFile);
        initializeGamestate();
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

    public void initializeGamestate() {
        this.gamestateController = new GamestateController();
    }

    public void drawMap() {
        mapa.drawPlayer(playerController.getPlayerPosition(), playerSymbol);
        mapa.displayMapa();
    }
}
