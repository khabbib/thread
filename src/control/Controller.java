package control;

import model.Buttons;
import model.Thread1;
import model.Thread2;
import model.Thread3;
import view.GUIAssignment1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class Controller {
    private GUIAssignment1 view;
    private File fileSrc;
    private Thread1 a;
    private Thread2 b;
    private Thread3 c;
    public Controller() {
        view = new GUIAssignment1(this);
        view.Start();
    }





    // btn handler
    public void btnControl(Buttons btn) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (btn) {
            // display text
            case StartThreadA -> {
                a = new Thread1(view);
                new Thread(a).start();
            }
            case StopThreadA -> a.ok = true;

            // triangle
            case StartThreadB -> {
                b = new Thread2(view);
                new Thread(b).start();
            }
            case StopThreadB -> b.stopThread();

            // music player
            case pickMusic -> {
                JFileChooser file = new JFileChooser();
                file.showOpenDialog(null);
                fileSrc = file.getSelectedFile();
                view.setAudioFile(fileSrc);
                c = new Thread3(fileSrc, view);
                c.start();
            }
            case startPlay -> c.startOk = true;
            case stopPlay -> c.startOk = false;
        }
    }
}
