/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Primitives.*;


import java.awt.Color;

/**
 *
 * @author Patryk
 */
public abstract class Object
{
    cVector position;


    public abstract Collision intersect(cRay Ray);





    

}
