/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Cameras.CameraOrtho;
import Cameras.CameraPerpectiv;
import Model3DParser.Face;
import Model3DParser.Loader;
import Model3DParser.Model3D;
import Model3DParser.OBJLoader;
import Primitives.ObjectLists;
import Primitives.Quad;
import Primitives.cVector;
import Primitives.Triangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Patryk
 */
public class RayTracer extends JFrame {

    private static final Logger logger = Logger.getLogger("Log");
    Color red = new Color(255, 0, 0);
    Color blue = new Color(0, 0, 255);
    Color green = new Color(0, 255, 0);

    int width = 800;
    int height = 600;
    private ObjectLists objects = new ObjectLists();
    private ObjectLists objects2 = new ObjectLists();

    public RayTracer() throws IOException {
        super.setSize(width, height);
        CameraOrtho paint = new CameraOrtho(false, new cVector(0, 0, 5), width, height, objects);
        // objects.addToList(new Triangle(new cVector(100,100,-50),new cVector(100,300,0),new cVector(300,100,0),red));
        //objects.addToList(new Quad(new cVector(200, 400, 0), new cVector(200, 200, 0), new cVector(600, 200, 0), new cVector(600, 400, 0), red));

        //OBJ Object



        /*objects.addToList(new Triangle(new cVector(300,300,0),new cVector(300,500,0), new cVector(500,300,0), red));
        objects.addToList(new Triangle(new cVector(300,500,0),new cVector(500,500,0), new cVector(500,300,0), blue));
        objects.addToList(new Triangle(new cVector(500,300,10).rotateAxis(30, 'x'),new cVector(500,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), red));
        objects.addToList(new Triangle(new cVector(500,500,10).rotateAxis(30, 'x'),new cVector(700,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), blue));*/

                Loader load = new Loader();
               
               // objects.Transfer( load.Loadtriangle("cubex45.obj", new cVector(200,200,0), 32, 0, 0, 0).listobjects);

        objects.Transfer( load.Loadtriangle("cube.obj", new cVector(400,250,0), 20, 0, 30, 30).listobjects);
                
               
           
           


        /* objects.addToList(new Sphere(new cVector(480, 480, 50f), 200f, blue));
        objects.addToList(new Sphere(new cVector(750, 480, 50f), 130f, red));
        
         */
        //------------------------------------------------------
        CameraPerpectiv paint2 = new CameraPerpectiv(120, new cVector(width / 2, height / 2, -64), false, width, height, objects2);

        System.out.println("Object list elements:" + objects.listobjects.size());
        super.setLayout(new BorderLayout());

        super.setTitle("Fotoreal");

        super.setLocation(0, 0);
        super.setResizable(false);

        super.add(paint);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new RayTracer();

//Plane P = new Quad(new cVector(0.0f, 0.0f, 0.0f), new cVector(0.0f, 1.0f, 1.0f));
//P.Plane_intersect(R2);
//cRay R3 = new cRay(new cVector(0.5f, 0.7f, 0.0f), new cVector(0.0f, 0.0f, 1.0f));
//System.out.println(R3.getIntersectPoint(5).toString());
    }

    public static Color randomColor() {
        Random r = new Random();
        return new Color((int) (r.nextFloat() * 255), (int) (r.nextFloat() * 255), (int) (r.nextFloat() * 255));
    }

}
