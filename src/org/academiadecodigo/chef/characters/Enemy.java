package org.academiadecodigo.chef.characters;

import org.academiadecodigo.chef.grid.Grid;
import org.academiadecodigo.chef.grid.GridDirection;
import org.academiadecodigo.chef.grid.GridPosition;

public class Enemy {

    public boolean exploded = false;
    private GridPosition position;


    public Enemy(Grid grid) {
        GridPosition initialPosition = new GridPosition((((int)(Math.random()*900))+ 150), (((int)(Math.random()*300))+300), grid);
        position = initialPosition;
    }

    public void move() {
        GridDirection newDirection = GridDirection.values()[(int) Math.floor(Math.random()*4)];
        position.enemyMoveDirection(newDirection);
        position.updatePos();

    }

    /* getters and setters */

    public boolean isExploded() {
        return exploded;
    }

    public void setExploded() {
        position.hide();
        exploded = true;
    }

    public GridPosition getPosition() {
        return position;
    }

}
