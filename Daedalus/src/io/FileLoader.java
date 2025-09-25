package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    private int rows;
    private int cols;
    private int inventorySize;
    private char[][] mapData;

    public FileLoader(String mapFile) throws Exception {
        try {
            loadParameters(mapFile);
            loadMap(mapFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public void loadParameters(String mapFile) throws Exception {
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
            System.out.println("O arquivo especificado não pode ser lido.");
            e.printStackTrace();
            throw e;
        }
    }

    public void loadMap(String mapFile) throws Exception {
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
            System.out.println("O arquivo especificado não pode ser lido.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("As dimensões do mapa não correspondem aos dados fornecidos.");
            e.printStackTrace();
            throw e;
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