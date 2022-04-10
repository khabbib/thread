package control;

import model.Buttons;
import model.TextThread;
import model.TriangleThread;
import model.MusicThread;
import view.GUIAssignment1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class Controller {

    private GUIAssignment1 view;
    private TriangleThread triangleThread;
    private MusicThread musicThread;
    private TextThread textThread;
    private File fileSrc;

    /**
     * The constructor run the view/GUI
     */
    public Controller() {
        view = new GUIAssignment1(this);
        view.Start();
    }



    // Method is for event controlling- buttons
    public void btnControl(Buttons btn) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (btn) {
            // display text
            case StartThreadA -> {
                textThread = new TextThread(view);
                textThread.start();
            }
            case StopThreadA -> textThread.stopThread();

            // triangle
            case StartThreadB -> {
                triangleThread = new TriangleThread(view);
                new Thread(triangleThread).start();
            }
            case StopThreadB -> triangleThread.stopThread();

            // music player
            case pickMusic -> {
                JFileChooser file = new JFileChooser();
                file.showOpenDialog(null);
                fileSrc = file.getSelectedFile();
                view.setAudioFile(fileSrc);
                musicThread = new MusicThread(fileSrc, view);
                musicThread.start();
            }
            case startPlay -> musicThread.startThread();
            case stopPlay -> musicThread.stopThread();
        }
    }
}
