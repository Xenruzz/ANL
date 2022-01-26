package finalproject;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class Enemy extends Entity {
    
    protected int health =1;
    protected int enemyType;
    protected ArrayList<Projectile> projectiles = new ArrayList();
    
    public Enemy(double x, double y, int w, int h) {
        super(x, y, w, h);
    }
    
    public void kill() {
        
    }
    
    public void damage() {
        
    }
    
    public void updateProjectiles(Level level, Player p){
        for(int i = projectiles.size()-1; i>=0; i--){
            if (projectiles.get(i).getHitBox().intersects(p.getHitBox())) {
                p.takeDamage();
                System.out.println("true");
                projectiles.remove(i);
                
            }else if(projectiles.get(i).move(level) == true){
                projectiles.remove(i);
            }
            

        }
    }
    
    public int getProjectileNumber(){
        return projectiles.size();
    }
    
    public Projectile findProjectile(int index){
        return projectiles.get(index);
    }
    
   
    
    public int getHP() {
        return health;
    }
    
    public void setHP(int health) {
        this.health = health;
    }
    
    public void fullHeal() {
        
    }
    
    public void partialHeal(int healAmount) {
        
    }
    
    public void move() {
        
    }
    
    abstract public void attack();
    
    
}
