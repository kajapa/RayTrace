/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model3DParser;

import Primitives.cVector;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Patryk
 */
public class OBJLoader {

    public OBJLoader() {
    }

    public static Model3D loadModel(File f) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        Model3D m = new Model3D();
        String line;
        while ((line = reader.readLine()) != null) {

            if (line.startsWith("v ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);

                m.verticies.add(new cVector(x, y, z));
            }
            else if (line.startsWith("vn ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);

                m.normals.add(new cVector(x, y, z));

            }
            else if (line.startsWith("f ")) {
                String test="f 1//8 297//8 11//8";
                
                if(line.endsWith(line.split(" ")[3].split("/")[0])){
                int v1 = Integer.valueOf(line.split(" ")[1].split("/")[0]);
                System.out.printf("\n"+"v1 "+v1);
                int v2 = Integer.valueOf(line.split(" ")[2].split("/")[0]);
                System.out.printf("\n"+"v2 "+v2);
                int v3 = Integer.valueOf(line.split(" ")[3].split("/")[0]);
                
                System.out.printf("\n"+"v3 "+v3);
                 int n = Integer.valueOf(line.split(" ")[1].split("/")[2]);

                m.faces.add(new Face(v1, v2, v3, 0, n));
                }
                else{
                     int v1 = Integer.valueOf(line.split(" ")[1].split("/")[0]);
                System.out.printf("\n"+"v1 "+v1);
                int v2 = Integer.valueOf(line.split(" ")[2].split("/")[0]);
                System.out.printf("\n"+"v2 "+v2);
                int v3 = Integer.valueOf(line.split(" ")[3].split("/")[0]);

                int v4 = Integer.valueOf(line.split(" ")[4].split("/")[0]);
                System.out.printf("\n"+"v4 "+v4);
                int n = Integer.valueOf(line.split(" ")[1].split("/")[2]);

                m.faces.add(new Face(v1, v2, v3, v4, n));}

            }
        }
        reader.close();
        return m;
    }
}
