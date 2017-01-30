package WindowAplication;

import java.awt.*;

/**
 * Created by Jakub on 2016-12-02.
 */
public class JOGLtest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JoglWindow();
            }
        });
    }
}
