/*
 * Alex, Lado, Nathan
 * January 26, 2022
 * Dragon class to create dragon objects
 */
package finalproject;

import java.net.URL;
import javax.swing.ImageIcon;

public class Dragon extends Enemy{
    private static URL url = Entity.class.getResource("dragon.png"); //Gets the dragon image
    private static ImageIcon ii = new ImageIcon(url);
    private int phase; //Keeps track of which phase the dragon is in
    private double initialAngle1, initialAngle2; //To angles to control where the dragon aims its attacks
    private int frameDelay, frameCounter, shotGap; //Keeps track of the time and space between attacks
    private double chargeDirection; //Keeps track of the dragons charge direction
    
    /** Constructor
     * Creates a dragon with an x and y coordinate, frame delay and phase
     * @param x the x position of the dragon
     * @param y the y position of the dragon
     * @param frameDelay the delay between shots
     * @param phase the phase of attacks that the dragon will do
     */
    public Dragon(double x, double y, int frameDelay, int phase){
        super(x,y,ii.getIconWidth(),ii.getIconHeight()); //Calls the matching constructor in the super class
        imgPlayer = ii.getImage(); //Sets the image
        enemyType = 3; //Dragon has an enemy type of 3
        this.phase = phase;
        this.frameDelay = frameDelay;
    }
    
    /** Attack method
     * This method makes the dragon attack
     */
    public void attack(){
        if (phase == 0){ //If the phase is 0 then code runs 
            if (frameCounter <=0){//If the frame counter has reached 0 then the dragon is ready to attack
                if (shotGap >= 4){//If the shotGap has reached 4 then it is reset
                    shotGap =0;
                } else {
                    shotGap++; //Shot gap increases 
                }
                for (int i = 0; i<4 ; i++){ //Loops through 4 times to create 4 projectiles
                    if (shotGap != i){ //One of the 4 projectiles won't be created to create a gap in the shots
                        projectiles.add(new Projectile(x + w/2,y + h/2,Math.cos(initialAngle1 + (Math.PI/2 * i)), Math.sin(initialAngle1 + (Math.PI/2 * i))));
                    }
                }
                 for (int i = 0; i<4; i++){ //This creates the same 4 shots except they use a different angle to get velocities
                     //This goal of this is to create 2 different groups of shot lines that are rotating in different ways
                    if (3 - shotGap != i){
                        projectiles.add(new Projectile(x + w/2,y + h/2,Math.cos(initialAngle2 + (Math.PI/2 * i)), Math.sin(initialAngle2 + (Math.PI/2 * i))));
                    }
                }
                initialAngle1+=Math.PI/18; //The first angle increases by 10 degrees wile the second angle decreases by 10 degrees
                initialAngle2-=Math.PI/18;
                frameCounter = frameDelay; //Resets the frame counter
            } else {
                frameCounter--; //Decreases the frame counter 
            }
        } else {//This code runs if the dragon is in phase 1
            if (frameCounter <= 0){ //If the dragon is ready to shoot this code runs
                //The dragon creates 2 shots each traveling in opposite directions that are perpendicular to the dragons direction
                projectiles.add(new Projectile(x + w/2,y + h/2, Math.cos(chargeDirection + Math.PI/2) * 2, Math.sin(chargeDirection + Math.PI/2) * 2));
                projectiles.add(new Projectile(x + w/2,y + h/2, Math.cos(chargeDirection - Math.PI/2) * 2, Math.sin(chargeDirection - Math.PI/2) * 2));
                frameCounter = frameDelay/2; //Resets the frame counter to half the frame delay since the dragon should shoot faster in this phase
            } else {
                frameCounter--; //Decreases the frame counter
            } 
        }
    }
    
    /** Chase method
     * This method makes the dragon chase down the player
     * @param p the player that is being chased
     * @param l the level that the dragon and player are in
     */
    public void chase(Player p, Level l){
        if (phase == 1){ //The dragon should only chase if it is in phase 1
            x = x + Math.cos(chargeDirection)*4; //Increases the x and y based on the charge direction
            y = y + Math.sin(chargeDirection)*4; 
            hitX = hitX + Math.cos(chargeDirection)*4; //Also increases the hit box coordinates
            hitY = hitY + Math.sin(chargeDirection)*4; 
            if (l.checkWall(this) == true){ //If the dragon hits a wall the this code runs
                x = x - Math.cos(chargeDirection)*4; //The dragons movement is reversed 
                y = y - Math.sin(chargeDirection)*4; 
                hitX = hitX - Math.cos(chargeDirection)*4;
                hitY = hitY - Math.sin(chargeDirection)*4; 
                chargeDirection = Math.atan2(p.getY() - y,  p.getX() - x); //A new charge direction is set based on the players current position
            }  
        }
    }
    
    /** Switch phase method
     * swaps between the dragons phases
     */
    public void switchPhase(){
        if (phase == 0){ //If the current phase is 0 then it is switched to 1 and vice-versa
            phase = 1;
        } else {
            phase = 0;
        }
    }
    
    /** Get Phase method
     * returns the current phase of the dragon
     * @return the phase variable
     */
    public int getPhase(){
        return phase;
    }
    
    /** toString method
     * Creates a detailed string of the current state of the dragon
     * @return a String containing the detailed message
     */
    public String toString(){
        return "Dragon: " + super.toString() + "Frame Delay: " + "Phase: " + phase; //Creates the message
    }
    
    /** Clone method
     * creates a clone of this dragon
     * @return a new dragon with all the same attributes
     */
    public Dragon clone(){
        Dragon clone = new Dragon(x,y,frameDelay,phase);
        return clone;
    }
    
    /** Equals method
     * checks if 2 dragons are equal
     * @param otherDragon the other dragon that this dragon will be compared to
     * @return true if they are equal, false if they are unequal
     */
    public boolean equals(Dragon otherDragon){
        return (super.equals(otherDragon) && frameDelay == otherDragon.frameDelay && phase == otherDragon.phase);
    }  
}