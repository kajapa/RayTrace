package Model3DParser;

import Material.Material;
import Primitives.cVector;

import java.io.*;
import java.util.*;

public class MTLLoader {
    public MTLLoader(){}


    public static HashMap<String,Material> loadMaterial(File f) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        HashMap<String,Material> materialmap = new HashMap<String,Material>();
        Material p=new Material();
        String materialname=null;




        String line;
        while ((line = reader.readLine()) != null) {

            if (line.startsWith("newmtl ")) {
                materialname=line.split(" ")[1];


            }
            else if (line.startsWith("Ka ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);

               p.setkAmbient(new cVector(x, y, z));
                System.out.printf("\n"+"Ambient "+new cVector(x, y, z).toString());

            }
            else if (line.startsWith("Kd ")) {


                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);

                p.setkDiffuse(new cVector(x, y, z));
                System.out.printf("\n"+"Diffuse "+new cVector(x, y, z).toString());


            }
            else if (line.startsWith("Ks ")) {


                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);

                p.setkSpecular(new cVector(x, y, z));
                System.out.printf("\n"+"Specular "+new cVector(x, y, z).toString());



            }
            else if (line.startsWith("Ni ")) {
                p.setAlpha(Float.valueOf(line.split(" ")[1]));


            }
            System.out.printf("\n"+materialname);
            materialmap.put(materialname,p);


        }
        Set set2 = materialmap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            System.out.print("\n"+"Key is: "+mentry2.getKey()+ " & Value is: " +mentry2.getValue() );

        }


        reader.close();
        return materialmap;
    }
}
