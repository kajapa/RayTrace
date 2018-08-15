/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

/**
 *
 * @author Patryk
 */
public class cRay extends cVector {

    private cVector origin, direction, destination;
    private float length;

    //-------------------------------------------------------------------------------//
    // KONSTRUKTOR 
    public cRay(cVector origin, cVector destination, boolean value) {
        this.origin = origin;
        this.destination = destination;
        this.direction = countDirection();
        this.length = countLength();
    }

    public cRay(cVector origin, cVector destination) {
        this.origin = origin;
        this.destination = destination;
        this.direction = new cVector().sub(this.origin, this.destination).normalized();
    }

    // GET
    public cVector getOrigin() {
        return this.origin;
    }

    public cVector getDirection() {
        return this.direction;
    }

    public cVector getDestination() {
        return this.destination;
    }

    public float getLength() {
        return this.length;
    }

    // SET
    public void setOrigin(cVector point) {
        this.origin = point;
    }

    public void setDirection(cVector vector) {
        this.direction = vector;
    }

    public void setDestination(cVector point) {
        this.destination = point;
    }

    public void setLength(float value) {
        this.length = value;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Ray [origin=" + origin + ", direction=" + direction
                + ", destination=" + destination + ", length=" + length + "]";
    }

    //-------------------------------------------------------------------------------//
    // KIERUNEK PROMIENIA (WEKTOR)
    public cVector countDirection() {
        return new cVector().sub(origin, destination);
    }

    // DLUGOSC PROMIENIA
    public float countLength() {
        return this.direction.getLength();
    }

    public cVector getIntersectPoint(double dist) {
        cVector v = new cVector();
        v = this.direction.multiuplayby((float) dist);

        return this.origin.add(v);
    }

}
