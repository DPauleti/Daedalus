package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Ranking;
import structures.ScoreEntry;

public class RankingController {
  
  private Ranking ranking;
  
  public RankingController(Ranking ranking) {
    this.ranking = ranking;
  }   
  
  public void salvarPontuacao(String nome, int pontuacao) {
    ScoreEntry entry = new ScoreEntry(nome, pontuacao);
    ranking.addEntry(entry);
  }
  
    public void printRanking() {
        System.out.println("Ranking de Pontuações:");
        for (ScoreEntry entry : ranking.getEntries()) {
            if (entry != null) {
                System.out.println(entry.getNome() + ": " + entry.getPontuacao());
            }
        }
    }
  
  // Ordenação por Insertion Sort (pontuação decrescente)
  public void insertionSort() {
    for (int i = 1; i < ranking.getEntries().length; i++) {
      ScoreEntry key = ranking.getEntries()[i];
      if (key == null) continue;
      int j = i - 1;
      
      while (j >= 0 && ranking.getEntries()[j].getPontuacao() < key.getPontuacao()) {
        ranking.getEntries()[j + 1] = ranking.getEntries()[j];
        j--;
      }
      ranking.getEntries()[j + 1] = key;
    }
  }
  
  public void quickSort() {
    for (int i = ranking.getEntries().length - 1; i >= 0; i--)
    if (ranking.getEntries()[i] != null) {
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
    int pivot = ranking.getEntries()[high].getPontuacao();
    
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (ranking.getEntries()[j].getPontuacao() >= pivot) {
        i++;
        trocar(i, j);
      }
    }
    trocar(i + 1, high);
    return i + 1;
  }
  
  private void trocar(int i, int j) {
    ScoreEntry temp = ranking.getEntries()[i];
    ranking.getEntries()[i] = ranking.getEntries()[j];
    ranking.getEntries()[j] = temp;
  }
  
  // Busca linear por nome
  public int binarySearchByName(String nome) {
    int count = 0;
    for (ScoreEntry entry : ranking.getEntries()) {
      if (entry != null) count++;
    }
    
    ScoreEntry[] copia = new ScoreEntry[count];
    int idx = 0;
    for (ScoreEntry entry : ranking.getEntries()) {
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
        for (int i = 0; i < ranking.getEntries().length; i++) {
          if (ranking.getEntries()[i] != null && ranking.getEntries()[i].equals(copia[mid])) {
            System.out.println("Encontrado: " + ranking.getEntries()[i].getNome() + " com pontuação " + ranking.getEntries()[i].getPontuacao());
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
  
  public void saveToCSV(String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write("Nome,Pontuacao"); // Cabeçalho
      writer.newLine();
      for (ScoreEntry entry : ranking.getEntries()) {
        if (entry != null) {
          writer.write(entry.getNome() + "," + entry.getPontuacao());
          writer.newLine();
        }
      }
      System.out.println("Ranking salvo em: " + filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void loadFromCSV(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = reader.readLine(); // Ignora cabeçalho
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          String nome = parts[0];
          int pontuacao = Integer.parseInt(parts[1]);
          ranking.addEntry(new ScoreEntry(nome, pontuacao));
        }
      }
      System.out.println("Ranking carregado de: " + filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }   
}
