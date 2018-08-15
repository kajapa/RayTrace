/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;

import Primitives.Collision;
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

/**
 *
 * @author Patryk
 */
public class CameraPerpectiv extends JPanel {

    private ObjectLists objects;
    cVector position;
    boolean alias;
    float field;
    int width;
    int height;
    int aaSamples = 16;
    Color background = Color.BLACK;

    public CameraPerpectiv(float field, cVector position, boolean alias, int width, int height, ObjectLists objects) {
        super.setDoubleBuffered(true);
        this.field = field;
        this.position = position;
        this.alias = alias;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        float aspect = (float) width / (float) height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (alias) {
                    Aliasing alias = new Aliasing(i, j);
                    List<Color> colorList = new ArrayList<>();
                    for (Pixel p : alias.getAliasingPixels(aaSamples)) {

                        float middleX = (float) ((2.0 * (p.x + 0.5) / width - 1.0) * Math.tan(field / 2 * Math.PI / 180.0) * aspect);
                        float middleY = (float) ((1.0 - 2.0 * (p.y + 0.5) / height) * Math.tan(field / 2 * Math.PI / 180.0));
                        cVector dir = new cVector(position.x - middleX, position.y - middleY, position.z - 1);

                        ///cRay ray = new cRay(position, dir.normalize());
                        cRay ray = new cRay(position, dir);

                        boolean inter = false;
                        List<Collision> collisionList = new ArrayList<>();
                        for (Object object : objects.listobjects) {
                            Collision intersect = object.intersect(ray);
                            if (intersect != null) {
                                inter = true;
                                collisionList.add(intersect);
                            }
                        }
                        if (collisionList != null && collisionList.size() > 0) {
                            colorList.add(Collision.nearest(collisionList).primitive.getColor());
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

                    float middleX = (float) ((2.0 * (i + 0.5) / width - 1.0) * Math.tan(field / 2 * Math.PI / 180.0) * aspect);
                    float middleY = (float) ((1.0 - 2.0 * (j + 0.5) / height) * Math.tan(field / 2 * Math.PI / 180.0));
                    
                    ///cRay ray = new cRay(position, dir.normalize());
                    cRay ray = new cRay(position, new cVector(i - middleX, j - middleY, 0));

                    for (Object obj : objects.listobjects) {
                        
                        List<Collision> collisionList = new ArrayList<>();
                        for (Object object : objects.listobjects) {
                            Collision intersect = object.intersect(ray);
                            if (intersect != null) {
                                
                                collisionList.add(intersect);
                            }
                        }

                        if (collisionList != null && collisionList.size() > 0) {
                            g2d.setColor(Collision.nearest(collisionList).primitive.getColor());
                            g2d.fillRect(i, j, 1, 1);
                            break;
                        }

                    }
                }

            }
        }
    }

    public Color newColor(int r, int g, int b) {
        return new Color(max(0, min(255, r)), max(0, min(255, g)), max(0, min(255, b)));
    }
}
