package Objects;

import Primitives.Collision;
import Primitives.Triangle;
import Primitives.cRay;
import Primitives.cVector;

import java.util.ArrayList;
import java.util.List;

public class Mesh extends Object {
   public List<Triangle> triangles= new ArrayList<>();



    @Override
    public Collision intersect(cRay Ray) {
       for(Triangle t: triangles )
       {
      Collision col=  t.intersect(Ray);
      if(col!=null)
           return col;
       }
        return null;
    }
}
