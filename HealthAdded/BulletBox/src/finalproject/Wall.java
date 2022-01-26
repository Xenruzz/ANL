/*
 * Nathan Smith
 * January 21, 2022
 * Floor class to create floor tiles
 */
package finalproject;

import static finalproject.Tile.TILESIZE;
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;


public class Wall extends Entity implements Tile{
    private static URL url = Entity.class.getResource("wall.png");

    private static ImageIcon ii = new ImageIcon(url);
    
    private static final int TILETYPE = 1;
    
    
    public Wall(double x, double y){ 
        super(x,y,TILESIZE,TILESIZE,false,x,y,TILESIZE,TILESIZE,false);  
        imgPlayer = ii.getImage(); 
    }
    
    public int getTileType(){
        return TILETYPE;
    }
    

    
    public Wall clone(){
        Wall clone = new Wall(x, y);
        return clone;
    }
    
    public boolean equals(Floor otherFloor){
        return (x == otherFloor.x && y == otherFloor.y);
    }
    
    public String toString(){
        return "Wall:" + super.toString() + "Tile type: " + TILETYPE;
    }
            
}
