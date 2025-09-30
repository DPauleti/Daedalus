package objects;

import structures.Coordenada;

public class Portal extends Tile {
    private Portal linkedPortal;

    public Portal (Coordenada position) {
        super('O', position, true);
    }

    public void link(Portal portal) {
        this.linkedPortal = portal;
    }

    public Portal getLinkedPortal() {
        return linkedPortal;
    }

}
