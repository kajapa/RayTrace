package Light;
import Primitives.*;


public class SpotLight {
    cVector location;
    cVector direction;
    float constAtten;
    float linearAtten;
    float quadAtten;
    float cutOffAngle;
    float dropOffRate;
    //int read(FILE* fp);
    //void write(FILE* fp=stdout);
   // cVector getDiffuse(cVector cameraPosition,Collision iInfo);
    //int isInShadow(IntersectionInfo iInfo,Shape* shape);
}
