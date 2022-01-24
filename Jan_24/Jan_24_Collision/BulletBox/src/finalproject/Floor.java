/*
 * Nathan Smith
 * January 21, 2022
 * Floor class to create floor tiles
 */
package finalproject;

import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;


public class Floor extends Entity implements Tile{
    private static URL url = Entity.class.getResource("floor.png");

    private static ImageIcon ii = new ImageIcon(url);
    
    private static final int TILETYPE = 0;
    
    
    public Floor(int x, int y){ 
        super(x,y,TILESIZE,TILESIZE,false,x,y,TILESIZE,TILESIZE,true);  
        imgPlayer = ii.getImage(); 
    }
    
    public int getTileType(){
        return TILETYPE;
    }
    

    
    public Floor clone(){
        Floor clone = new Floor(x, y);
        return clone;
    }
    
    public boolean equals(Floor otherFloor){
        return (x == otherFloor.x && y == otherFloor.y);
    }
    
    public String toString(){
        return "Floor:" + super.toString() + "Tile type: " + TILETYPE;
    }
            
}

