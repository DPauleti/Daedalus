package controllers;

import model.Log;
import objects.*;

public class LogController {
    private Log log;

    public LogController() {
        this.log = new Log();
    }

    // Chave, tesouro, porta, armadilha, início, fim

    public void itemEntry(Item item, int turn, String player) {
        if (item instanceof Chave) {
            addEntry(player + " coletou a chave " + ((Chave) item).chave(), turn);
        }
        if (item instanceof Armadilha) {
            addEntry(player + " pisou numa armadilha", turn);
        }
        if (item instanceof Tesouro) {
            addEntry(player + " achou um tesouro", turn);
        }
        if (item instanceof Porta) {
            addEntry(player + " destrancou a porta " + Character.toUpperCase(((Porta) item).getChave().chave()), turn);
            if (item instanceof Exit) {
                addEntry(player + " chegou na saída", turn);
            }
        }
    }

    public void startEntry(String player) {
        addEntry(player +" iniciou o jogo", 0);
    }

    public void addEntry(String entry, int turn) {
        if (turn > 0)
            log.addEntry(entry + " no turno " + turn);
        else
            log.addEntry(entry);
    }

    public String getLog() {
        return log.getAllEntries();
    }
}
