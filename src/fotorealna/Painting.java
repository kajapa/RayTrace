/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotorealna;

import Primitives.Sphere;
import Primitives.Quad;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Patryk
 */
public class Painting extends JPanel {
List<Sphere> listobjects= new ArrayList<Sphere>();
List<Quad> planelist= new ArrayList<Quad>();
    public Painting(){
    super.setDoubleBuffered(true);



    }
    public void addSphere(Sphere sphere){
    listobjects.add(sphere);
    
    }
    public void addPlane(Quad Plane){
    planelist.add(Plane);
    }
  /*  @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Collision kolizja= new Collision();
       // listobjects.add(new Sphere(new cVector(-1f,0,10),0.5f));
        //listobjects.add(new Sphere(new cVector(1f,0,10),0.5f));
        //listobjects.add(new Sphere(new cVector(0.0f,0,10),0.5f));
        //planelist.add(new Quad(new cVector(0.0f, 1f, 0.0f), new cVector(0f, 1f, 0f)));
        
        float widthPixel= 2.0f /1280;
        float heightPixel =2.0f/720;
        float aspect=(float)1280/(float)720;
        for (int i = 0; i <1280; i++) {
            for (int j = 0; j < 720; j++) {
                    float middleX=  (float) (-1+(i+0.5)*widthPixel)*aspect;
                    float middleY= (float) (1-(j+0.5)*heightPixel);
                    cRay ray = new cRay(new cVector(middleX,middleY,0),new cVector(0,0,1));
                    
                    
                for(Quad com : planelist){
		if(kolizja.intersect(ray,  com)==true){
			g2d.setColor(Color.red);
                       g2d.fillRect(i, j, 1,1);
		}
                for(Sphere item : listobjects){
		if(kolizja.intersect(ray,  item)==true){
			g2d.setColor(Color.yellow);
                       g2d.fillRect(i, j, 1,1);
		}
                
	} 
                    
                    
                   
                    //cVector intersection= this.Sphere.sphere_intersect(ray);
                   
                   
                      // g2d.setColor(Color.yellow);
                      // g2d.fillRect(i, j, 1,1);
                   
                   
                   /*else {
                   g2d.setColor(Color.black);
                    g2d.fillRect(i, j, 1,1);
                   
           }
            
        }}
    }}*/}
    
    

