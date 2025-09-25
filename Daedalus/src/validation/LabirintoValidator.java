package validation;

import model.Labirinto;
import objects.Chave;
import objects.Exit;
import objects.Porta;
import objects.Start;
import structures.Coordenada;

public abstract class LabirintoValidator {
    public static void validate(Labirinto labirinto) {
        try {
            if (labirinto == null) {
                throw new IllegalArgumentException("Labirinto nulo");
            }
            validateDoorsKeys(labirinto);
            validateEntranceExit(labirinto);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação do labirinto: " + e.getMessage());
            throw new RuntimeException(e);
        }        
    }

    public static void validateDoorsKeys(Labirinto labirinto) {
        Porta[] portas = new Porta[26];
        int portasCount = 0;

        for (int i = 0; i < labirinto.getRows(); i++) {
            for (int j = 0; j < labirinto.getCols(); j++) {
                if (labirinto.getTileAt(Coordenada.toCoord(j, i)) instanceof Porta) {
                    Porta porta = (Porta) labirinto.getTileAt(Coordenada.toCoord(j, i));
                    portas[portasCount] = porta;
                    portasCount++;
                }
            }
        }
        for (int i = 0; i < portasCount; i++) {
            boolean foundKey = false;
            for (int x = 0; x < labirinto.getRows(); x++) {
                for (int y = 0; y < labirinto.getCols(); y++) {
                    if (labirinto.getTileAt(Coordenada.toCoord(x, y)) instanceof Chave) {
                        Chave chave = (objects.Chave) labirinto.getTileAt(Coordenada.toCoord(x, y));
                        if (chave.getSymbol() == Character.toLowerCase(portas[i].getSymbol())) {
                            portas[i].setChave(chave);
                            foundKey = true;
                            break;
                        }
                    }
                }
                if (foundKey) break;
            }
            if (!foundKey) {
                throw new IllegalArgumentException("Porta sem chave correspondente: " + portas[i].getSymbol() + " na posição " + portas[i].getPosition().toString());
            }
        }
    }

    public static void validateEntranceExit(Labirinto labirinto) {
        int foundStart = 0;
        int foundExit = 0;

        for (int i = 0; i < labirinto.getRows(); i++) {
            for (int j = 0; j < labirinto.getCols(); j++) {
                if (labirinto.getTileAt(Coordenada.toCoord(j, i)) instanceof Start) {
                    foundStart ++;
                }
                if (labirinto.getTileAt(Coordenada.toCoord(j, i)) instanceof Exit) {
                    foundExit ++;
                }
            }
        }

        if (!(foundStart == 1)) {
            throw new IllegalArgumentException("Labirinto inválido: o labirinto deve conter exatamente uma entrada 'S'");
        }
        if (!(foundExit == 1)) {
            throw new IllegalArgumentException("Labirinto inválido: o labirinto deve conter exatamente uma saída 'E'");
        }
    }
}
