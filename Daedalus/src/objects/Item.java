package objects;

public abstract class Item extends Tile{
    public Item(char symbol, structures.Coordenada position) {
        super(symbol, position, true);
    }

    public boolean tryWalk() {
        if (walkable) onTouch(); // Itens sempre ativam quando o jogador pisa neles
        return walkable;
    }

    public void onTouch() { // Ação padrão ao tocar no item: remover do mapa
        // Configurar ações diferentes para cada item
        super.setPositionNull();
    };
}
