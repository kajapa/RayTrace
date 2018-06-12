/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.util.Arrays;

/**
 *
 * @author Patryk
 */
public class cVector {

    public float x, y, z;

    public cVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public cVector(cVector p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }

    public cVector(cVector v1, cVector v2) {
        this.x = v2.x - v1.x;
        this.y = v2.y - v1.y;
        this.z = v2.z - v1.z;
    }

    public cVector() {
    }

    ///GET
    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    //SET
    public void setX(float value) {
        this.x = value;
    }

    public void setY(float value) {
        this.y = value;
    }

    public void setZ(float value) {
        this.z = value;
    }

    public void parallel_y() {
        this.x = 0;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }

    public cVector add(cVector vector) {
        cVector v = new cVector();
        v.x = this.x + vector.getX();
        v.y += this.y + vector.getY();
        v.z += this.z + vector.getZ();
        return v;
    }

    public cVector add(cVector vectorA, cVector vectorB) {

        return new cVector(vectorA.getX() + vectorB.getX(), vectorA.getY() + vectorB.getY(), vectorA.getZ() + vectorB.getZ());
    }

    // ODEJMOWANIE WEKTOROW
    public cVector subtract(cVector vectorA, cVector vectorB) {

        return new cVector(vectorA.getX() - vectorB.getX(), vectorA.getY() - vectorB.getY(), vectorA.getZ() - vectorB.getZ());
    }

    // MNOZENIE WEKTOROW
    public cVector multiuplayby(float il) {
        return new cVector(this.x * il, this.y * il, this.z * il);
    }

    // DZIELENIE WEKTOROW
    public void divide(cVector vector) {
        if (vector.getX() != 0 && vector.getY() != 0 && vector.getZ() != 0) {
            this.x /= vector.getX();
            this.y /= vector.getY();
            this.z /= vector.getZ();
        }
    }

    public void divide(cVector vectorA, cVector vectorB) {
        if (vectorB.getX() != 0 && vectorB.getY() != 0 && vectorB.getZ() != 0) {
            this.x = vectorA.getX() / vectorB.getX();
            this.y = vectorA.getY() / vectorB.getY();
            this.z = vectorA.getZ() / vectorB.getZ();
        }
    }

    // ILOCZYN SKALARNY
    // ILOCZYN WEKTOROWY
    public cVector getVectorProduct(cVector vectorA, cVector vectorB) {

        return new cVector(vectorA.getY() * vectorB.getZ() - vectorA.getZ() * vectorB.getY(), vectorA.getZ() * vectorB.getX() - vectorA.getX() * vectorB.getZ(), vectorA.getX() * vectorB.getY() - vectorA.getY() * vectorB.getX());
    }

    public void div(float f) {
        if (f != 0) {
            x /= f;
            y /= f;
            z /= f;
        }
        else {
            System.err.println("Can't divide by 0!");
        }
    }

    // NORMALIZACJA
    public cVector normalize() {
        cVector newV = new cVector(x, y, z);
        float n = newV.length();
        if (n != 0) {
            newV.div(n);
            return newV;
        }
        else {
            System.out.println("Warning! Could not normalize vector.");
            return newV;
        }

    }
    // DLUGOSC DO KWADRATU

    public float getLengthSquared() {
        return (float) (Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }
    // DLUGOSC

    public float getLength() {
        return (float) Math.sqrt(getLengthSquared());
    }

    // CZY ROWNY
    public boolean isEqual(cVector vector) {
        return ((this.x == vector.getX()) && (this.y == vector.getY()) && (this.z == vector.getZ()));
    }

    public boolean isNotEqual(cVector vector) {
        return !(isEqual(vector));
    }

    // KAT MIEDZY DWOMA WEKTORAMI
    public float getCosinusAngle(cVector vectorB) {
        cVector vectorA = new cVector(this.x, this.y, this.z);
        vectorA.normalize();
        vectorB.normalize();
        return vectorA.dot(vectorB);
    }

    public float getAngle(cVector vector) {
        return (float) Math.acos((double) getCosinusAngle(vector));
    }

    public cVector normalized() {
        return this.normalize();
    }

    public static float distance(cVector start, cVector end) {
        return (float) Math.sqrt(Math.pow((end.x - start.x), 2) + Math.pow((end.y - start.y), 2) + Math.pow((end.z - start.z), 2));
    }

    public float dot(cVector v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    public static cVector sub(cVector v1, cVector v2) {
        return new cVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public float length() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public static cVector cross(cVector v1, cVector v2) {
        return new cVector(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }

    public static cVector addVectors(cVector v1, cVector v2) {
        return new cVector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static cVector multiply(cVector p, float n) {
        return new cVector(p.x * n, p.y * n, p.z * n);
    }

    public cVector rotateAxis(int angle, char axis) {
        double[][] z = {{Cosinus(angle), -Sinus(angle), 0, 0}, {Sinus(angle), Cosinus(angle), 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        double[][] x = {{1, 0, 0, 0}, {0, Cosinus(angle), -Sinus(angle), 0}, {0, Sinus(angle), Cosinus(angle), 0}, {0, 0, 0, 1}};
        double[][] y = {{Cosinus(angle), 0, Sinus(angle), 0}, {0, 1, 0, 0}, {-Sinus(angle), 0, Cosinus(angle), 0}, {0, 0, 0, 1}};
        double[] vector = {this.x, this.y, this.z, 0};
        double[] result = new double[4];
        double sum = 0;
        Arrays.fill(result, 0);
        switch (axis) {

            case 'x': {

                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * x[j][k];
                    }
                }

            }
            case 'y': {
                // Arrays.fill(result, 0);
                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * y[j][k];
                    }
                }

            }

            case 'z': {
                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * x[j][k];
                    }
                }

            }
        }

        return new cVector((float) result[0], (float) result[1], (float) result[2]);
    }

    public double Cosinus(int angle) {
        double num = 0;
        switch (angle) {
            case 0: {
                num = 1;
            }
            case 30: {
                num = Math.sqrt(3) / 2;

            }
            case 45: {
                num = Math.sqrt(2) / 2;
            }
            case 60: {
                num = 0.5;

            }
            case 90: {
                num = 0;
            }

        }
        return num;

    }

    public double Sinus(int angle) {
        double num = 0;
        switch (angle) {
            case 0: {
                num = 0;
            }
            case 30: {
                num = 0.5;

            }
            case 45: {
                num = Math.sqrt(2) / 2;
            }
            case 60: {
                num = Math.sqrt(3) / 2;

            }
            case 90: {
                num = 1;
            }

        }
        return num;

    }

    public cVector scaleVector(cVector v) {
        double[][] x = {{v.x, 0, 0, 0}, {0, v.y, 0, 0}, {0, 0, v.z, 0}, {0, 0, 0, 1}};
        double[] result = new double[4];
        double[] vector = {this.x, this.y, this.z, 0};
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                result[k] += vector[j] * x[j][k];
            }
        }
        return new cVector((float) result[0], (float) result[1], (float) result[2]);
    }
}
