/*
 * This file work as a sound player for the 2048 game.
 * Created By : Sachin Gupta
 * Created Date : 21/9/2024
 */

package Assignment_5;

import Assignment_5.Constant;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    //PlaySound method play the sound.
    public static void playSound(String fileName) {
        Constant constant = new Constant();
        try {
            System.out.println(fileName);
            URL soundURL = SoundPlayer.class.getResource(fileName);
            if (soundURL == null) {
                System.err.println(constant.SoundNotFound);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
