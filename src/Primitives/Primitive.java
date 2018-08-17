package Primitives;

import Material.Material;

import java.awt.*;

public abstract class Primitive {
    private Material material;
    public cVector normal;



    public Primitive(Material material, cVector normal) {
        this.material = material;
        this.normal=normal;



    }

    public abstract Collision intersect(cRay Ray);

    public Material getColor() {
        return material;
    }

    public void setColor(Material material) {
        this.material = material;

    }

}
