package WindowAplication;

import java.awt.*;

/**
 * Created by Jakub on 2016-11-07.
 */
public class MainStart {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();

            }
        });
    }
}
