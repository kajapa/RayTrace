/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;

import Light.Phong;
import Light.PointLight;
import fotorealna.Aliasing;
import Objects.Object;
import Primitives.ObjectLists;
import fotorealna.Pixel;
import Primitives.cRay;
import Primitives.cVector;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CameraOrtho extends JPanel {

    boolean aliasing;
   PointLight light;
    cVector position;
    int width;
    int aaSamples = 16;
    Color background = Color.BLACK;
    private ObjectLists objects;

    int height;


    public CameraOrtho(boolean aliasing, cVector position, PointLight light, int width, int height, ObjectLists objects) {
        super.setDoubleBuffered(true);
        this.position = position;
        this.light = light;
        this.aliasing = aliasing;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Phong phong = new Phong(light,background,objects,aliasing);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (aliasing) {
                        SetAlliasing(g2d,i,j);


                }
                else {
                    float middleX = (float) (position.x + (i + 0.5));
                    float middleY = (float) (position.y + (j + 0.5));
                    cRay ray = new cRay(new cVector(middleX, middleY, position.z), new cVector(middleX, middleY, 1));

                    phong.SetPhong(middleX,middleY,g2d,ray,i,j);

                   //SetPhong(g2d,i,j);

                }

            }
        }
        System.out.println("Finished Render");
    }


    public Color newColor(int r, int g, int b) {
        return new Color(max(0, min(255, r)), max(0, min(255, g)), max(0, min(255, b)));
    }

    public void SetAlliasing( Graphics2D g2d, int i ,int j){

        Aliasing alias = new Aliasing(i, j);
        List<Color> colorList = new ArrayList<>();
        for (Pixel p : alias.getAliasingPixels(aaSamples)) {
            float middleX = (float) (position.x + (p.x + 0.5));
            float middleY = (float) (position.y + (p.y + 0.5));
            cRay ray = new cRay(new cVector(middleX, middleY, position.z), new cVector(middleX, middleY, 1));

            boolean inter = false;
            List<Primitives.Collision> collisionList = new ArrayList<>();
            for (Object object : objects.listobjects) {
                Primitives.Collision intersect = object.intersect(ray);
                if (intersect != null) {
                    inter = true;
                    collisionList.add(intersect);
                }
            }
            if (collisionList != null && collisionList.size() > 0) {
                //colorList.add(Primitives.Collision.nearest(collisionList).primitive.getColor());
            }

            if (!inter) {
                colorList.add(background);
            }
        }

        int rr = 0, gg = 0, bb = 0;
        for (Color color : colorList) {
            rr += (color.getRed());
            gg += (color.getGreen());
            bb += (color.getBlue());
        }

        rr /= colorList.size();
        gg /= colorList.size();
        bb /= colorList.size();

        Color col = newColor(rr, gg, bb);
        g2d.setColor(col);

        g2d.fillRect(i, j, 1, 1);

    }
    public void SetPhong(Graphics2D g2d, int i ,int j){
        float a=20.f; // shininess
        //tymaczasowe parametry do zmiany!
        //float specularcouef = 2.f;
        float ks = 5.f;
        float kd = 1.f;
        cVector aIntestity = new cVector(0.f,0.f,0.f);



        g2d.setColor(background);
        g2d.fillRect(i, j, 1, 1);

        float middleX = (float) (position.x + (i + 0.5));
        float middleY = (float) (position.y + (j + 0.5));

        cRay ray = new cRay(new cVector(middleX, middleY, position.z), new cVector(middleX, middleY, 1));



            List<Primitives.Collision> collisionList = new ArrayList<>();
            for (Object object : objects.listobjects)
            {
                Primitives.Collision intersect = object.intersect(ray);
                if (intersect != null) {
                    float r,g,b,cosinus;

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
                    double specular=Math.pow((double)ss,(double)a);

                    //if(-ss>0)
                    //{
                    //    specular=Math.pow((double)ss,(double)a);
                    //}
                    //specular*=specularcouef;
                     cVector sIntesity=  light.getIntesity().multiuplayby((float)specular).normalize();
                     //cosinus= L.dot(N);
                    if(NL < 0) NL = 0;
                     r=light.getIntesity().x*kd *NL;
                     g=light.getIntesity().y*kd *NL;
                     b=light.getIntesity().z*kd *NL;
                     cVector diffuseIntenisty = new cVector(r,g,b).add(aIntestity);
                    cVector PixelVector = sIntesity.add(diffuseIntenisty);

                    PixelVector = PixelVector.normalize();



                    Color PixelColor = new Color(PixelVector.x,PixelVector.y,PixelVector.z);
                    //Color PixelColor = new Color(1.f,1.f,1.f);
                    //collisionList.add(intersect);
                    g2d.setColor(PixelColor);
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

