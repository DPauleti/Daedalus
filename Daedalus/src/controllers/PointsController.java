package controllers;

import java.util.Random;

public class PointsController {
    int points;
    public int pointsArmadilha() {
        points -= 20;
        return points;
    }

    public int pointsPorta() {
        points += 15;
        return points;
    }
    public int pointsTesouro(Random random) {
        int maxPoints = 10;
        int minPoints = 50;
        points += random.nextInt((maxPoints - minPoints) + 1) + minPoints;
        return points;
    } 
    public int pointsFinish(){
        points+=100;
        return points;
    }
}
