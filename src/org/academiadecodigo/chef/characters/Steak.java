package org.academiadecodigo.chef.characters;

import org.academiadecodigo.chef.grid.Grid;
import org.academiadecodigo.chef.grid.GridPosition;

public class Steak {

    private GridPosition position;
    private boolean exists;

    public Steak(Grid grid) {

        GridPosition initialPosition = new GridPosition((((int)(Math.random()*900))+ 150), (((int)(Math.random()*300))+300), grid, true);
        exists = true;
        position = initialPosition;
        position.steakPos();
    }

    public boolean isExists() {
        return this.exists;
    }

    public void setExists() {
        this.exists = false;
        position.hide();
    }

    public GridPosition getPosition() {
        return position;
    }
}
