package objects;
import java.util.Random;

import structures.Coordenada;

public class Tesouro extends PointsItem{

    public Tesouro(Coordenada position) {
        super('$', position, new Random().nextInt(41) + 10); //Valor entre 10 e 50
    }

    
}
