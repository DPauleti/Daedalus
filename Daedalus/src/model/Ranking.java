package model;

import structures.Matriz;
import structures.ScoreEntry;

import java.util.Arrays;

public class Ranking {
    private ScoreEntry[] entries;

    public Ranking() {
        this.entries = new ScoreEntry[99]; // Guarda 99 pontuações
    }

    public void addEntry(ScoreEntry entry) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                entries[i] = entry;
                return;
            }
        }
        System.out.println("Ranking cheio! Não é possível adicionar mais entradas.");

    }

    // Ordenação por Insertion Sort (pontuação decrescente)
    public void insertionSort() {
        for (int i = 1; i < entries.length; i++) {
            ScoreEntry key = entries[i];
            if (key == null) continue;

            int j = i - 1;
            while (j >= 0 && entries[j].getPontuacao() < key.getPontuacao()) {
                entries[j + 1] = entries[j];
                j--;
            }
            entries[j + 1] = key;
        }
    }

    public void quickSort() {
        quickSort(0, entries.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = entries[high].getPontuacao();

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (entries[j].getPontuacao() >= pivot) {
                i++;
                trocar(i, j);
            }
        }
        trocar(i + 1, high);
        return i + 1;
    }

    private void trocar(int i, int j) {
        ScoreEntry temp = entries[i];
        entries[i] = entries[j];
        entries[j] = temp;
    }

    // Busca linear por nome
    public void binarySearchByName(String nome) {
        ScoreEntry[] copia = Arrays.copyOf(entries, entries.length);

        // insertion sort por nome
        for (int i = 1; i < copia.length; i++) {
            ScoreEntry key = copia[i];
            int j = i - 1;
            while (j >= 0 && copia[j].getNome().compareToIgnoreCase(key.getNome()) > 0) {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = key;
        }

        int left = 0;
        int right = copia.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = copia[mid].getNome().compareToIgnoreCase(nome);
            if (cmp == 0) {
                System.out.println("Encontrado: " + copia[mid]);
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Jogador '" + nome + "' não encontrado.");
    }

    public void printRanking() {
        System.out.println("Ranking de Pontuações:");
        for (ScoreEntry entry : entries) {
            if (entry != null) {
                System.out.println(entry.getNome() + ": " + entry.getPontuacao());
            }
        }
    }
}
