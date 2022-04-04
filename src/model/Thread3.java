package model;

import view.GUIAssignment1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Thread3 extends Thread {
    private boolean ok3 = false;
    public boolean startOk = false;

    private GUIAssignment1 view;
    private File file;
    private AudioInputStream audioInputStream;
    private Clip clip;
    public Thread3(File file, GUIAssignment1 view){
        this.view = view;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " file: " + file.getName() + " started");
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        while (!ok3){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (startOk){
                clip.start();
            }else {
                clip.stop();
            }

        }
    }


    public void stopThread() {
        ok3 = true;
    }
}
