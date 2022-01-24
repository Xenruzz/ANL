/*
 * Nathan Smith
 * January 24, 2022
 * A level class to store level objects
 */
package finalproject;

import java.io.*;
import java.util.*;


public class Level {
    private Tile[][] tiles;
    private int arrayWidth, arrayHeight;
    public Level(InputStream file){
        readFile(file);
    }
    
    private void readFile(InputStream file){
        try{
            int tileType;
            Scanner scanner = new Scanner(file);
            arrayWidth = scanner.nextInt();
            arrayHeight = scanner.nextInt();
            tiles = new Tile[arrayWidth][arrayHeight];
            for(int y = 0; y<arrayHeight; y++){
                for(int x = 0; x<arrayWidth; x++){
                    tileType = scanner.nextInt();
                    if (tileType == 0){
                        tiles[x][y] = new Floor(x*50, y*50);
                    } else if (tileType == 1){
                        tiles[x][y] = new Wall(x*50, y*50);
                    }
                }
            }
        } catch(Exception e){
            
        }
        
    }
    
    public Tile findTile(int x, int y){
        return tiles[x][y];
    }
    
    public boolean checkWall(Entity entity){
        boolean wall = false;
        for(int i = entity.getHitX()/50; i<((entity.getHitX()+ entity.getHitW())/50)+1 ; i++){
            for(int j = entity.getHitY()/50; j<((entity.getHitY()+ entity.getHitH())/50)+1 ; j++){
                System.out.println(i + ", " + j);
                if (tiles[i][j].getTileType() == 1){
                    wall = true;
                }
            }
            
        }
        return wall;
    }
}
