import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Sounds {

    public Clip startMenu() {

        try {
            Clip audioClip = getAudioClip("Start_Menu.wav");
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            return audioClip;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;
    }


    public Clip inGameMusic() {

        try {

            Clip audioClip = getAudioClip("MainTheme.wav");
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            return audioClip;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void explosionsInGame() {

        try {

            Clip audioClip = getAudioClip("Explosion_Broccolli.wav");
            audioClip.loop(0);


        } catch (Exception ex) {
            System.out.println("NOT");

        }
    }

    public void eatSteak() {

        try {

            Clip audioClip = getAudioClip("Eat_Steak.wav");
            audioClip.loop(0);



        } catch (Exception ex) {
            System.out.println("NOT");
        }
    }

    public Clip playerDead() {

        try {

            Clip audioClip = getAudioClip("Player_Dead.wav");
            audioClip.loop(0);

            return audioClip;
        } catch (Exception ex) {
            System.out.println("NOT");
            return null;
        }
    }

    public Clip gameOver() {

        try {

            Clip audioClip = getAudioClip("End_Game.wav");
            audioClip.loop(0);

            return audioClip;
        } catch (Exception ex) {
            System.out.println("NOT");
            return null;
        }
    }

    public void stopMusic(Clip audioClip) {
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
        }
    }


    private Clip getAudioClip(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        URL url = getClass().getResource("/" + name);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioStream);
        return clip;
    }
}
