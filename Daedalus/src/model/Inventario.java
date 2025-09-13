import objects.Chave;
import structures.Pilha;

public class Inventario extends Pilha {

    public Inventario(int capacidade) {
        super(capacidade);
    }

    public void push(Chave chave) { // Chamado quando o jogador encosta numa chave
        try{
            super.push(chave);
        } catch (RuntimeException e) {
            // Pilha cheia, não coletar chave
        }
    }

    public Chave pop() { // Chamado quando o jogador encosta numa porta
        try{
            return (Chave) super.pop();
        } catch (RuntimeException e) {
            return null; // Pilha vazia, não há chave para usar
        }
    }
}
