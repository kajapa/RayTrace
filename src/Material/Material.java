package Material;

public class Material {
    private double[] kAmbient = new double[3];
 private double[] kDiffuse = new double[3];
 private double[] kSpecular = new double[3];
 private double alpha;
 //private Texture texture;
 private boolean hasTexture;

 public Material(){

     for (int i = 0; i < 3; i++)
 {
 kAmbient[i] = 0.3f;
 kDiffuse[i] = 0.5f;
 kSpecular[i] = 0.8f;
 }
this.alpha = 100;
 this.hasTexture = false;

 }
}
