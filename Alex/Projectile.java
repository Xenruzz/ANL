/*
 * Lado Natsvlishvili
 * 1/21/2022
 * Projectile abstract class which tracks x and y velocities of projectiles
 */
package finalproject;

import java.awt.Image;

public abstract class Projectile extends Entity {

    protected int xVel;
    protected int yVel;

    public Projectile(int x, int y, int w, int h, Image image, int xVel, int yVel) {
        super(x, y, w, h, image);
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public int getXVel() {
        return xVel;
    }

    public int getYVel() {
        return yVel;
    }

    public void move() {
        x += xVel;
        y += yVel;
    }

    public void checkCollision() {
        //check if hitting a player
        //check if hitting a wall
    }

    public boolean equals(Projectile otherProjectile) {

        return (super.equals(otherProjectile) && xVel == otherProjectile.xVel && yVel == otherProjectile.yVel);
    }

    public String toString() {
        String str;     
        str =  super.toString() + "X Velocity: " + xVel + "\n"
                + "Y Velocity" + yVel;
        return str;
    }

}
