/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Material.Material;

import java.awt.Color;
import java.util.logging.Logger;

/**
 *
 * @author Patryk
 */
public class Plane extends Primitive {

    private cVector point;
    public float sx, sy;
    private static final Logger logger = Logger.getLogger("Log");
    int r, g, b;
    Material kolor ;

    public Plane(cVector point, cVector normal, float sx, float sy, Material kolor) {

        super(kolor,normal);
        this.point = point;
        this.normal = normal;
        this.sx = sx;
        this.sy = sy;

        this.kolor = kolor;

    }

// GET
    public cVector getPoint() {
        return this.point;
    }

    public cVector normal() {
        return this.normal;
    }

    // SET
    public void setPoint(cVector point) {
        this.point = point;
    }

    public void setNormal(cVector vector) {
        this.normal = vector;
    }

    @Override
    public Collision intersect(cRay Ray) {

        float d = normal.dot(point);
        float t = (d - normal.dot(Ray.getOrigin()) / normal.dot(Ray.getDirection()));
        cVector v = Ray.getOrigin().add(Ray.getDirection().multiuplayby(t));
        return new Collision(Ray.getOrigin(), v, this);

    }

}
