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
public class Triangle extends Object {

    public static final float kEpsilon = 0.000001f;

    public cVector p1;
    public cVector p2;
    public cVector p3;

    public cVector center;

    public Triangle(cVector p1, cVector p2, cVector p3, Color color) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        center = new cVector((p1.x + p2.x + p3.x) / 3, (p1.y + p2.y + p3.y) / 3, (p1.z + p2.z + p3.z) / 3);
    }

    @Override
    public Collision intersect(cRay ray) {
        float dist;
        cVector normal;
        cVector edge1 = cVector.sub(p2, p1);
        cVector edge2 = cVector.sub(p3, p1);
        cVector pV = cVector.cross(ray.getDirection(), edge2);
        float det = edge1.dot(pV);

        if (det > -kEpsilon && det < kEpsilon) {
            return null;
        }

        float invDet = 1.0f / det;

        cVector tV = cVector.sub(ray.getOrigin(), p1);
        float u = tV.dot(pV) * invDet;
        if (u < 0f || u > 1f) {
            return null;
        }

        cVector qV = cVector.cross(tV, edge1);

        float v = ray.getDirection().dot(qV) * invDet;
        if (v < 0.0f || (u + v) > 1.0f) {
            return null;
        }

        float t = edge2.dot(qV) * invDet;

        cVector result = new cVector(cVector.addVectors((cVector.multiply(ray.getDirection(), t)), ray.getOrigin()));
        normal = cVector.sub(result, new cVector((p1.x + p2.x + p3.x) / 3, (p1.y + p2.y + p3.y) / 3, (p1.z + p2.z + p3.z / 3))).normalized();
        dist = cVector.distance(result, ray.getOrigin());
        return new Collision(ray.getOrigin(), result, this);
    }

//    public cVector v0;
//    public cVector v1;
//    public cVector v2;
//    //public cVector N;
//
//    public Color color;
//    public static float kEpsilon = (float) 1e-8;
//
//    public Triangle(cVector v0, cVector v1, cVector v2, Color color) {
//        super(color);
//        this.v0 = v0;
//        this.v1 = v1;
//        this.v2 = v2;
//        //this.N=N;
//        this.color = color;
//
//    }
//
//    @Override
//    public Collision intersect(cRay Ray) {
//
//        //----- Plane's normal
//        cVector v0v1 = new cVector().subtract(v1, v0);
//
//        cVector v0v2 = new cVector().subtract(v2, v0);
//
//        cVector N = new cVector().getVectorProduct(v0v1, v0v2);//<-----Normal
//
//        float NdotRayDirection = N.dot(Ray.getDirection());//<---- if 
//        if (Math.abs(NdotRayDirection) < kEpsilon) {//<---- if ray and plane are parallel
//
//            return null;
//        }
//        float d = N.dot(v0);
//        float t = (N.dot(Ray.getOrigin()) + d) / NdotRayDirection;
//        if (t < 0) {//<----if triangle is behind ray
//
//            return null;
//        }
//        cVector C;
//        cVector P = Ray.getOrigin().add(Ray.getDirection().multiuplayby(t));
//        //Edge0
//        cVector edge0 = new cVector().subtract(v1, v0);
//        cVector vp0 = new cVector().subtract(P, v0);
//        C = new cVector().getVectorProduct(edge0, vp0);
//        if (N.dot(C) < 0) {//<--- if P is on right side
//
//            return null;
//        }
//        //Edge1
//        cVector edge1 = new cVector().subtract(v2, v1);
//        cVector vp1 = new cVector().subtract(P, v1);
//        C = new cVector().getVectorProduct(edge1, vp1);
//        if (N.dot(C) < 0) {//<--- if P is on right side
//
//            return null;
//        }
//
//        //Edge2
//        cVector edge2 = new cVector().subtract(v0, v2);
//        cVector vp2 = new cVector().subtract(P, v2);
//        C = new cVector().getVectorProduct(edge2, vp2);
//        if (N.dot(C) < 0) {//<--- if P is on right side
//            return null;
//        }
//        return new Collision(Ray.getOrigin(), v0, this);
//
//    }
}
