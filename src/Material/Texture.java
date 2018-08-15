package Material;

import Primitives.cVector;

public class Texture {
    public int Width;
    public int Height;
    //public Intensity[,] ColorMap;
    public void SphericalMap(cVector local_hit_point, int xres,int yres,int row,int column){

        float theta = (float) Math.acos(local_hit_point.y);
        float phi =(float)  Math.atan2(local_hit_point.x, local_hit_point.z);
        if (phi < 0.0)
            phi += 2*Math.PI;
// następnie, konwertujemy theta i phi do (u, v) w [0, 1] X [0, 1]
     //   float u = phi * invTWO_PI;
       // float v = 1.0 - theta * invPI;
// na końcu, przekształcamy u oraz v współrzędnych texela
      //  column = (int) ((xres - 1) * u); // kolumna jest poziomo
        //row = (int) ((yres - 1) * v);

    };
}
