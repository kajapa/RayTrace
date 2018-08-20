package Light;

import Material.Material;
import Objects.Object;
import Primitives.Collision;
import Primitives.ObjectLists;
import Primitives.cRay;
import Primitives.cVector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Phong {

    private float middleX;
    private float middleY;
    private Graphics2D g2d;
    private cRay ray;
    private PointLight light;
    private Color background=Color.BLACK;
    private ObjectLists objects;
    private boolean alias;

    public Phong( PointLight light, Color background, ObjectLists objects, boolean alias) {

        this.light = light;
        this.background = background;
        this.objects = objects;
        this.alias = alias;
    }

    public void SetPhong(float middleX, float middleY, Graphics2D g2d, cRay ray,int i , int j){

        float a=20.f; // shininess
        //tymaczasowe parametry do zmiany!
        //float specularcouef = 2.f;
        float ks = 5.f;
        float kd = 1.f;
        cVector aIntestity = new cVector(0.f,0.f,0.f);



        g2d.setColor(background);
        g2d.fillRect(i, j, 1, 1);





        List<Collision> collisionList = new ArrayList<>();
        for (Object object : objects.listobjects)
        {
            Primitives.Collision intersect = object.intersect(ray);
            if (intersect != null) {
                float r,g,b,cosinus;

                cVector ambient= intersect.primitive.getColor().getkAmbient();
                System.out.printf("\n"+"Ambient phong "+ambient.toString());
                cVector diffuse=intersect.primitive.getColor().getkDiffuse();
                cVector specular= intersect.primitive.getColor().getkSpecular();
                float alpha=intersect.primitive.getColor().getAlpha();


                cVector L = light.getPosition().subtract(intersect.collisionPoint).normalize();
                cVector N = intersect.primitive.normal.normalize();
                cVector V = ray.getDirection().normalize();



                // dot z N i L
                float NL = N.dot(L);
                cVector R = N.multiuplayby(NL * 2.f).subtract(L);

                //cVector I=
                //cVector N= intersect.primitive.normal;
                //cVector R= new cVector().sub(I,(N.multiuplayby(N.dot(I)*2.0f)));    //kierunek odbicia



                float ss =R.dot(V);
               // double specular=Math.pow((double)ss,(double)a);

                //if(-ss>0)
                //{
                //    specular=Math.pow((double)ss,(double)a);
                //}
                //specular*=specularcouef;
                cVector sIntesity=  light.getIntesity().getVectorProduct(specular).normalize();
                //cosinus= L.dot(N);
                if(NL < 0) NL = 0;

                //r=light.getIntesity().x*kd *NL;
               // g=light.getIntesity().y*kd *NL;
                //b=light.getIntesity().z*kd *NL;

                cVector diffuseIntenisty =light.getIntesity().getVectorProduct(diffuse).multiuplayby(NL).add(aIntestity);
                        //new cVector(r,g,b).add(aIntestity);
                cVector PixelVector = sIntesity.add(diffuseIntenisty);

                PixelVector = PixelVector.normalize();



               // Color PixelColor = new Color(PixelVector.x,PixelVector.y,PixelVector.z);
                //Color PixelColor = new Color(1.f,1.f,1.f);
                //collisionList.add(intersect);
                g2d.setColor(PixelVector.vectorToColor());
                g2d.fillRect(i, j, 1, 1);
            }
            else
            {
                Color PixelColor= new Color(aIntestity.x,aIntestity.y,aIntestity.z);
                g2d.setColor(PixelColor);
                g2d.fillRect(i, j, 1, 1);

            }
        }

            /*if (collisionList != null && collisionList.size() > 0) {
                g2d.setColor(Primitives.Collision.nearest(collisionList).primitive.getColor());
                g2d.fillRect(i, j, 1, 1);
                break;
            }*/



    }
}
