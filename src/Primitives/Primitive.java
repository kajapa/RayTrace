package Primitives;

import java.awt.*;

public abstract class Primitive {
    private Color color;
    public cVector normal;



    public Primitive(Color color,cVector normal) {
        this.color = color;
        this.normal=normal;



    }

    public abstract Collision intersect(cRay Ray);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;

    }

}
