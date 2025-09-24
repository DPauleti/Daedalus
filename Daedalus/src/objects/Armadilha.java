package objects;

import structures.Coordenada;

public class Armadilha extends Item{
    private int value;
    public Armadilha(Coordenada position) {
        super('T', position);
    }
}
