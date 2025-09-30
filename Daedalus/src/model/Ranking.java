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

    public ScoreEntry[] getEntries() {
      return entries;
    }
}
