/*
 * Alex, Lado, Nathan
 * January 26, 2022
 * Slime class to create slime objects
 */
package finalproject;

import java.net.URL;
import javax.swing.ImageIcon;

public class Slime extends Enemy{
    private int phase; //Keeps track of the slimes phase
    private int frameDelay, frameCounter; //The amount of frames between attacks
    private int rotationRadius; //If the slime is a rotating slime then this is the radius it rotates around
    private double rotationAmount = 0; 
    private double initialAngle, rotationX, rotationY; //This is the point that the slime will rotate around
    private static URL url = Entity.class.getResource("slime.png");//Slime image
    private static ImageIcon ii = new ImageIcon(url);
    
    /** Constructor
     * creates a slime based on an x and y coordinate, rotation radius, frame delay, and phase
     * @param x the x position of the slime
     * @param y the y position of the slime
     * @param rotationRadius the radius of the circle that the slime follows while rotating
     * @param frameDelay the delay in between shots
     * @param phase  the phase that the slime is in
     */
    public Slime(double x, double y, int rotationRadius, int frameDelay, int phase){
        super(x,y,ii.getIconWidth(),ii.getIconHeight()); //Calls the matching constructor in the super class
        rotationX = x; //Sets the rotation x and y values
        rotationY = y;
        this.frameDelay = frameDelay; //Sets the frame delay 
        frameCounter = frameDelay;
        this.rotationRadius = rotationRadius; //Sets the rotation radius
        imgPlayer = ii.getImage(); //Sets the image
        enemyType = 1; //1 is the enemy type for slimes
        this.phase = phase; //Sets the phase
    }
    
    /** Attack method
     * This makes the slime attack
     */
    public void attack(){ 
        if (phase == 0){ //If the slime is in phase 0 then the make lines of shots that rotate
            if (frameCounter <= 0){ //If the frame counter is equal to 0 then the slime is ready to attack
                for(int i = 0; i<3; i++){//The slime creates 3 shots each 60 degrees apart
                    projectiles.add(new Projectile(x,y,Math.cos(initialAngle + (i*(2*Math.PI/3))), Math.sin(initialAngle + (i*(2*Math.PI/3)))));
                }
                initialAngle+=(10*Math.PI)/180; //The initial angle where the 3 shots start is increased by 10 degrees
                frameCounter = frameDelay; //The frame counter is reset
            } else {
                frameCounter--; //The frame counter gets subtracted from
            }
        } else { //In phase 1 the slime should rotate around in a circle and shoot 8 shots periodically
                setX(rotationX + (Math.cos(rotationAmount) * rotationRadius)); //Sets the x and y of the slime to follow the circle
                setY(rotationY + (Math.sin(rotationAmount) * rotationRadius));
                rotationAmount+=(2*Math.PI)/(rotationRadius*2); //The rotation amount increases based on how big the rotation radius is. Small circle means faster rotation

            if (frameCounter <= 0){ //If the frame counter is 0 then the slime is ready to shoot
                for (int i = 0; i<8; i++){ //This shoots 8 projectiles 45 degrees apart
                    projectiles.add(new Projectile(x,y,Math.cos(45* i * Math.PI /180), Math.sin(45* i * Math.PI /180)));
                }
                frameCounter = frameDelay; //Resets the frame counter
            } else {
                frameCounter--; //Subtracts from the frame counter
            }
            
        }
    }
    
    /** Get phase method
     * returns the phase that the slime is in
     * @return the phase variable
     */
    public int getPhase(){
        return phase;
    }
    
    /** Clone method
     * Creates a clone of this slime
     * @return a new slime that has all the same attributes as this slime
     */
    public Slime clone(){
        Slime clone = new Slime(x,y,rotationRadius,frameDelay, phase); //Creates the new slime with all the same attributes
        return clone;
    }
    
    /** Equals method
     * checks if this slime is equal to another slime
     * @param otherSlime the slime that this slime is being compared to
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Slime otherSlime){
        return (super.equals(otherSlime) && rotationRadius == otherSlime.rotationRadius && frameDelay == otherSlime.frameDelay && phase == otherSlime.phase);
    }
    
    /** toString method
     * Creates a detailed message about the current state of this slime
     * @return a string containing the values of this slime instance variables
     */
    public String toString(){
        return "\nSlime: " + super.toString() + "\nRotation Radius: " + rotationRadius + "\nFrame Delay: " + frameDelay;
    } 
}
