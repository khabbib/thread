package model;

import view.GUIAssignment1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Thread2 extends Thread {
    public boolean ok2 = false;
    private String name;
    private GUIAssignment1 view;
    public Thread2(GUIAssignment1 view){
        this.view = view;
    }


    @Override
    public void run() {
        int counter = 0;
        while (!ok2){
            try {

                view.rotateShape(counter);
                System.out.println("hellooo");
                Thread.sleep(100);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void stopThread() {
        ok2 = true;
    }
    public void startThread() {
        ok2 = false;
    }
}


