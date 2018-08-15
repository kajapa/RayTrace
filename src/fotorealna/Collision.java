/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotorealna;

import Primitives.cVector;
import Primitives.Sphere;
import Primitives.cRay;
import Primitives.Quad;
import java.awt.Color;

/**
 *
 * @author Patryk
 */
public class Collision {

    public boolean intersect(cRay Ray, Sphere sphere) {

        cVector v, dir;
        v = new cVector().sub(Ray.getOrigin(), sphere.getCenter());
        dir = Ray.getDirection();

        float b = (v.dot(Ray.getDirection()));
        float det = (b * b) - dir.dot(dir) * (v.dot(v) - sphere.getRay() * sphere.getRay());

        if (det < 0) {
            //logger.info("Brak przeciecia");
            return false;
        }

        det = (float) Math.sqrt(det);

        if (det == 0) {

            //Ray.getIntersectPoint(b);
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(-b).toString());
            //return Ray.getIntersectPoint(-b);
            return true;

        }
        else {
            double t1 = -b + det;
            double t2 = -b - det;
            double dist = t1 < t2 ? t1 : t2;
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(dist).toString());
            //return Ray.getIntersectPoint(dist);
            return true;

        }

    }

    public boolean intersect(cRay Ray, Quad Plane, int i, int j) {

        float d = Plane.normal().dot(Plane.getPoint());
        float t = (d - Plane.normal().dot(Ray.getOrigin()) / Plane.normal().dot(Ray.getDirection()));
        cVector v = new cVector();
        v = Ray.getOrigin().add(Ray.getDirection().multiuplayby(t));
        if (i > (int) Plane.normal().x - Plane.sx && i < (int) Plane.normal().x + Plane.sx) {
//System.out.println("Kolizja");
            if (j > (int) Plane.normal().y - Plane.sy && j < (int) Plane.normal().y + Plane.sy && v != null) {
                    return true;
            }
        }
        return false;

    }

    public boolean intersectPlane(cRay Ray, Quad plane) {

        float t = Float.MAX_VALUE;
        float d = plane.normal().dot(plane.getPoint());
        float dot1 = plane.normal().dot(Ray.getOrigin());
        float dot2 = plane.normal().dot(Ray.getDirection());
        if (dot2 != 0) {
            t = ((d - dot1) / dot2);
            if (t > 0) {
                return true;
            }
        }

        return false;
    }
}
