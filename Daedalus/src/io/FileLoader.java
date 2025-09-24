package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    private int rows;
    private int cols;
    private int inventorySize;
    private char[][] mapData;

    public FileLoader(String mapFile) {
        loadParameters(mapFile);
        loadMap(mapFile);
    }

    public void loadParameters(String mapFile) {
        try {
            File file = new File(mapFile);
            Scanner scanner = new Scanner(file);
            cols = scanner.nextInt();
            rows = scanner.nextInt();
            mapData = new char[rows][cols];
            inventorySize = scanner.nextInt();
            // Implementar verificação de mapa válido: uma entrada, uma saída, cada porta tem uma chave correspondente, etc.

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading the map file.");
            e.printStackTrace();
        }
    }

    public void loadMap(String mapFile) {
        try {
            File file = new File(mapFile);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    char symbol = line.charAt(j);
                    mapData[i][j] = symbol;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading the map file.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Map data is inconsistent with specified dimensions.");
            e.printStackTrace();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public char[][] getMapData() {
        return mapData;
    }

    public void printMap() { // Debug: imprime mapa
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mapData[i][j]);
            }
            System.out.println();
        }
    }
}