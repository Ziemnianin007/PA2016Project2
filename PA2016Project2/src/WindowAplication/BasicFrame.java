package WindowAplication;
import com.jogamp.opengl.*;


import Graphic.GraphicPanel;
import Graphic.JLabelImg;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.jogamp.opengl.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_NICEST;
import static com.jogamp.opengl.GL2ES1.GL_POINT_SMOOTH;
import static com.jogamp.opengl.GL2ES1.GL_POINT_SMOOTH_HINT;

/**
 * Created by Jakub on 2016-12-03.
 */
public class BasicFrame implements GLEventListener {
    private double angleActual = 0.0f;
    private float length = 0.5f;

    private Point2D.Float Begin = new Point2D.Float(length,-0f);
    private Point2D.Float End = new Point2D.Float(-0.7f,0f);

    private GL2 gl;

    private int lines;

    //recalculeting lines properly to angle
    private void angleRecalculatePoints(){
        Begin.setLocation(Math.sin(angleActual)*length/2,Math.cos(angleActual)*length/2);
    }
    public void RotateLine(double angleRad){
        angleActual = angleActual + angleRad;
        angleRecalculatePoints();
        //gl.glCallList(lines);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        // method body
        gl = drawable.getGL().getGL2();


        //clearing old drawing
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	// Clean the screen and the depth buffer
        gl.glLoadIdentity();									// Reset The Projection Matrix

        lines = gl.glGenLists(1);
        gl.glNewList(lines,gl.GL_LINES);
        //draw line
        gl.glBegin (GL2.GL_LINES);//static field

        gl.glVertex2f(Begin.x,Begin.y);
        gl.glVertex2f(End.x,End.y);

        gl.glVertex2f(-Begin.x,Begin.y);
        gl.glVertex2f(-End.x,End.y);
        gl.glEnd();
        gl.glEndList();

        gl.glBegin(GL2.GL_POINT);
        gl.glEnable(GL_POINT_SMOOTH);
        gl.glHint(GL_POINT_SMOOTH_HINT, GL_NICEST);
        gl.glPointSize(0.3f);
        gl.glVertex2f(-Begin.x/2,Begin.y/2);

        gl.glEnd();


    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
 /*   public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // The GLJpanel class
        GLJPanel gljpanel = new GLJPanel( capabilities );
        BasicFrame b = new BasicFrame();
        gljpanel.addGLEventListener(b);
        gljpanel.setSize(400, 400);

        //creating frame
        final JFrame frame = new JFrame (" Basic Frame");

        //adding canvas to it
        frame.getContentPane().add( gljpanel);
        frame.setSize(400,400);
        frame.setVisible(true);

    }//end of main
*/
}//end of classimport