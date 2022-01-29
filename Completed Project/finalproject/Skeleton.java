/*
 * Alex, Lado, Nathan
 * January 26, 2022
 * Skeleton class to create skeleton objects
 */
package finalproject;

import java.net.URL;
import javax.swing.ImageIcon;

public class Skeleton extends Enemy{
    
    private static URL url = Entity.class.getResource("skeleton.png"); //Skeleton image
    private static ImageIcon ii = new ImageIcon(url);
    private int frameDelay, frameCounter;
    private double aimAngle;
    
    /** Constructor
     * Creates a skeleton based on an x and y coordinate, and a shot delay
     * @param x x position of the skeleton
     * @param y y position of the skeleton
     * @param frameDelay the amount of frames between each shot
     */
    public Skeleton(double x, double y, int frameDelay){  
         super(x,y,ii.getIconWidth(),ii.getIconHeight()); //Calls the matching constructor in the superclass
         imgPlayer = ii.getImage(); //Sets the image
         this.frameDelay = frameDelay; //Sets the frame delay
         frameCounter = frameDelay;
         enemyType = 2; //2 is the enemy type for skeletons
    }
    
    /** Attack method
     * This makes the skeleton attack
     */
    public void attack(){
        double shotAngle; //This is the angle that the shots will follow
        if (frameCounter <= 0){ //If the frame counter is 0 then the skeleton is ready to shoot
            for(int i = 0; i<3; i++){ //The skeleton shoots 3 shots like a shotgun in the direction of the player
                shotAngle = aimAngle + (((Math.random()*2-1)* 10)*Math.PI)/180; //The shot angle is based on the angle but changed by a random amount
                projectiles.add(new Projectile(x,y, Math.cos(shotAngle)*4, Math.sin(shotAngle)*4));
            }
            frameCounter = frameDelay; //Resets the frame counter
        } else {
            frameCounter --; //Substracts from the frame counter
        }
    }
    
    /** Chase method
     * this makes the skeleton chase the player
     * @param p the player that is being chased
     * @param l the level that the player and skeleton are in
     */
    public void chase(Player p, Level l){
        aimAngle = Math.atan2( p.getY() - y,  p.getX() - x); //The aim angle is adjusted based on where the player is
        x = x + (Math.cos(aimAngle) * 1.5); //Increases the x position of the skeleton
        hitX = hitX + (Math.cos(aimAngle) * 1.5);
        if (l.checkWall(this) == true){ //If the change in x position caused the skeleton to hit a wall then the change is reversed 
            x = x - (Math.cos(aimAngle) * 1.5);
            hitX = hitX - (Math.cos(aimAngle) * 1.5);
        }
        y = y + (Math.sin(aimAngle) * 1.5); //Increases the y position of the skeleton
        hitY = hitY + (Math.sin(aimAngle) * 1.5);
        if (l.checkWall(this) == true){ //If the change in y causes the skeleton to hit a wall then the change is reversed
            y = y - (Math.sin(aimAngle) * 1.5);
            hitY = hitY - (Math.sin(aimAngle) * 1.5);
        }
    }
    
    /** Clone method
     * clones this skeleton
     * @return a new skeleton with the same attributes as this one
     */
    public Skeleton clone(){
        Skeleton clone = new Skeleton(x,y,frameDelay); //Creates a new skeleton
        return clone;
    }
    
    /** Equals method
     * checks if this skeleton is equal to another skeleton
     * @param otherSkeleton the skeleton that this skeleton is being compared with
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Skeleton otherSkeleton){
        return (super.equals(otherSkeleton) && frameDelay == otherSkeleton.frameDelay);
    }
    
    /** toString method
     * Creates a detailed message based on the current state of this skeleton
     * @return a String containing the current values of the skeletons instance variables
     */
    public String toString(){
        return "\nSkeleton: " + super.toString() + "\nFrame Delay: " + frameDelay;
    }
}
