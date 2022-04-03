package model;

import view.GUIAssignment1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Thread2 extends Thread {
    public boolean ok = false;
    private ImageIcon image;
    private GUIAssignment1 view;
    public Thread2(ImageIcon image, GUIAssignment1 view){
        this.image = image;
        this.view = view;
    }


    @Override
    public void run() {
        int counter = 0;
        while (!ok){
            try {
                view.rotateShape(counter);
                System.out.println("hellooo");
                Thread.sleep(200);
                counter+= 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}


