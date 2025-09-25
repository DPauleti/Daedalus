package objects;

public abstract class Item extends Tile{
    private boolean interacted = false;
    public Item(char symbol, structures.Coordenada position) {
        super(symbol, position, true);
    }
    public Item(char symbol, structures.Coordenada position, boolean walkable) {
        super(symbol, position, walkable);
    }

    public boolean tryWalk() {
        if (walkable && !interacted) onTouch(); // Itens sempre ativam quando o jogador pisa neles
        return walkable;
    }

    public void onTouch() { // Ação padrão ao tocar no item: remover do mapa
        // Configurar ações diferentes para cada item
        this.interacted = true;
        this.symbol = '.';
    };
}
