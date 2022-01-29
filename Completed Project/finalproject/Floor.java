/*
 * Alex, Lado, Nathan
 * January 21, 2022
 * Floor class to create floor tiles
 */
package finalproject;

import static finalproject.Tile.TILESIZE;
import java.net.URL;
import javax.swing.ImageIcon;


public class Floor extends Entity implements Tile{
    private static URL url = Entity.class.getResource("floor.png");
    private static ImageIcon ii = new ImageIcon(url);
    private static final int TILETYPE = 0; //The tile type for floors is 0
    
    
    /** Constructor
     * Creates a floor based on an x and y position
     * @param x
     * @param y 
     */
    public Floor(double x, double y){ 
        super(x,y,TILESIZE,TILESIZE,x,y,TILESIZE,TILESIZE);//Calls the matching constructor in the superclass
        imgPlayer = ii.getImage(); 
    }
    
    /** Get tileType method
     * @return the tileType
     */
    public int getTileType(){
        return TILETYPE;
    }
    
    /** Clone method
     * creates a clone of this floor
     * @return a new floor with all the same attributes
     */
    public Floor clone(){
        Floor clone = new Floor(x, y);
        return clone;
    }
    
    /** Equals method
     * checks if this floor is equal to another floor
     * @param otherFloor the otherFloor
     * @return true if they are equal, false if not
     */
    public boolean equals(Floor otherFloor){
        return (x == otherFloor.x && y == otherFloor.y);
    }
    
    /** toString method
     * Creates a formatted message based on the current state of the floor
     * @return a String containing the values of this floor instance variables
     */
    public String toString(){
        return "Floor:" + super.toString() + "Tile type: " + TILETYPE;
    }
            
}

