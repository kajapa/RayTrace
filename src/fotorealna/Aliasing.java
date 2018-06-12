/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotorealna;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patryk
 */
public class Aliasing {

    float x, y;
    List<Pixel> pixellist = new ArrayList<Pixel>();
    Pixel alfa;

    public Aliasing(float x, float y) {
        this.x = x;
        this.y = y;
        this.alfa = new Pixel(this.x, this.y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public List<Pixel> getAliasingPixels(int samples) {
        pixellist.clear();
        float delta = 1f / (samples / 4);
        for (float i = -1; i < 1; i += delta) {
            for (float j = -1; j < 1; j += delta) {
                float xx = x + (i);
                float yy = y + (j);
                pixellist.add(new Pixel(xx, yy));
            }
        }

        return pixellist;
    }
}
