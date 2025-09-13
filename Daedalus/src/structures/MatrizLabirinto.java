
import java.io.File;
import java.util.Scanner;

public class MatrizLabirinto {
  File arquivo = new File("labirinto.txt");
  Scanner sc = new Scanner(arquivo);

  int linhas = sc.nextInt();
  int colunas = sc.nextInt();
  
  char[][] labirinto = new char[linhas][colunas];
}