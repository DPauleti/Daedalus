package controllers;

public class GamestateController {
    private int points;
    private int turn;
    private int walkCost = 1;

    public GamestateController() {
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void walk() {
        addPoints(-walkCost);
        nextTurn();
    }

    public int getTurn () {
        return turn;

    }

    public void nextTurn() {
        turn++;
    }
}
