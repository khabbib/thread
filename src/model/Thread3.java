package model;

import view.GUIAssignment1;

public class Thread3 extends Thread {
    private boolean ok3 = true;
    private GUIAssignment1 view;
    public Thread3(GUIAssignment1 view){
        this.view = view;
    }



    @Override
    public void run() {
        while (!ok3){
            try {

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void stopThread() {
        ok3 = true;
    }
    public void startThread() {
        ok3 = false;
    }
}
