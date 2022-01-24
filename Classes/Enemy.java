/*
 * Lado Natsvlishvili
 * 1/21/2021
 */
package finalproject;

import java.awt.Image;

public class Enemy extends Entity {

    protected int health;

    public Enemy(int x, int y, int w, int h, Image image, int health) {
        super(x, y, w, h, image);
        this.health = health;
    }

    public void kill() {
        
    }

    public void damage() {
        
    }

    public int getHP() {
        return health;
    }

    public void setHP(int h) {
        h = health;
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
