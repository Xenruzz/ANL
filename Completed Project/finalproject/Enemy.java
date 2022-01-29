/* Alex, Lado, Nathan
 * January 23 2022
 * An enemy class to create enemy objects
*/

package finalproject;

import java.util.ArrayList;

public abstract class Enemy extends Entity {//Enemy is an abstract class
    
    protected int health = 1;
    protected int enemyType;
    protected ArrayList<Projectile> projectiles = new ArrayList();
    
    /** Constructor
     * Creates an enemy based on an x and y coordinate and a width and height
     * @param x position of the enemy
     * @param y position of the enemy
     * @param w width of the enemy
     * @param h height of the enemy
     */
    public Enemy(double x, double y, int w, int h) {
        super(x, y, w, h); //Calls the matching constructor in the super class
    }
    
    /** Update projectiles method
     * updates the enemies projectiles
     * @param level the level that the enemy is in
     * @param p the player that the enemy is trying to kill
     */
    public void updateProjectiles(Level level, Player p){
        for(int i = projectiles.size()-1; i>=0; i--){ //Loops through the entire array of projectiles
            if (projectiles.get(i).getHitBox().intersects(p.getHitBox())) { //Checks if the projectile hits the player
                p.takeDamage(); //The player takes damage and the projectile is removed
                projectiles.remove(i);
            }else if(projectiles.get(i).move(level) == true){ //Checks if the projectile hits a wall and removes it if it does. This also moves the projectile
                projectiles.remove(i); 
            }
            

        }
    }
    
    /** Get projectile number
     * Returns the number of projectiles
     * @return the size of the projectile array list
     */
    public int getProjectileNumber(){
        return projectiles.size();
    }
    
    /** Get enemy type
     * @return the enemy type of this enemy
     */
    public int getEnemyType(){
        return enemyType;
    }
    
    /** Find projectile method
     * finds a projectile given its index
     * @param index the index of the projectile
     * @return the projectile at that index
     */
    public Projectile findProjectile(int index){
        return projectiles.get(index);
    }
    
    /** get hp method
     * @return the hp
     */
    public int getHP() {
        return health;
    }
    
    /** Set hp method
     * changes the hp of the enemy
     * @param health the new HP
     */
    public void setHP(int health) {
        this.health = health;
    }
    
    //Each enemy needs an attack method but they should all be different
    abstract public void attack();
   
    /** Equals method
     * checks if two enemies are equal
     * @param otherEnemy the other enemy that is being checked
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Enemy otherEnemy){
        return (super.equals(otherEnemy) && enemyType == otherEnemy.enemyType);
    }
    
    /** toString method
     * Creates a detailed message about the current state of the enemy
     * @return a String containing the instance variables of the enemy
     */
    public String toString(){
        return super.toString() + "Enemy Type: " + enemyType;
    }
}
