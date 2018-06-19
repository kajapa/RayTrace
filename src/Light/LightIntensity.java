/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

/**
 *
 * @author Patryk
 */
public class LightIntensity {
    private float r,g,b;

    public float getR() {
        if(r>1)
        return 1;
        else return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        if(g>1)
        return 1;
        else return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        if(b>1)
        return 1;
        else return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public LightIntensity(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public float LightIntensity(float r, float g, float b) {
    
    return r+g+b;
    }
    public LightIntensity add(float r, float g, float b){
    return new LightIntensity(this.r+r, this.g+g, this.b+b);
    }
    public LightIntensity divadeby(float v){
    if(v!=0.0f){
    return new LightIntensity(r/=v, g/=v, b/=v);
    
    }
    else
        return new LightIntensity(0f, 0f, 0f);
    }
    
    
    
}
