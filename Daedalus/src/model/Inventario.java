package model;

import structures.Pilha;
import objects.Chave;

public class Inventario extends Pilha {

    public Inventario(int capacidade) {
        super(capacidade);
    }

    public boolean push(Chave chave) { // Chamado quando o jogador encosta numa chave
        try{
            super.push(chave);
            return true;
        } catch (RuntimeException e) {
            // Pilha cheia, não coletar chave
            return false;
        }
    }

    public Chave pop() { // Chamado quando o jogador encosta numa porta
        try{
            return (Chave) super.pop();
        } catch (RuntimeException e) {
            return null; // Pilha vazia, não há chave para usar
        }
    }

    public Chave top() { // Ver a chave no topo da pilha sem removê-la
        try{
            return (Chave) super.top();
        } catch (RuntimeException e) {
            return null; // Pilha vazia, não há chave no topo
        }
    }

        public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;
        for (Object elemento : elementos) {
            if (elemento != null) {
                if (!first) sb.append(", ");
                sb.append(((Chave)elemento).chave());
                first = false;
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
