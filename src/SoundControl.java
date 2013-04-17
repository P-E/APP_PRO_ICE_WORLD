import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 17/4/2556
 * Time: 10:09 น.
 * To change this template use File | Settings | File Templates.
 */
public class SoundControl {
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("music.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
        clip.start();
    }
}
