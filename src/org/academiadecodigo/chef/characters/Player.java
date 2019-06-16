package org.academiadecodigo.chef.characters;

import org.academiadecodigo.chef.grid.Grid;
import org.academiadecodigo.chef.grid.GridDirection;
import org.academiadecodigo.chef.grid.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private GridPosition position;
    private int playerHealth = 150;
    private boolean dead = false;

    public Player(Grid grid) {

        GridPosition initialPosition = new GridPosition(20, grid);
        position = initialPosition;
        setupKeyboardListeners();
        position.updatePos();
    }

    public void setDead() {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void increasePlayerHealth() {
        playerHealth = playerHealth + 10;
    }

    public void decreasePlayerHealth() {
        playerHealth = playerHealth - 50;
    }

    public GridPosition getPosition() {
        return position;
    }


    private void setupKeyboardListeners(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_W);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);


        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_S);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);


        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_A);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);


        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_D);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (!isDead()) {
            if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
                position.playerMoveDirection(GridDirection.UP, 25);
                System.out.println(position.getX() + " , " + position.getY());
            } else if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {
                position.playerMoveDirection(GridDirection.DOWN, 25);
                System.out.println(position.getX() + " , " + position.getY());
            } else if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {
                position.playerMoveDirection(GridDirection.LEFT, 25);
                System.out.println(position.getX() + " , " + position.getY());
            } else if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {
                position.playerMoveDirection(GridDirection.RIGHT, 25);
                System.out.println(position.getX() + " , " + position.getY());
            }
            position.updatePos();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}