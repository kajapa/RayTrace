/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Model3DParser.Face;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patryk
 */
public class ObjectLists {
    public List<Object> listobjects = new ArrayList<Object>();
    public void addToList(Object obj){
    listobjects.add(obj);
    }
    public void Transfer(List<Object> list){
    
        for (Object object : list){
    listobjects.add(object);
    }
   
    }
}
