package Material;

import Primitives.cVector;

public class Material {

    private cVector kAmbient ;
 private cVector kDiffuse ;
 private cVector kSpecular ;
 private float alpha;
 //private Texture texture;
 //private boolean hasTexture;
 public Material(){}


 public Material(cVector kAmbient, cVector kDiffuse, cVector kSpecular, float alpha) {

  this.kAmbient = kAmbient;
  this.kDiffuse = kDiffuse;
  this.kSpecular = kSpecular;
  this.alpha = alpha;
 }



 public cVector getkAmbient() {
  return kAmbient;
 }

 public void setkAmbient(cVector kAmbient) {
  this.kAmbient = kAmbient;
 }

 public cVector getkDiffuse() {
  return kDiffuse;
 }

 public void setkDiffuse(cVector kDiffuse) {
  this.kDiffuse = kDiffuse;
 }

 public cVector getkSpecular() {
  return kSpecular;
 }

 public void setkSpecular(cVector kSpecular) {
  this.kSpecular = kSpecular;
 }

 public float getAlpha() {
  return alpha;
 }

 public void setAlpha(float alpha) {
  this.alpha = alpha;
 }
}
