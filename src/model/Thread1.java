package model;

import view.GUIAssignment1;

import javax.crypto.spec.PSource;
import java.util.Random;

public class Thread1 implements Runnable {
    private Random random;
    private String name;
    public boolean ok = false;
    private GUIAssignment1 view;

    public Thread1(GUIAssignment1 view){
        this.view = view;
    }


    @Override
    public void run() {
        int i =0;
        while (!ok) {
            try {
                //int a = (int) (Math.random()*(400-100+1)+100);
                view.displayText();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}


