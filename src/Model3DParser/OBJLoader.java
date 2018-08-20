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
        Face fa = new Face();
        while ((line = reader.readLine()) != null) {

            if (line.startsWith("mtllib ")) {

              m.materialmap= MTLLoader.loadMaterial(new File(line.split(" ")[1]));

            }
           else if (line.startsWith("v ")) {
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

            else if (line.startsWith("usemtl ")) {

                    fa.setMaterialname(line.split(" ")[1]);
            }

            else if (line.startsWith("f ")) {
        
                
                
                int v1 = Integer.valueOf(line.split(" ")[1].split("/")[0]);
                fa.setV1(v1);
                System.out.printf("\n"+"v1 "+v1);
                int v2 = Integer.valueOf(line.split(" ")[2].split("/")[0]);
                fa.setV2(v2);
                System.out.printf("\n"+"v2 "+v2);
                int v3 = Integer.valueOf(line.split(" ")[3].split("/")[0]);
                fa.setV3(v3);
                
                System.out.printf("\n"+"v3 "+v3);
                 int n = Integer.valueOf(line.split(" ")[1].split("/")[2]);
                 fa.setN(n);


               // m.faces.add(new Face(v1, v2, v3, n));
                
               

            }
            m.faces.add(fa);

        }
        reader.close();
        return m;
    }
}
