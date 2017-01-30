package WindowAplication; /**
 * Created by Jakub on 2016-11-07.
 */


import Graphic.GraphicModule;
import Graphic.GraphicPanel;
import Graphic.ImagePanel;
import Graphic.JLabelImg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.lang.*;



public class Window extends JFrame {

    //Default global variables

    //definiton of window components
    private JButton Start;
    private JButton Open;
    private JButton Reset;

    private JLabel Logo;

    private JPanel UpperButtons;
    private JPanel panel;
    private JLabelImg ImgLabel;

    //Default constructor
    public Window() {

        //Title of the window
        super("GasSim 0.1");

        //setting minimum size
        this.setMinimumSize(new Dimension(1080,700));

        //Creating the flow layout to which we can work on and adding panel to frame
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Upper buttons panel
        UpperButtons = new JPanel();
        Start = new JButton("Start");
        Open = new JButton("Open image");
        Reset = new JButton("Reset");
        UpperButtons.add(Start);
        UpperButtons.add(Open);
        UpperButtons.add(Reset);

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
        c.gridx = 1;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(ImgLabel,c);


        //Graphic panel
        panel = new GraphicPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(4,4,4,4);  //top padding
        c.gridx = 0;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(panel,c);




        //initalizing the window
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Handler constructor to do the actionlistening
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"You clicked start, but it's still version 0.1 :)");
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
                ImgLabel.SetJLabelImg(600,600,"Kinetic theory of gases.png");
            }
        });
    }

}
