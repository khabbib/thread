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
    public Controller(){
        view = new GUIAssignment1(this);
        view.Start();
    }


    // start thread 1

    public void threadA(){

    }
    Thread1 a;
    Thread2 b;
    Thread3 c;

    public void btnControl(Buttons btn) {
        switch (btn){
            case StartThreadA:
                System.out.println("start A");
                a = new Thread1("The message", view);
                a.start();
                break;
            case StopThreadA:
                System.out.println("Stop A");
                a.ok = true;
                break;
            case StartThreadB:
                System.out.println("start A");
                b = new Thread2(new ImageIcon("\"image/jetStream.png\""), view);
                b.start();
                break;
            case StopThreadB:
                System.out.println("Stop A");
                b.interrupt();
                break;

        }
    }
    // start thread 2
    // start thread 3
    // start thread 4
}
