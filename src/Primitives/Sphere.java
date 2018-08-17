/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Material.Material;

import java.awt.Color;

/**
 *
 * @author Patryk
 */
public class Sphere extends Primitive {

    float Ray;
    cVector center;

    Material kolor;

    // KONSTRUKTOR 
    public Sphere(cVector center, float Ray, Material kolor,cVector normal) {
        super(kolor,normal);

        this.kolor = kolor;
        this.center = center;
        this.Ray = Ray;

    }

    // GET
    public cVector getCenter() {
        return this.center;
    }

    public float getRay() {
        return this.Ray;
    }

    // SET
    public void setCenter(cVector point) {
        this.center = point;
    }

    public void setRay(float Ray) {
        this.Ray = Ray;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Sphere [center=" + center + ", Ray=" + Ray + "]";
    }

    @Override
    public Collision intersect(cRay Ray) {
        cVector v, dir;

        v = new cVector().sub(Ray.getOrigin(), getCenter());
        dir = Ray.getDirection();

        float b = (v.dot(Ray.getDirection()));
        float det = (b * b) - dir.dot(dir) * (v.dot(v) - getRay() * getRay());

        if (det < 0) {
            //logger.info("Brak przeciecia");
            return null;
        }

        det = (float) Math.sqrt(det);

        if (det == 0) {

            //Ray.getIntersectPoint(b);
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(-b).toString());
            //return Ray.getIntersectPoint(-b);
            return null;

        }
        else {
            double t1 = -b + det;
            double t2 = -b - det;
            double dist = t1 < t2 ? t1 : t2;
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(dist).toString());
            //return Ray.getIntersectPoint(dist);
            return new Collision(Ray.getOrigin(), Ray.getIntersectPoint(dist), this);

        }

    }

}
