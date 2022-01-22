/*
 * Nathan Smith
 * January 22, 2022
 * Wall class to create wall objects
 */
package bulletbox;

import static bulletbox.Tile.TILESIZE;

import java.awt.*;


public class Wall extends Entity implements Tile{
    static Toolkit t = Toolkit.getDefaultToolkit();
    static Image wallImage = t.getImage("wallTile.png");
    private static final int TILETYPE = 1;
    
    
    public Wall(int x, int y){ 
        super(x,y,TILESIZE,TILESIZE,false,x,y,TILESIZE,TILESIZE,false, wallImage);     
    }
    
    public int getTileType(){
        return TILETYPE;
    }
    
    public Wall clone(){
        Wall clone = new Wall(x, y);
        return clone;
    }
    
    public boolean equals(Wall otherWall){
        return (x == otherWall.x && y == otherWall.y);
    }
    
    public String toString(){
        return "Floor:" + super.toString() + "Tile type: " + TILETYPE;
    }
}
