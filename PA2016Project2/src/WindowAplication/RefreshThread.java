package WindowAplication;

import Graphic.GraphicPanel;
import com.jogamp.opengl.awt.GLJPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Jakub on 2017-01-30.
 */
class RefreshThread implements Runnable {
    private GLJPanel Graphic;
    private Timer RefreshTime;
    private int refreshingTime = 1000/30; //ilość klatek 1000/x
    RefreshThread(GLJPanel a) {
        this.Graphic = a;
        ActionListener timerEvent = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repeat();
            }
        };
        //declaration of timer
        RefreshTime = new Timer(refreshingTime, timerEvent);
        RefreshTime.start();
    }
    public boolean Finished;
    public void run() {
    }
    public void repeat(){
        //Finished = false;
        Graphic.repaint();
    }
}