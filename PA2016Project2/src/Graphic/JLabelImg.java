package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jakub on 2016-11-19.
 */
public class JLabelImg extends JLabel {


    public void SetJLabelImg(int Width, int High, String FileName){
        //temp img
        BufferedImage thumbnail = null;

        //trying to open selected file from name
        try {
            BufferedImage tempImg = ImageIO.read(new File(FileName));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),Width,High);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"class JLabelImg, failed file load");
        }

        //setting new icon
        Image ImgLogo= thumbnail;

        //set icon of JLabel
        this.setIcon(new ImageIcon(ImgLogo,"GasSim 0.1"));
    }

    public void SetJLabelImg(int Width, int High, BufferedImage thumbnail){

        thumbnail = GraphicModule.resizeImage(thumbnail,thumbnail.getType(),Width,High);
        //setting new icon
        Image ImgLogo= thumbnail;

        //set icon of JLabel
        this.setIcon(new ImageIcon(ImgLogo,"GasSim 0.1"));
    }


    //Constructors
    public JLabelImg(){
        //temp img
        BufferedImage thumbnail = null;

        //trying to open selected file from name
        try {
            String pathFile = "Kinetic theory of gases.png";
            BufferedImage tempImg = ImageIO.read(new File(pathFile));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),300,300);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"class JLabelImg, failed file load");
        }

        //setting new icon
        Image ImgLogo= thumbnail;

        //set icon of JLabel
        this.setIcon(new ImageIcon(ImgLogo,"GasSim 0.1"));
    }
    public JLabelImg(int Width, int High){
        //temp img
        BufferedImage thumbnail = null;

        //trying to open selected file from name
        try {
            String pathFile = "Kinetic theory of gases.png";
            BufferedImage tempImg = ImageIO.read(new File(pathFile));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),Width,High);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"class JLabelImg, failed file load");
        }

        //setting new image
        Image ImgLogo= thumbnail;

        //set icon of JLabel
        this.setIcon(new ImageIcon(ImgLogo,"GasSim 0.1"));
    }
    public JLabelImg(int Width, int High, String FileName){
        //temp img
        BufferedImage thumbnail = null;

        //trying to open selected file from name
        try {
            BufferedImage tempImg = ImageIO.read(new File(FileName));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),Width,High);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"class JLabelImg, failed file load");
        }

        //setting new icon
        Image ImgLogo= thumbnail;

        //set icon of JLabel
        this.setIcon(new ImageIcon(ImgLogo,"GasSim 0.1"));
    }



}
