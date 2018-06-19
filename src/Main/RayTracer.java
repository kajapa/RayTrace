/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Cameras.CameraOrtho;
import Cameras.CameraPerpectiv;
import Model3DParser.Face;
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
        Model3D m = null;
        try {
            m = OBJLoader.loadModel(new File("pyramid.obj"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        float a = 0;
        float b = 0;

        int scale = 32;
        cVector position = new cVector(100, 0, 0);
        /*objects.addToList(new Triangle(new cVector(300,300,0),new cVector(300,500,0), new cVector(500,300,0), red));
        objects.addToList(new Triangle(new cVector(300,500,0),new cVector(500,500,0), new cVector(500,300,0), blue));
        objects.addToList(new Triangle(new cVector(500,300,10).rotateAxis(30, 'x'),new cVector(500,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), red));
        objects.addToList(new Triangle(new cVector(500,500,10).rotateAxis(30, 'x'),new cVector(700,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), blue));*/

        for (Face face : m.faces) {
           

                cVector v1 = new cVector(m.verticies.get(face.v1 - 1)).multiuplayby(16).add(position).rotateAxis(90, 'x').rotateAxis(60, 'x');
                //System.out.printf("Przed skalowaniem: "+v1.toString()+" Po skalowaniu: "+ v1.scaleVector(new cVector(1,0.5f,1)).toString());
                cVector v2 = new cVector(m.verticies.get(face.v2 - 1)).multiuplayby(16).add(position).rotateAxis(90, 'x').rotateAxis(60, 'x');
                cVector v3 = new cVector(m.verticies.get(face.v3 - 1)).multiuplayby(16).add(position).rotateAxis(90, 'x').rotateAxis(60, 'x');

              
                cVector n = new cVector(m.normals.get(face.n - 1));

                //System.out.println(v1.toString() + v2.toString() + v3.toString() + v4.toString() + "normal: " + n.toString());
                objects.addToList(new Triangle(v1, v2, v3, randomColor()));
               
           
           
        }

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
