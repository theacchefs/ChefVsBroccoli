import org.academiadecodigo.chef.characters.Enemy;
import org.academiadecodigo.chef.characters.Player;
import org.academiadecodigo.chef.characters.Steak;
import org.academiadecodigo.chef.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.sound.sampled.*;

public class Game implements KeyboardHandler {

    private Grid grid = new Grid();
    private Enemy[] enemyArray;
    private Steak steak;
    private Player player;
    private CollisionDetector collisionDetector;
    private Picture picture;
    private boolean gameStarted = false;
    private Sounds sounds;
    private Clip currentClip;
    public static final int PADDING = 10;

    public void start() throws InterruptedException {

        picture = new Picture(PADDING, PADDING, "startscreen.png");
        picture.draw();
        sounds = new Sounds();
        currentClip = sounds.startMenu();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventsSpace = new KeyboardEvent();
        eventsSpace.setKey(KeyboardEvent.KEY_SPACE);
        eventsSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventsSpace);

        while (!gameStarted) {

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

         playGame();
    }

    public void playGame() throws InterruptedException {
        deletePic();
        sounds.stopMusic(currentClip);
        currentClip = sounds.inGameMusic();
        grid.init();

        player = new Player(grid);
        enemyArray = createEnemies(8);
        steak = new Steak(grid);
        collisionDetector = new CollisionDetector(enemyArray, player, steak);


        while (!player.isDead()) {
            Thread.sleep(150);
            moveAllEnemies();

            if (!steak.isExists()){
                steak = new Steak(grid);
                collisionDetector.setSteak(steak);
                sounds = new Sounds();
                sounds.eatSteak();
            }
            caughtSteak();
        }

        if (player.isDead()) {

            sounds.stopMusic(currentClip);
            new Sounds().playerDead();
            Thread.sleep(7000);
            deletePic();
            endGame();
        }
    }

    public void endGame() throws InterruptedException {
        sounds.stopMusic(currentClip);
        picture = new Picture(PADDING, PADDING, "end_screen_final.png");
        picture.draw();
        sounds.stopMusic(currentClip);
        currentClip = sounds.gameOver();

    }

    public Enemy[] createEnemies(int createdEnemies) {

        enemyArray = new Enemy[createdEnemies];

        for (int i = 0; i < createdEnemies; i++) {
            enemyArray[i] = new Enemy(grid);
        }

        return enemyArray;
    }

    public void moveAllEnemies() {

        for (Enemy enemy: enemyArray) {
            enemy.move();
            collisionDetector.enemyCollision();
        }
    }

    public void caughtSteak() {
        collisionDetector.steakCollision();

    }

    public void deletePic() {
        picture.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            gameStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
