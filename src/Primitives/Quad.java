/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Material.Material;

import static Primitives.Triangle.kEpsilon;
import java.awt.Color;
import java.util.logging.Logger;

/**
 *
 * @author Patryk
 */
public class Quad extends Primitive {

    private cVector point, N, v0, v1, v2, v3;
    public float sx, sy;
    private static final Logger logger = Logger.getLogger("Log");
    int r, g, b;
    Material kolor ;

//    public Quad(cVector point, cVector N, float sx, float sy, Color kolor) {
//
//        super(kolor);
//        this.point = point;
//        this.N = N;
//        this.sx = sx;
//        this.sy = sy;
//
//        this.kolor = kolor;
//        
//    }
    public Quad(cVector v0, cVector v1, cVector v2, cVector v3, cVector N, Material kolor,cVector normal) {

        super(kolor,normal);
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.N = N;

        this.kolor = kolor;

    }

// GET
    public cVector getPoint() {
        return this.point;
    }

    public cVector normal() {
        return this.N;
    }

    // SET
    public void setPoint(cVector point) {
        this.point = point;
    }

    public void setN(cVector vector) {
        this.N = vector;
    }

    @Override

    public Collision intersect(cRay Ray) {

        //----- Plane's N
        cVector v0v1 = new cVector().sub(v1, v0);
        cVector v1v3 = new cVector().sub(v3, v1);

        cVector v0v2 = new cVector().sub(v2, v0);

        //cVector N = new cVector().getVectorProduct(v0v2,v1v3 );//<-----Normal
        float NdotRayDirection = N.dot(Ray.getDirection());//<---- if 
        if (Math.abs(NdotRayDirection) < kEpsilon) {//<---- if ray and plane are parallel
            //System.out.println("False0");
            return null;
        }
        float d = N.dot(v0);
        float t = (N.dot(Ray.getOrigin()) + d) / NdotRayDirection;
        if (t < 0) {//<----if triangle is behind ray
            //System.out.println("False1");
            return null;
        }
        cVector C;
        cVector P = Ray.getOrigin().add(Ray.getDirection().multiuplayby(t));
        //Edge0
        cVector edge0 = new cVector().sub(v1, v0);
        cVector vp0 = new cVector().sub(P, v0);
        C = edge0.getVectorProduct( vp0);
        if (N.dot(C) < 0) {//<--- if P is on right side
            // System.out.println("False2");
            return null;
        }
        //Edge1
        cVector edge1 = new cVector().sub(v2, v1);
        cVector vp1 = new cVector().sub(P, v1);
        C = edge1.getVectorProduct(vp1);
        if (N.dot(C) < 0) {//<--- i P is on right side
            //System.out.println("False3");
            return null;
        }

        //Edge2
        cVector edge2 = new cVector().sub(v3, v2);
        cVector vp2 = new cVector().sub(P, v2);
        C = edge2.getVectorProduct( vp2);
        if (N.dot(C) < 0) {//<--- if P is on right side
            //System.out.println("False4");
            return null;
        }

        //Edge3
        cVector edge3 = new cVector().sub(v0, v3);
        cVector vp3 = new cVector().sub(P, v3);
        C = edge3.getVectorProduct(vp3);
        if (N.dot(C) < 0) {//<--- if P is on right side
            //System.out.println("False5");
            return null;
        }
        return new Collision(Ray.getOrigin(), C, this);

    }

}
