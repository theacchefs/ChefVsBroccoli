package org.academiadecodigo.chef.grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    private Picture picture;

    private int width = 1121;
    private int height = 858;

    public void init() {

        picture = new Picture(PADDING, PADDING, "new-background2.0.png");
        picture.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
