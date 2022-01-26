/*
 * Nathan Smith
 * January 24, 2022
 * A level class to store level objects
 */
package finalproject;

import java.awt.Graphics2D;
import java.io.*;
import java.util.*;


public class Level {
    private Tile[][] tiles;
    private ArrayList<Enemy> enemies = new ArrayList();
    private int arrayWidth, arrayHeight;
    public Level(InputStream file){
        readFile(file);
    }
    
    private void readFile(InputStream file){
        try{
            int tileType, enemyType;
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
            int enemyNumber = scanner.nextInt();
            for (int i = 0; i<enemyNumber; i++){
                enemyType = scanner.nextInt();
                if (enemyType == 0){
                    enemies.add(new Turret(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), 
                            scanner.nextDouble(), scanner.nextInt(), scanner.nextInt()));
                }
                
            }
        } catch(Exception e){
            System.out.println("Error" + e);
        }
        
    }
    
    public Tile findTile(int x, int y){
        return tiles[x][y];
    }
    
    public Enemy findEnemy(int index){
        return enemies.get(index);
    }
    
    public int getArrayWidth(){
        return arrayWidth;
    }
    
    public int getArrayHeight(){
        return arrayHeight;
    }
    
    public int getEnemyNumber(){
        return enemies.size();
    }
    
    public boolean checkWall(Entity entity){
        boolean wall = false;
        for(int i = (int)entity.getHitX()/50; i<(((int)entity.getHitX()+ entity.getHitW())/50)+1 ; i++){
            for(int j = (int)entity.getHitY()/50; j<(((int)entity.getHitY()+ entity.getHitH())/50)+1 ; j++){

                if (tiles[i][j].getTileType() == 1){
                    wall = true;
                }
            }
        }
        
        return wall;
    }
    
    public void updateEnemies(Player p){
        
        for(int i = enemies.size()-1; i>=0; i--){

            enemies.get(i).updateProjectiles(this, p);
            enemies.get(i).attack();
            if (enemies.get(i).getHP() <= 0){
                enemies.remove(i);
            }
        }
    }
}