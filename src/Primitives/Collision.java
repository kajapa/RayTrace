/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PLJAFIL
 */
public class Collision {

    public cVector origin;
    public cVector collisionPoint;
    public float length;
    public Primitive primitive;

    public Collision(cVector origin, cVector collisionPoint, Primitive primitive) {
        this.origin = origin;
        this.collisionPoint = collisionPoint;
        this.primitive = primitive;
        this.length = Math.abs(new cVector(origin, collisionPoint).length());
    }

    private static Comparator<Collision> compLength = new Comparator<Collision>() {
        @Override
        public int compare(Collision o1, Collision o2) {
            float l1 = o1.length;
            float l2 = o2.length;

            if (l1 <= 1f) {
                l1 = -Float.MAX_VALUE;
            }
            if (l2 <= 1f) {
                l2 = -Float.MAX_VALUE;
            }
            return Float.compare(l1, l2);
        }
    };

    public static Collision nearest(List<Collision> collisionList) {
        if (collisionList == null) {
            return null;
        }
        Optional<Collision> result = collisionList.stream().min(compLength);
        try {
            return result.get();
        }
        catch (Exception ex) {
            return null;
        }
    }

}
