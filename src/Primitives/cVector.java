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
    public cVector subtract( cVector vectorB) {

        return new cVector(this.getX() - vectorB.getX(), this.getY() - vectorB.getY(), this.getZ() - vectorB.getZ());
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
    public cVector getVectorProduct(cVector vectorB) {

        return new cVector(y * vectorB.getZ() - z * vectorB.getY(), z * vectorB.getX() - x * vectorB.getZ(), x * vectorB.getY() - y * vectorB.getX());
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

    public cVector rotateAxis(int angleX, int angleY, int angleZ) {
        double[][] z = {{Cosinus(angleZ), -Sinus(angleZ), 0, 0}, {Sinus(angleZ), Cosinus(angleZ), 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        double[][] x = {{1, 0, 0, 0}, {0, Cosinus(angleX), -Sinus(angleX), 0}, {0, Sinus(angleX), Cosinus(angleX), 0}, {0, 0, 0, 1}};
        double[][] y = {{Cosinus(angleY), 0, Sinus(angleY), 0}, {0, 1, 0, 0}, {-Sinus(angleY), 0, Cosinus(angleY), 0}, {0, 0, 0, 1}};
        double[] vector = {this.x, this.y, this.z, 1};
        double[] result = new double[4];
        
        double[][] XYRotMatrix = multiplyMatrix(x, y);
        double[][] XYZRotMatrix = multiplyMatrix(XYRotMatrix, z);
        result = multiplyMatrix(XYZRotMatrix, vector);
        
        //double sum = 0;
        //cVector ret= new cVector();
        //Arrays.fill(result, 0);
        /*switch (axis) {

            case 'x': {

                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * x[k][j];
                    }
                }
                
                break;
            }
            case 'y': {
                // Arrays.fill(result, 0);
                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * y[k][j];
                    }
                }
                    break;
            }

            case 'z': {
                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        result[k] += vector[j] * x[k][j];
                    }
                }
                    break;
            }
        }*/

        // multiply(x, y) >> temp
        // multiply(temp, z) >> rotMatrix
        // rotAxis(rotMatrix, v)
        
        return new cVector((float) result[0], (float) result[1], (float) result[2]);
    }
public cVector returnrX(){
    double Sin = Sinus(45);
    double Cos = Cosinus(45);
    
float x=this.x;
double y=Cosinus(45)*this.y-Sinus(45)*this.z;
double z = Sinus(45)*this.y+Cosinus(45)*this.z;
return new cVector(x,(float)y,(float)z);}
    public double Cosinus(int angle) {
        double num = 0;
        int sign = minusPlus(angle);
        int s= Math.abs(angle);
        switch (s) {
            case 0: {
                num = 1;
                break;
            }
            case 30: {
                num = (Math.sqrt(3) / 2)*sign;
                break;

            }
            case 45: {
                num = (Math.sqrt(2) / 2)*sign;
                break;
            }
            case 60: {
                num = 0.5*sign;
                break;

            }
            case 90: {
                num = 0;
                break;
            }

        }
        return num;

    }

    public double Sinus(int angle) {
        double num = 0;
        int sign = minusPlus(angle);
        int s= Math.abs(angle);
        switch (s) {
            case 0: {
                num = 0;
                break;
            }
            case 30: {
                num = 0.5*sign;
                break;
            }
            case 45: {
                num = (Math.sqrt(2) / 2)*sign;
                break;
            }
            case 60: {
                num = (Math.sqrt(3) / 2)*sign;
                break;
            }
            case 90: {
                num = 1*sign;
                break;
            }

        }
        return num;

    }

    public int minusPlus(int a){
    if(a<0)
    return -1;
    
    else
        return 1;
    
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
    
    // return c = a * b
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] c = new double[m1][n2];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2; j++)
                for (int k = 0; k < n1; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    // matrix-vector multiplication (y = A * x)
    public static double[] multiplyMatrix(double[][] a, double[] x) {
        int m = a.length;
        int n = a[0].length;
        if (x.length != n) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += a[i][j] * x[j];
        return y;
    }
}