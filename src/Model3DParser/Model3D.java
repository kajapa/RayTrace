/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model3DParser;

import Material.Material;
import Primitives.cVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Patryk
 */
public class Model3D  {
    public List<cVector> verticies = new ArrayList<cVector>();
    public List<cVector> normals = new ArrayList<cVector>();
    public List<Face> faces = new ArrayList<Face>();
    public HashMap<String,Material> materialmap= new HashMap<String,Material>();

   public Model3D() {
        
    }
    
    
    
}
