/*
 * Alex, Lado, Nathan
 * January 25, 2022
 * Turret class to create turret objects
 */
package finalproject;

import java.net.URL;
import javax.swing.ImageIcon;

public class Turret extends Enemy{
    
    private static URL url = Entity.class.getResource("turretImage.png"); //turret image
    private static ImageIcon ii = new ImageIcon(url);
    private double initialAngle, incrementAngle;
    private int frameDelay, frameCounter, projectileCount;
    
    /** Constructor
     * creates a turret based on an x and y coordinate, shot angle, increment angle, projectile counter, and frame delay
     * @param x the x position of the turret
     * @param y the y position of the turret
     * @param initialAngle the angle of the first projectile
     * @param incrementAngle the difference between shot angles 
     * @param projectileCount the number of shots in each wave of shots
     * @param frameDelay the delay between each shot
     */
    public Turret(double x, double y, double initialAngle, double incrementAngle, int projectileCount, int frameDelay){
        super(x,y,ii.getIconWidth(),ii.getIconHeight()); //Calls the matching constructor in the superclass
        imgPlayer = ii.getImage(); //Sets the varaibles
        this.initialAngle = (initialAngle *Math.PI)/180; //Converts from degrees to radians
        this.incrementAngle = (incrementAngle * Math.PI)/180;
        this.projectileCount = projectileCount;
        this.frameDelay = frameDelay;
        frameCounter = frameDelay;
        enemyType = 0;//0 is the enemy type for turrets
    }
    
    /** Get initial angle method
     * returns the initial angle
     * @return the intial angle variable
     */
    public double getInitialAngle(){
        return initialAngle;
    }
    
    /** Set initial angle method
     * changes the initial angle
     * @param initialAngle new initial angle
     */
    public void setInitialAngle(double initialAngle){
        this.initialAngle = initialAngle;
    }
    
    /** Get Increment angle method
     * gets the increment angle
     * @return the increment angle variable
     */
    public double getIncrementAngle(){
        return incrementAngle;
    }
    
    /** Set increment angle method
     * changes the increment angle to a new angle
     * @param incrementAngle the new increment angle
     */
    public void setIncrementAngle(double incrementAngle){
        this.incrementAngle = incrementAngle;
    }
    
    /** Attack method
     * This makes the turret attack
     */
    public void attack(){
        if (frameCounter <= 0){ //If the frame counter is 0 then the turret is ready to attack
            for(int i = 0; i<projectileCount; i++){ //Loops through and creates x amount of projectiles that are spaced out according to the increment angle variables
                projectiles.add(new Projectile(x+22,y+9,Math.cos(initialAngle + (incrementAngle*i))*2, Math.sin(initialAngle + (incrementAngle * i))*2));
            }
            frameCounter = frameDelay; //Resets the frame counter
        } else {
            frameCounter--; //Subtracts from the frame counter
        }
    }
    
    /** Clone method
     * Clones this turret
     * @return a new turret with identical attributes to this one
     */
    public Turret clone(){
        Turret clone = new Turret(x,y,initialAngle, incrementAngle, projectileCount, frameDelay); //A new turret
        return clone;
    }
    
    /** equals method
     * checks if two turret are equal
     * @param otherTurret the turret that this turret is being compared to
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Turret otherTurret){
        return(super.equals(otherTurret) && initialAngle == otherTurret.initialAngle && incrementAngle == otherTurret.incrementAngle && 
                projectileCount == otherTurret.projectileCount && frameDelay == otherTurret.frameDelay);
    }
    
    /** toString method
     * creates a detailed message about the current state of the turret
     * @return a String containing the current values of the turrets attributes
     */
    public String toString(){
        return "\nTurret: " + super.toString() + "\nInitial Angle: " + initialAngle + "\nIncrement Angle: " + incrementAngle +
                "\nProjectile Count: " + projectileCount + "\nFrame Delay: " + frameDelay;
    }
}