/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;

import Primitives.cVector;

/**
 *
 * @author Patryk
 */
public class Camera {
    public cVector position;
    public cVector target;
    public cVector up;
    private float nearPlane,farPlane,fov;

    public Camera(cVector point, cVector target, cVector up, float nearPlane, float farPlane, float fov) {
        this.position = position;
        this.target = target;
        this.up = up;
        this.nearPlane = nearPlane;
        this.farPlane = farPlane;
        this.fov = fov;
    }
    public Camera(){
    this.position=new cVector(0, 0, 0);
    this.target=new cVector(0, 0, 1);
    this.nearPlane=1;
    this.farPlane=1000;
    this.up=new cVector(0, 1, 0);
    
    }
    public Camera(cVector position,cVector target){
    this.position = position;
        this.target = target;
        this.nearPlane=1;
    this.farPlane=1000;
    this.up=new cVector(0, 1, 0);
    
    }

    public cVector getPoint() {
        return position;
    }

    public void setPoint(cVector point) {
        this.position = point;
    }

    public cVector getTarget() {
        return target;
    }

    public void setTarget(cVector target) {
        this.target = target;
    }

    public cVector getUp() {
        return up;
    }

    public void setUp(cVector up) {
        this.up = up;
    }

    public float getNearPlane() {
        return nearPlane;
    }

    public void setNearPlane(float nearPlane) {
        this.nearPlane = nearPlane;
    }

    public float getFarPlane() {
        return farPlane;
    }

    public void setFarPlane(float farPlane) {
        this.farPlane = farPlane;
    }

    public float getFov() {
        return fov;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }
    
}
