package app;

import controllers.GameController;

public class Main {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
