package finalproject;

public abstract class Enemy extends Entity {
    
    int health;
    
    public Enemy(int x, int y, int w, int h, int EnemyType) {
        super(x, y, w, h);
        
    }
    
    public void kill() {
        
    }
    
    public void damage() {
        
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
    
    public void attack() {
        
    }
    
    
}
