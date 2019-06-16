package org.academiadecodigo.chef.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {

    private Grid grid;
    private Picture picture;

    private int[] enemyX = new int[2];
    private int[] enemyY = new int[2];

    private int[] steakX = new int[2];
    private int[] steakY = new int[2];


    public GridPosition(int X, Grid grid) {
        this.grid = grid;
        picture = new Picture(X, (((int)(Math.random()*300))+300), "rick_ac.png");
        picture.draw();
        updatePos();
    }

    public GridPosition(int X, int Y, Grid grid) {
        this.grid = grid;
        picture = new Picture(X, Y, "broccolli.png");
        picture.draw();
    }

    public GridPosition(int X, int Y, Grid grid, boolean exists) {
        this.grid = grid;
        picture = new Picture(X, Y, "steak.png");
        picture.draw();
    }

    public void updatePos() {

        enemyX[0] = picture.getX();
        enemyX[1] = picture.getX() + picture.getHeight();

        enemyY[0] = picture.getY();
        enemyY[1] = picture.getY() + picture.getWidth();
    }

    public void steakPos() {

        steakX[0] = picture.getX();
        steakX[1] = picture.getX() + picture.getHeight();

        steakY[0] = picture.getY();
        steakY[1] = picture.getY() + picture.getWidth();
    }

    public void enemyMoveDirection(GridDirection direction) {

        int distance = ((int)(Math.random() * 50));

        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
        }
    }

    public void playerMoveDirection(GridDirection direction, int distance) {

        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
        }
    }

    public void moveUp(int dist) {
        if (picture.getY() - dist >= 170) {
            picture.translate(0, -dist);
        } else {
            moveDown(dist);
        }
    }

    public void moveDown(int dist) {
        if (picture.getY() + dist <= grid.getHeight() - 130) {
            picture.translate(0, dist);
        } else {
            moveUp(dist);
        }
    }

    public void moveRight(int dist) {
        if (picture.getX() + dist <= grid.getWidth() - 90) {
            picture.translate(dist, 0);
        } else {
            moveLeft(dist);
        }
    }

    public void moveLeft(int dist) {
        if (picture.getX() - dist >= 30) {
            picture.translate(- dist, 0);
        } else {
            moveRight(dist);
        }
    }

    public void hide() {
        picture.delete();
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public int[] getEnemyX() {
        return enemyX;
    }

    public int[] getEnemyY() {
        return enemyY;
    }

    public int[] getSteakX() {
        return steakX;
    }

    public int[] getSteakY() {
        return steakY;
    }


}