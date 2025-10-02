package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Ranking;
import structures.ScoreEntry;
import io.InputReader;
import io.Menu;

public class RankingController {
  
  private Ranking ranking;
  private Menu menu;
  private InputReader input;
  private int opcao;
  private boolean loaded;
  private boolean sorted;
  
  public RankingController() {
    this.ranking = new Ranking();
    this.menu = new Menu();
    this.input = new InputReader();
    this.loaded = false;
    this.sorted = false;
  }   
  
  public void salvarPontuacao(String nome, int pontuacao) {
    ScoreEntry entry = new ScoreEntry(nome, pontuacao);
    ranking.addEntry(entry);
  }
  
  public void rankingMenu(String filePath) {    
    if (!loaded) loadFromCSV(filePath);// Carrega o ranking se o usuário acessa o menu sem salvar pontuação
    if (!sorted) quickSort(); // Ordena o ranking na primeira vez que o menu é acessado
    do {
      menu.rankingMenuOptions();
      opcao = input.lerInt();
      
      switch (opcao) {
        case 1:
        printRanking();
        break;
        
        case 2:
        menu.searchByNamePrompt();
        String nome = input.lerString();
        binarySearchByName(nome);
        break;

        case 0:
        break;
        
        default:
        menu.invalidCase();
        break;
      }
      
    } while (opcao != 0);
  }
  
  public void printRanking() {
    System.out.println("Ranking de Pontuações:");
    int position = 1;
    for (ScoreEntry entry : ranking.getEntries()) {
      if (entry != null) {
        String fName = entry.getNome();
        if (fName.length() > 7) fName = fName.substring(0, 5) + ".."; // Se o nome for maior, coloca pontos no final
        while (fName.length() < 7) fName = fName + " "; // Formata o nome para ter exatamente 5 caracteres
        System.out.printf("%02d" + ". " + fName + " " + "%03d", position, entry.getPontuacao());
        System.out.println();
        position++;
      }
    }
  }
  
  // quick sort por pontuação (decrescente)
  public void quickSort() {
    for (int i = ranking.getEntries().length - 1; i >= 0; i--)
    if (ranking.getEntries()[i] != null) {
      quickSort(0, i); // define o low e o high (primeiro e o último elemento)
    }
    sorted = true;
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
      if (entry != null && entry.getNome() != null) count++;
    }

    if (count == 0) {
        System.out.println("Jogador '" + nome + "' não encontrado.");
        return -1;
    }
    
    ScoreEntry[] copia = new ScoreEntry[count];
    int idx = 0;

    for (ScoreEntry entry : ranking.getEntries()) {
      if (entry != null && entry.getNome() != null) copia[idx++] = entry;
    }

    int size = idx;
    // insertion sort por nome (apenas até 'size')
    for (int i = 1; i < size; i++) {
        ScoreEntry key = copia[i];
        int j = i - 1;
        while (j >= 0 && copia[j].getNome().compareToIgnoreCase(key.getNome()) > 0) {
            copia[j + 1] = copia[j];
            j--;
        }
        copia[j + 1] = key;
    }
    
    int left = 0;
    int right = size - 1;
    
    while (left <= right) {
      int mid = (left + right) / 2;
      int compare = copia[mid].getNome().compareToIgnoreCase(nome);
      if (compare == 0) { // não tava entrando neste if
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
      loaded = false;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void loadFromCSV(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = reader.readLine(); // Ignora cabeçalho
      int index = 0;

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          String nome = parts[0];
          int pontuacao = Integer.parseInt(parts[1]);
          ranking.getEntries()[index++] = new ScoreEntry(nome, pontuacao);
        }
      }
      System.out.println("Ranking carregado de: " + filePath);
      loaded = true;
      sorted = false;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }   
}
