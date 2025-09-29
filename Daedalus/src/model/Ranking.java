package model;

import structures.ScoreEntry;

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
        for (int i = entries.length - 1; i >= 0; i--)
            if (entries[i] != null) {
                quickSort(0, i); // define o low e o high (primeiro e o último elemento)
            }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1); // atualiza o high
            quickSort(pi + 1, high); // atualiza o low
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
    public int binarySearchByName(String nome) {
        int count = 0;
        for (ScoreEntry entry : entries) {
            if (entry != null) count++;
        }

        ScoreEntry[] copia = new ScoreEntry[count];
        int idx = 0;
        for (ScoreEntry entry : entries) {
            if (entry != null) {
                copia[idx++] = entry;
            }
        }

        int left = 0;
        int right = copia.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = copia[mid].getNome().compareToIgnoreCase(nome);
            if (compare == 0) {
                for (int i = 0; i < entries.length; i++) {
                    if (entries[i] != null && entries[i].equals(copia[mid])) {
                        System.out.println("Encontrado: " + entries[i].getNome() + " com pontuação " + entries[i].getPontuacao());
                        return i;
                    }
                }
            return -1;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        System.out.println("Jogador '" + nome + "' não encontrado.");
        return -1;
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
