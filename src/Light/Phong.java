package Light;

import Primitives.ObjectLists;
import Primitives.cRay;
import Primitives.cVector;

import java.awt.*;

public class Phong {
   /* boolean aliasing;

    cVector position;
    int width;
    int height;
    //  int aaSamples = 16;
    //Color background = Color.BLACK;
    private ObjectLists objects;

    public Phong(cVector position, int width, int height, ObjectLists objects) {

        this.position = position;
        this.aliasing = aliasing;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }


    public void Draw(){
    for(int i = 0;i<width;i++)

    {
        for (int j = 0; j < height; j++) {
            //srodekX = -1.8f + (i + 0.5f) * widthPixel;
            srodekY = 1.0f - (j + 0.5f) * heightPixel;
            cRay ray = new cRay(new cVector(0, 0, 1), new cVector(srodekX,srodekY, 0));
            Point intersetion = s.intersect(ray);
            if (intersetion != null) {
//Vector n = new Vector(s.getCenter(), intersetion);
//Vector l = new Vector(intersetion, source.getPosition());
                float r, g, b, cosinus;
                cVector I = ray.getDirection().normalize();
                cVector N = s.normal(intersetion);
                cVector  R = I - (new cVector(N,N.dot(I))  * 2.0f);
                ss = ray.getDirection().normalize().dot(R);
                if (-ss > 0) {
                    specular = Math.Pow(ss, a);
                } else {
                    specular = 0;
                }
                specular *= specularCoef;
                sIntensity = source.Intensity * specular;
// diffuse
                cosinus = ray.getDirection().normalize().dot(s.normal(intersetion));
                r = -source.Intensity.getRed() * k * cosinus;
                g = -source.Intensity.getGreen() * k * cosinus;
                b = -source.Intensity.getBlue() * k * cosinus;
                Intensity diffuseIntensity = new Intensity(255, g,
                        b) + aIntensity;
                img.setPixel(i, j, sIntensity + diffuseIntensity);
            } else img.setPixel(i, j, aIntensity);
        }
    }
}*/
}
