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
    private LogController logController;
    private RankingController rankingController;
    public static void main(String[] args) {
        Game game = new Game();
        try { 
            game.initializeGame("src/labirintos/labirinto1.txt");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o jogo: " + e.getMessage());
            return;
        }

        game.name();

        char input = game.mainMenu();
        do {
            if (input == '1') {
            game.instructions();
            game.runGame();
            game.end();
            }
            if (input == '2') {
            // Implementar funcionalidade do ranking

            }
            game.mainMenu();} 
        while (input != '3');
        game.menuController.exit();
    }

    public Game() {
        
    }

    public void initializeGame(String mapFile) throws Exception {
        initializeMenu();
        initializeMap(mapFile);
        initializeGamestate();
        initializeLog();
        initializeRanking();
        initializePlayer();
    }

    public void instructions() {
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

    public void initializeLog() {
        this.logController = new LogController();
    }

    public void initializeRanking() {
        this.rankingController = new RankingController();
    }

    public void initializeGamestate() {
        this.gamestateController = new GamestateController();
    }

    public void drawMap() {
        mapa.drawPlayer(playerController.getPlayerPosition(), playerSymbol);
        mapa.displayMapa();
    }

    public void drawHUD() {
        menuController.showHUD(menuController.getNome(), gamestateController.getPoints());
    }

    public void drawUI() {
        System.out.println();
        drawMap();
        drawHUD();
    }

    public void runGame() {
        gameActive = true;
        logController.startEntry(menuController.getNome());
        while (gameActive) {
            drawUI();
            String comando = menuController.comando();
            if (comando.equals("invalid")) {
                menuController.invalid();
                continue;
            }
            if (comando.equals("inventory")) {
                menuController.inventory(playerController.getInventario().toString());
                continue;
            }
            boolean moved = playerController.commandInput(comando);
            if (moved) {                
                Tile tile = playerController.getPlayerTile();
                boolean interacted;
                if (tile instanceof Item) { // Check for item interaction
                    interacted = ((Item) tile).interacted();
                    if (tile instanceof Chave && interacted == false) {
                        playerController.collectChave(((Chave) tile)); // Add key to inventory
                        menuController.chave(((Chave) tile).chave()); // Display key get message
                    }
                    if (tile instanceof PointsItem && interacted == false){
                        menuController.points(((PointsItem) tile).getPoints()); // Display points message
                        gamestateController.addPoints(((PointsItem) tile).getPoints());// Alter points
                    }                    

                    logController.itemEntry((Item) tile, gamestateController.getTurn(), menuController.getNome()); // Log item interaction
                    ((Item) tile).interact(); // Interaction with item complete, prevent duplicate interactions
                    if (tile instanceof Exit) gameActive = false; // Implement game end logic
                }
                gamestateController.walk(); // Subtract walking points and increment turn counter
            } else {
                menuController.movimentoInvalido();
            }

        }
        menuController.gameEnd(gamestateController.getPoints(), gamestateController.getTurn());
    }

    public void end() {
        menuController.displayLog(logController.getLog());
        rankingController.salvarPontuacao(menuController.getNome(), gamestateController.getPoints(), menuController.saveScore());
        menuController.rankingMenu();
    }

    public char mainMenu() {
        return menuController.mainMenu();
    }

    public void name() {
        menuController.nome();
    }
}
