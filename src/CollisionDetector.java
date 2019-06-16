import org.academiadecodigo.chef.characters.Enemy;
import org.academiadecodigo.chef.characters.Player;
import org.academiadecodigo.chef.characters.Steak;

import javax.sound.sampled.Clip;

public class CollisionDetector {

    /* in this class, we check if your player collides with our game objects. */

    private Steak steak;
    private Enemy[] enemies;
    private Player player;

    private Sounds sounds;
    private Clip currentClip;

    public CollisionDetector(Enemy[] enemies, Player player, Steak steak) {
        this.enemies = enemies;
        this.player = player;
        this.steak = steak;

    }

    public void enemyCollision() {

        for (Enemy enemy : enemies) {

            if (player.getPosition().getEnemyX()[0] < enemy.getPosition().getEnemyX()[1] &&
                    player.getPosition().getEnemyX()[1] > enemy.getPosition().getEnemyX()[0] &&
                    player.getPosition().getEnemyY()[0] < enemy.getPosition().getEnemyY()[1] &&
                    player.getPosition().getEnemyY()[1] > enemy.getPosition().getEnemyY()[0]) {

                if (!enemy.isExploded()) {

                    enemy.getPosition().hide();
                    player.decreasePlayerHealth();
                    enemy.setExploded();
                    new Sounds().explosionsInGame();
                    System.out.println(player.getPlayerHealth());
                }
            }

        }
        if (player.getPlayerHealth() <= 0) {
            player.setDead();

        }
    }

    public void setSteak(Steak steak){
        this.steak = steak;
    }

    public void steakCollision() {
        if (player.getPosition().getEnemyX()[0] < steak.getPosition().getSteakX()[1] &&
                player.getPosition().getEnemyX()[1] > steak.getPosition().getSteakX()[0] &&
                player.getPosition().getEnemyY()[0] < steak.getPosition().getSteakY()[1] &&
                player.getPosition().getEnemyY()[1] > steak.getPosition().getSteakY()[0]) {

            if (steak.isExists()) {
                steak.getPosition().hide();
                steak.setExists();
                player.increasePlayerHealth();
                System.out.println("health " + player.getPlayerHealth());
            }
        }
    }
}