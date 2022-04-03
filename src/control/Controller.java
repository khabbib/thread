package control;

import model.Buttons;
import model.Thread1;
import model.Thread2;
import model.Thread3;
import view.GUIAssignment1;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller {
    private GUIAssignment1 view;
    private Thread1 a;
    private Thread2 b;
    private Thread3 c;
    public Controller() {
        view = new GUIAssignment1(this);
        view.Start();
    }





    // btn handler
    public void btnControl(Buttons btn) {
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
            case StartThreadC:
                System.out.println("start Three");
                c.start();
                c.startThread();
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
