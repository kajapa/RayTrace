/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;

import fotorealna.Aliasing;
import fotorealna.Collision;
import Primitives.Object;
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

    cVector position;
    int width;
    int aaSamples = 16;
    Color background = Color.BLACK;
    private ObjectLists objects;

    int height;

    public CameraOrtho(boolean aliasing, cVector position, int width, int height, ObjectLists objects) {
        super.setDoubleBuffered(true);
        this.position = position;
        this.aliasing = aliasing;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (aliasing) {

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
                            colorList.add(Primitives.Collision.nearest(collisionList).object.getColor());
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
                else {
                    g2d.setColor(background);
                    g2d.fillRect(i, j, 1, 1);

                    float middleX = (float) (position.x + (i + 0.5));
                    float middleY = (float) (position.y + (j + 0.5));

                    cRay ray = new cRay(new cVector(middleX, middleY, position.z), new cVector(middleX, middleY, 1));

                    for (Object obj : objects.listobjects) {
                       
                        List<Primitives.Collision> collisionList = new ArrayList<>();
                        for (Object object : objects.listobjects) {
                            Primitives.Collision intersect = object.intersect(ray);
                            if (intersect != null) {
                                
                                collisionList.add(intersect);
                            }
                        }

                        if (collisionList != null && collisionList.size() > 0) {
                            g2d.setColor(Primitives.Collision.nearest(collisionList).object.getColor());
                            g2d.fillRect(i, j, 1, 1);
                            break;
                        }

                    }

                }

            }
        }
        System.out.println("Finished Render");
    }


    public Color newColor(int r, int g, int b) {
        return new Color(max(0, min(255, r)), max(0, min(255, g)), max(0, min(255, b)));
    }
}
