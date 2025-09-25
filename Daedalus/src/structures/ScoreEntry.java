package structures;

public class ScoreEntry {
    private String nome;
    private int pontuacao;

    public ScoreEntry(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}
