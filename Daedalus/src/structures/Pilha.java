package structures;

public class Pilha {
    private Object[] elementos;

    public Pilha(int capacidade) {
        elementos = new Object[capacidade];
    }

    public void push(Object elemento) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null) {
                elementos[i] = elemento;
                return;
            }
        }
        throw new RuntimeException("Pilha cheia");
    }

    public Object pop() {
        for (int i = elementos.length - 1; i >= 0; i--) {
            if (elementos[i] != null) {
                Object elemento = elementos[i];
                elementos[i] = null;
                return elemento;
            }
        }
        throw new RuntimeException("Pilha vazia");
    }

    public Object top() {
        for (int i = elementos.length - 1; i >= 0; i--) {
            if (elementos[i] != null) {
                return elementos[i];
            }
        }
        throw new RuntimeException("Pilha vazia");
    }
}