package Graphic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Created by Jakub on 2016-11-19.
 */
public class GraphicImg extends ImageIcon{

    private BufferedImage actualImg;

    private static BufferedImage map( int sizeX, int sizeY ){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                res.setRGB(x, y, Color.WHITE.getRGB() );
            }
        }
        return res;
    }

    public void DrawOwal(int x, int y){
        //g2d.drawOval(5, 5, 100, 100);
    }

    public BufferedImage GetActualImg(){
        return actualImg;
    }

    public GraphicImg(){
        actualImg = map(600,600);
        Image ImgLogo = actualImg;
        this.setImage(ImgLogo);
    }
}
