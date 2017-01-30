package WindowAplication;

import Graphic.GraphicPanel;
import Graphic.JLabelImg;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.jogamp.opengl.*;
import com.sun.deploy.panel.JSmartTextArea;
import org.junit.Test;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.UnresolvedPermission;

/**
 * Created by Jakub on 2016-12-03.
 */
public class JoglWindow extends JFrame {

    //Default global variables

    //definiton of window components
    private JButton Start;
    private JButton Open;
    private JButton Reset;

    private JSlider Slider;

    private JLabel Logo;

    private JTextArea SliderText;

    private JPanel UpperButtons;
    private JPanel panel;
    private JLabelImg ImgLabel;

    private GLJPanel GraphicPanel;
    private BasicFrame b;

    private int LinesOneRotateTime = 1000;  //time in milisecond
    private double LinesMinimumAngle = 0.05; //rad
    private int refreshingTime = (int)(LinesMinimumAngle/(2*3.14159)*LinesOneRotateTime);
    private void refreshingTimeChange(int rt){
        LinesOneRotateTime = rt;
        refreshingTime = (int)(LinesMinimumAngle/(2*3.14159)*(float)LinesOneRotateTime);
    }
    private Timer timerRefresh;


    //Default constructor
    public JoglWindow() {

        //Title of the window
        super("GasSim 0.1");

        //setting minimum size
        this.setMinimumSize(new Dimension(850,550));

        //Creating the flow layout to which we can work on and adding panel to frame
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Upper buttons panel
        UpperButtons = new JPanel();
        Start = new JButton("Start");
        Open = new JButton("Open image");
        Reset = new JButton("Reset");
        Slider = new JSlider(JSlider.HORIZONTAL,0,3000,1000);
        Slider.setMajorTickSpacing(1000);
        Slider.setMinorTickSpacing(100);
        Slider.setPaintTicks(true);
        Slider.setPaintLabels(true);
        Font font = new Font("Serif", Font.ITALIC, 10);
        Slider.setFont(font);
        SliderText = new JTextArea(" Speed:");
        SliderText.setBackground(this.getBackground());
        UpperButtons.add(Start);
        UpperButtons.add(Open);
        UpperButtons.add(Reset);
        UpperButtons.add(SliderText);
        UpperButtons.add(Slider);


        //definition of placing components
        c.ipady = 0;       //reset to default
        //c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(2,2,2,2);  //interspace
        c.gridx = 1;
        c.gridy = 0;
        add(UpperButtons,c);

        //Logo
        Logo = new JLabelImg(35,35);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(7,4,0,0);  //top padding
        c.gridx = 0;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 0;       //row
        add(Logo,c);


        ImgLabel = new JLabelImg();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(4,4,4,4);  //top padding
        c.gridx = 0;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(ImgLabel,c);


        //Graphic panel
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The GLJpanel class
        GraphicPanel = new GLJPanel(capabilities);
        b = new BasicFrame();

        GraphicPanel.addGLEventListener(b);

        GraphicPanel.setSize(new Dimension(400,400));
        //GraphicPanel.setBackground(Color.blue);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.weightx = 400;
        c.weighty = 400;
        c.insets = new Insets(4,4,4,4);  //top padding

        c.gridx = 1;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(GraphicPanel,c);




        //initalizing the window
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        //####################timer refreshing jogl###########################
        //new thread refreshing screen
        RefreshThread p = new RefreshThread(GraphicPanel);
        new Thread(p).start();
        ActionListener timerEvent = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                synchronized (this) {
                    b.RotateLine(LinesMinimumAngle);
                }
                //GraphicPanel.repaint();
            }
        };
        //declaration of timer
        timerRefresh = new Timer(refreshingTime, timerEvent);


        //Handler constructor to do the actionlistening
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"You clicked start, but it's still version 0.1 :)");
                //button for starting loop
                if(Start.getText()=="Start") {
                    timerRefresh.start();
                    Start.setText("Stop");
                }
                else {
                    timerRefresh.stop();
                    Start.setText("Start");
                }
            }
        });
        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        BufferedImage img2 = ImageIO.read(file);
                        ImgLabel.SetJLabelImg(600,600,img2);

                    } catch (IOException a) {
                        JOptionPane.showMessageDialog(null,"You should choose image file");
                        a.printStackTrace();
                    }
                }
            }
        });
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImgLabel.SetJLabelImg(300,300,"Kinetic theory of gases.png");

            }
        });
        Slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshingTimeChange(Slider.getValue());
                timerRefresh.setDelay(refreshingTime);

            }
        });
    }

}
