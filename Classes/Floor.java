/*
 * Nathan Smith
 * January 21, 2022
 * Floor class to create floor tiles
 */
package bulletbox;

import java.awt.*;


public class Floor extends Entity implements Tile{
    static Toolkit t = Toolkit.getDefaultToolkit();
    static Image floorImage = t.getImage("floorTile.png");
    private static final int TILETYPE = 0;
    
    
    public Floor(int x, int y){ 
        super(x,y,TILESIZE,TILESIZE,false,x,y,TILESIZE,TILESIZE,true, floorImage);     
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
