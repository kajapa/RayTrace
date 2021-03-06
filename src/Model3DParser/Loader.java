package Model3DParser;

import Material.Material;
import Objects.Mesh;
import Primitives.ObjectLists;
import Primitives.Triangle;
import Primitives.cVector;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


public class Loader{

    public ObjectLists objects = new ObjectLists();
    
    public ObjectLists Loadtriangle(String file,cVector position, int scale,int rx,int ry,int rz)
    {
        Material mat=new Material();
    Model3D m = null;
        try {
            m = OBJLoader.loadModel(new File(file));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        
        
        /*objects.addToList(new Triangle(new cVector(300,300,0),new cVector(300,500,0), new cVector(500,300,0), red));
        objects.addToList(new Triangle(new cVector(300,500,0),new cVector(500,500,0), new cVector(500,300,0), blue));
        objects.addToList(new Triangle(new cVector(500,300,10).rotateAxis(30, 'x'),new cVector(500,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), red));
        objects.addToList(new Triangle(new cVector(500,500,10).rotateAxis(30, 'x'),new cVector(700,500,10).rotateAxis(30, 'x'), new cVector(700,300,10).rotateAxis(30, 'x'), blue));*/

        int i = 0;
        Color[] kolory={Color.RED,Color.BLUE,Color.GREEN,Color.PINK,Color.YELLOW,Color.WHITE};
             Mesh mesh= new Mesh();
        for (Face face : m.faces) {
           

                cVector v1 = new cVector(m.verticies.get(face.v1 - 1)).multiuplayby(scale).rotateAxis(rx, ry, rz).add(position);
               /* System.out.printf("\n\rFace: " + i++);
                System.out.printf("\n\rPrzed skalowaniem: "+v1.toString()+" Po skalowaniu: "+ v1.multiuplayby(32).toString());
                System.out.printf("\n\rPrzed rotacja: "+v1.toString()+" Po rotacji: "+ v1.rotateAxis(45, 'x').toString());
                System.out.printf("\n\rPrzed przesunieciem: "+v1.toString()+" Po przesunieciu: "+ v1.add(position).toString());*/
                
                cVector v2 = new cVector(m.verticies.get(face.v2 - 1)).multiuplayby(scale).rotateAxis(rx, ry, rz).add(position);
                cVector v3 = new cVector(m.verticies.get(face.v3 - 1)).multiuplayby(scale).rotateAxis(rx, ry, rz).add(position);
                String material= face.materialname;
                mat=m.materialmap.get(material);
            System.out.println("Ambient z face"+mat.getkAmbient().toString());
              
                cVector n = new cVector(m.normals.get(face.n - 1)).add(position);
                mesh.triangles.add(new Triangle(v1, v2, v3,n,mat));
                //System.out.println(v1.toString() + v2.toString() + v3.toString() + v4.toString() + "normal: " + n.toString());

    
    
    
    
        }

        objects.addToList(mesh);//kolory[(int)i++/2])
        return objects;
    }

    public static Color randomColor() {
        Random r = new Random();
        return new Color((int) (r.nextFloat() * 255), (int) (r.nextFloat() * 255), (int) (r.nextFloat() * 255));
    }
}