package structures;

public class Coordenada {
    private int x;
    private int y;
    
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public static Coordenada nullCoord() {
        return new Coordenada(-1, -1);
    }

    public static Coordenada toCoord(int x, int y) {
        return new Coordenada(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
