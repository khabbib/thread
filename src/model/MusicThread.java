package model;

import view.GUIAssignment1;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicThread extends Thread {

    private AudioInputStream audioInputStream;
    public boolean startThread = false;
    private boolean ok3 = false;
    private GUIAssignment1 view;
    private File file;
    private Clip clip;

    /**
     * The constructor is getting the following params
     * @param file // is the chosen music file
     * @param view // is an instance of GUI/view
     */
    public MusicThread(File file, GUIAssignment1 view){
        this.view = view;
        this.file = file;
    }

    /**
     * Music thread will start to read file and listen to it
     */
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

        // while loop is working until flag change the value
        while (!ok3){
            // sleep the thread to have a pause between the play and stop btn
            try { Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            // check the flag and start/stop the work
            if (startThread){
                clip.start(); // play
            }else {
                clip.stop(); // stop
            }

        }
    }


    // The methods will handle the flags value changing
    public void stopThread() {
        startThread = false;
    }
    public void startThread() {
        startThread = true;
    }
}
