package objects;

public abstract class PointsItem extends Item{
    private int points;
    public PointsItem(char symbol, structures.Coordenada position, int points) {
        super(symbol, position);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
    
}
