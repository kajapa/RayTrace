package Light;
import Primitives.Collision;
import Primitives.cVector;

public class PointLight extends Light {
    float constAtten;
    float linearAtten;
    float quadAtten;

    public PointLight(cVector position, cVector intesity, float constAtten, float linearAtten, float quadAtten) {
        super(position, intesity);
        this.constAtten = constAtten;
        this.linearAtten = linearAtten;
        this.quadAtten = quadAtten;
    }



    //int read(FILE* fp);
   // void write(FILE* fp=stdout);
    //cVector getDiffuse(cVector cameraPosition,Collision iInfo);
    //cVector getSpecular(Point3D cameraPosition,Collision iInfo);
    // int isInShadow(Collision iInfo,Shape* shape);

}
