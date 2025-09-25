package controllers;

public class PointsController {
    private int points;

    public PointsController() {
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }
}
