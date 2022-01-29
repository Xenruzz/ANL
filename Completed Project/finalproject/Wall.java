/*
 * Alex, Lado, Nathan
 * January 21, 2022
 * Floor class to create floor tiles
 */
package finalproject;

import static finalproject.Tile.TILESIZE;
import java.net.URL;
import javax.swing.ImageIcon;


public class Wall extends Entity implements Tile{
    private static URL url = Entity.class.getResource("wall.png"); //Wall image
    private static ImageIcon ii = new ImageIcon(url);
    private static final int TILETYPE = 1; //The tile type for walls is 1
    
    /** Constructor
     * creates a new wall with an x and y coordinate
     * @param x
     * @param y 
     */
    public Wall(double x, double y){ 
        super(x,y,TILESIZE,TILESIZE,x,y,TILESIZE,TILESIZE); //Calls the matching constructor in the superclass
        imgPlayer = ii.getImage(); 
    }
    
    /** Get tiletype method
     * @return the tileType
     */
    public int getTileType(){
        return TILETYPE;
    }
    
    /** Clone method
     * clones this wall
     * @return a new wall with the exact same attributes
     */
    public Wall clone(){
        Wall clone = new Wall(x, y);
        return clone;
    }
    
    /** Equals method
     * Checks if this wall is equal to another wall
     * @param otherWall the other wall
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Wall otherWall){
        return (x == otherWall.x && y == otherWall.y);
    }
    
    /** toString method
     * Creates a detailed string based on the current state of this wall
     * @return A string containing the values of the walls instance variables
     */
    public String toString(){
        return "Wall:" + super.toString() + "Tile type: " + TILETYPE;
    }
            
}
