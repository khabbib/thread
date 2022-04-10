package model;

import view.GUIAssignment1;

public class TriangleThread extends Thread {
    public boolean ok2 = false;
    private String name;
    private GUIAssignment1 view;
    public TriangleThread(GUIAssignment1 view){
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
}


