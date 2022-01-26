/*
 * Nathan Smith
 * January 25, 2022
 * Turret class to create turret objects
 */
package finalproject;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Turret extends Enemy{
    
    private static URL url = Entity.class.getResource("turretImage.png");
    private static ImageIcon ii = new ImageIcon(url);
    private double initialAngle, incrementAngle;
    private int frameDelay, frameCounter, projectileCount;
    public Turret(double x, double y, int w, int h, double initialAngle, double incrementAngle, int projectileCount, int frameDelay){
        super(x,y,w,h);
        this.initialAngle = (initialAngle *Math.PI)/180;
        this.incrementAngle = (incrementAngle * Math.PI)/180;
        imgPlayer = ii.getImage();
        this.projectileCount = projectileCount;
        this.frameDelay = frameDelay;
        frameCounter = frameDelay;
    }
    
    public double getInitialAngle(){
        return initialAngle;
    }
    
    public void setInitialAngle(double initialAngle){
        this.initialAngle = initialAngle;
    }
    
    public double getIncrementAngle(){
        return incrementAngle;
    }
    
    public void setIncrementAngle(double incrementAngle){
        this.incrementAngle = incrementAngle;
    }
    
    
   
    
    
    
    public void attack(){
        if (frameCounter <= 0){
            for(int i = 0; i<projectileCount; i++){
                projectiles.add(new Projectile(x+22,y+9,Math.cos(initialAngle + (incrementAngle*i))*2, Math.sin(initialAngle + (incrementAngle * i))*2));
            }
            frameCounter = frameDelay;
        } else {
            frameCounter--;
        }
    }
    
    public Turret clone(){
        Turret clone = new Turret(x,y,w,h,initialAngle, incrementAngle, projectileCount, frameDelay);
        return clone;
    }
    
    public boolean equals(Turret otherTurret){
        return(super.equals(otherTurret) && initialAngle == otherTurret.initialAngle && incrementAngle == otherTurret.incrementAngle && 
                projectileCount == otherTurret.projectileCount && frameDelay == otherTurret.frameDelay);
    }
    
    public String toString(){
        return "\nTurret: " + super.toString() + "\nInitial Angle: " + initialAngle + "\nIncrement Angle: " + incrementAngle +
                "\nProjectile Count: " + projectileCount + "\nFrame Delay: " + frameDelay;
    }
}