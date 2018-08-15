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
public class Triangle extends Primitive {

    public static final float kEpsilon = 0.000001f;

    public cVector p1;
    public cVector p2;
    public cVector p3;



    public Triangle(cVector p1, cVector p2, cVector p3,cVector N, Color color) {
        super(color,N);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;



    }

    @Override
    public Collision intersect(cRay ray) {
        float dist;

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
        //cVector.sub(result, new cVector((p1.x + p2.x + p3.x) / 3, (p1.y + p2.y + p3.y) / 3, (p1.z + p2.z + p3.z / 3))).normalized();
        dist = cVector.distance(result, ray.getOrigin());
        return new Collision(ray.getOrigin(), result, this);
    }}

