/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.awt.Color;

/**
 *
 * @author Patryk
 */
public abstract class Object {

    private Color color;
    

    public Object(Color color) {
        this.color = color;
        

    }

    public abstract Collision intersect(cRay Ray);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    

}
