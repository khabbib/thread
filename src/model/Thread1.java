package model;

import view.GUIAssignment1;

import java.util.Random;

public class Thread1 extends Thread {
    private Random random;
    private String txt;
    public boolean ok = false;
    private GUIAssignment1 view;
    public Thread1(String txt, GUIAssignment1 view){
        this.txt = txt;
        this.view = view;
    }

    @Override
    public void run() {
        int counter = 0;
        int max = 100;
        int min = 400;
        while (!ok){
            try {
                int a = (int) (Math.random()*(max-min+1)+min);

                System.out.println("hellooo");
                view.displayText(String.valueOf(counter));
                sleep(1000);
                counter = a;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}

