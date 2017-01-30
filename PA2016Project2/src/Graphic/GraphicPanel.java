package Graphic; /**
 * Created by Jakub on 2016-11-07.
 */
import java.awt.*;
import javax.swing.JPanel;

public class GraphicPanel extends JPanel {

    //constructor
    public GraphicPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // prostokat
        g2d.drawRect(10, 10, 380, 380);
        // kolo
        g2d.drawOval(10, 10, 380, 380);
    }
}
