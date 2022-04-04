package control;

import model.Buttons;
import model.Thread1;
import model.Thread2;
import model.Thread3;
import view.GUIAssignment1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class Controller {
    private GUIAssignment1 view;
    private File fileSrc;
    private AudioInputStream audioInputStream;
    private Thread1 a;
    private Thread2 b;
    private Thread3 c;
    public Controller() {
        view = new GUIAssignment1(this);
        view.Start();
    }





    // btn handler
    public void btnControl(Buttons btn) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (btn){
            case StartThreadA:
                System.out.println("started One");
                a = new Thread1(view);
                new Thread(a).start();
                break;
            case StopThreadA:
                a.ok = true;
                break;
            case StartThreadB:
                System.out.println("start Two");
                b = new Thread2(view);
                new Thread(b).start();
                break;
            case StopThreadB:
                System.out.println("Stop Two");
                b.stopThread();
                break;

                // music player
            case choosefile:
                System.out.println("valde file");
                JFileChooser file = new JFileChooser();
                file.showOpenDialog(null);
                fileSrc = file.getSelectedFile();
                view.setAudioFile(fileSrc);
                c = new Thread3(fileSrc, view);
                c.start();
                break;
            case StartThreadC:
                c.startOk = false;
                System.out.println("start Three");
                System.out.println(fileSrc);
                break;
            case StopThreadC:
                System.out.println("Stop three");
                c.stopThread();
                break;
        }
    }
    // start thread 2
    // start thread 3
    // start thread 4
}
