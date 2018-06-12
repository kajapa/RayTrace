/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model3DParser;

import Primitives.Object;
import Primitives.cRay;
import Primitives.cVector;
import java.awt.Color;

/**
 *
 * @author Patryk
 */
public class Face  {
    public int v1,v2,v3,v4;
    public int n;

    public Face(int v1, int v2, int v3, int v4, int n) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.n = n;
       
    }
    

   

    
    
}
