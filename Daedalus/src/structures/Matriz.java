package structures;

public class Matriz {
    private Object[][] grid;
    private int rows;
    private int cols;

    public Matriz(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Object[rows][cols];
    }

    public Object get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da matriz");
        }
        return grid[row][col];
    }

    public void set(int row, int col, Object object) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da matriz");
        }
        grid[row][col] = object;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
