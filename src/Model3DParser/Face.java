/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model3DParser;

/**
 *
 * @author Patryk
 */
public class Face  {


    public int v1,v2,v3;
    public int n;
    public String materialname;

    public Face(){}

    public Face(String materialname,int v1, int v2, int v3, int n) {
        this.materialname=materialname;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
     
        this.n = n;
       
    }
    public void setV1(int v1) {
        this.v1 = v1;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public void setV3(int v3) {
        this.v3 = v3;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }
    

   

    
    
}
