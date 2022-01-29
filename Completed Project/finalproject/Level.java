/*
 * Alex, Lado, Nathan
 * January 24, 2022
 * A level class to store level objects
 */
package finalproject;

import java.io.*;
import java.util.*;


public class Level {
    private Tile[][] tiles; //2d array of tiles
    private ArrayList<Enemy> enemies = new ArrayList(); //Array list of enemies
    private int arrayWidth, arrayHeight, levelNum, winIndexX, winIndexY;
    private double spawnX, spawnY;
    
    /** Constructor
     * creates a level based on a level number and a text file
     * @param file
     * @param levelNum 
     */
    public Level(InputStream file, int levelNum){
        readFile(file); //Reads the text file 
        this.levelNum = levelNum; //Sets the level number
        
    }
    
    private void readFile(InputStream file){
        try{
            int tileType, enemyType;
            Scanner scanner = new Scanner(file); //Creates a new scanner 
            arrayWidth = scanner.nextInt(); //The first two ints in the file should be the width and height of the array of files
            arrayHeight = scanner.nextInt();
            tiles = new Tile[arrayWidth][arrayHeight];//Sets the 2d array of tiles
            for(int y = 0; y<arrayHeight; y++){ //Loops through each spot in the 2D array
                for(int x = 0; x<arrayWidth; x++){
                    tileType = scanner.nextInt(); //In the text file there will a 2D array of ints correspoding to which type of tiles they are
                    if (tileType == 0){ //If the type is 0 then it is a floor tiles
                        tiles[x][y] = new Floor(x*50, y*50); //Creates a new floor
                    } else if (tileType == 1){ //1 is a wall
                        tiles[x][y] = new Wall(x*50, y*50); //Creates a new wall
                    } else if (tileType == 2){ //2 is the win square. It is the same as a floor but you win if you touch it
                        tiles[x][y] = new Floor(x*50, y*50);
                        winIndexX = x;
                        winIndexY = y;
                    }
                }
            }
            int enemyNumber = scanner.nextInt(); //After the 2D array there will be an int corresponding to the number of enemies in the level
            for (int i = 0; i<enemyNumber; i++){ //Loops through for each enemy
                enemyType = scanner.nextInt(); //The next number will be the type of enemu
                if (enemyType == 0){ //Type 0 is turret
                    enemies.add(new Turret(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), 
                            scanner.nextDouble(), scanner.nextInt(), scanner.nextInt()));
                } else if (enemyType == 1){ //Type 1 is slime
                    enemies.add(new Slime(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                } else if (enemyType == 2){ //Type 2 is skeleton
                    enemies.add(new Skeleton(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt()));
                } else if (enemyType == 3){ //Type 3 is dragon
                    enemies.add(new Dragon(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt()));
                }
                
            }
            spawnX = scanner.nextDouble(); //The last two numbers are the spawn coordinates for the player
            spawnY = scanner.nextDouble();
        } catch(Exception e){
            System.out.println("Error" + e);
        }
        
    }
    
    /** Find tile method
     * Finds a tile based on an x index and y index
     * @param x the x index in the 2D array
     * @param y the y index in the 2D array
     * @return the tile at that index
     */
    public Tile findTile(int x, int y){
        return tiles[x][y];
    }
    
    /** Find enemy method
     * Finds an enemy given its index in the array list
     * @param index the index of the enemy
     * @return the enemy at that index
     */
    public Enemy findEnemy(int index){
        return enemies.get(index);
    }
    
    /** Get array width
     * returns the width of the 2D array
     * @return the array width variable
     */
    public int getArrayWidth(){
        return arrayWidth;
    }
    
    /** Get array height
     * returns the height of the 2D array
     * @return the arrayHeigh variable
     */
    public int getArrayHeight(){
        return arrayHeight;
    }
    
    /** Get enemyNumber method
     * return the number of enemies
     * @return the size of the enemies array list
     */
    public int getEnemyNumber(){
        return enemies.size();
    }
    
    /** Get level num method
     * returns the level number
     * @return the levelNum variable
     */
    public int getLevelNum(){
        return levelNum;
    }
    
    /** Get spawn X method
     * @return the x coordinate of the players spawn
     */
    public double getSpawnX(){
        return spawnX;
    }
    
    /** Get spawn Y method
     * @return the y coordinate of the players spawn
     */
    public double getSpawnY(){
        return spawnY;
    }
    
    /** Get win index X method
     * @return the x index of the win tile
     */
    public int getWinIndexX(){
        return winIndexX;
    }
    
    /** Get win index Y method
     * @return the y index of the win tile
     */
    public int getWinIndexY(){
        return winIndexY;
    }
    
    /** Check wall method
     * Checks if an entity is hitting one of the walls in this level
     * @param entity the entity that is being checked
     * @return true if the are touching a wall, false if not
     */
    public boolean checkWall(Entity entity){
        boolean wall = false;
        //Loops through all of the tiles that the entities hitbox is in
        for(int i = (int)entity.getHitX()/50; i<(((int)entity.getHitX()+ entity.getHitW())/50)+1 ; i++){
            for(int j = (int)entity.getHitY()/50; j<(((int)entity.getHitY()+ entity.getHitH())/50)+1 ; j++){
                if (tiles[i][j].getTileType() == 1){ //If one of the tiles is a wall then the boolean is set to true
                    wall = true;
                }
            }
        }
        return wall;
    }
    
    public boolean checkWinTile(Player p){
        boolean winTile = false;
        //Loops through all of the tiles that the entities hitbox is in
        for(int i = (int)p.getHitX()/50; i<(((int)p.getHitX()+ p.getHitW())/50)+1 ; i++){
            for(int j = (int)p.getHitY()/50; j<(((int)p.getHitY()+ p.getHitH())/50)+1 ; j++){
                if (i == winIndexX && j == winIndexY){
                    winTile = true;
                }
            }
        }
        return winTile;
    }
    
    /** Update enemies method
     * updates the levels enemies
     * @param p the player that the enemies will try to attack
     */
    public void updateEnemies(Player p){
        for(int i = enemies.size()-1; i>=0; i--){ //Loops through every enemy

            enemies.get(i).updateProjectiles(this, p); //Updates their projectiles
            enemies.get(i).attack(); //Each enemy attacks
            if (enemies.get(i).getEnemyType() == 2){ //If the enemy is a skeleton or dragon then they chase the player
                ((Skeleton)enemies.get(i)).chase(p, this);
            } else if (enemies.get(i).getEnemyType() == 3){
                ((Dragon)enemies.get(i)).chase(p, this);
            }
            if (enemies.get(i).getHP() <= 0){ //If the enemy runs out of hp then they die
                enemies.remove(i);
            }
        }
    }
}