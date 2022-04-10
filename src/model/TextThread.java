package model;

import view.GUIAssignment1;

import java.util.Random;

public class TextThread extends Thread {
    public boolean ok = false;
    private GUIAssignment1 view;

    /**
     * The constructor pass the view into the class
     * @param view // is gui/view parameter which came from controller
     */
    public TextThread(GUIAssignment1 view){
        this.view = view;
    }


    /**
     * The run method will start the thread for the text displaying on the screen
     */
    @Override
    public void run() {
        while (!ok) {
            try {
                view.displayText();
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }


    // These methods will handle the flags value changes
    public void startThread(){
        ok = false;
    }
    public void stopThread(){
        ok = true;
    }
}


