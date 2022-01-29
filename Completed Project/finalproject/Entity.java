//Alex, Lado, Nathan
//January 27 2022
//Entity class. General class for all objects that will have an image, x, y, and hitbox
package finalproject;

import java.awt.*;

public abstract class Entity {

    /**
     * Get the Rectangle hitBox of this entity
     * @return the hitBox
     */
    public Rectangle getHitBox() {
        return hitBox;
    }

    /**
     * Set the Rectangle hitBox of this entity
     * @param hitBox the hitBox to set
     */
    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }
    protected double x;
    protected double y;
    protected int w;
    protected int h;
    protected Image imgPlayer;
    protected double hitX;
    protected double hitY;
    protected int hitW;
    protected int hitH;
    protected Rectangle hitBox;

    /**
     * Primary Constructor for an Entity
     * @param x - x pos
     * @param y - y pos
     * @param w - width
     * @param h - height
     */
    public Entity(double x, double y, int w, int h) {

        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);

        setHitX(x);
        setHitY(y);

        setHitW(w);
        setHitH(h);

        hitBox = null;
    }

    /**
     * Secondary Constructor for Entity
     * @param x - x pos
     * @param y - y pos
     * @param w - width
     * @param h - height
     * @param hitX - hitbox x pos
     * @param hitY - hitbox y pos
     * @param hitW - hitbox width
     * @param hitH - hitbox height
     */
    public Entity(double x, double y, int w, int h, double hitX, double hitY, int hitW, int hitH) {
        this(x, y, w, h);

        this.setHitX(hitX);
        this.setHitY(hitY);
        this.setHitW(hitW);
        this.setHitH(hitH);
    }

    /**
     * Get x pos of Entity
     * @return - the x pos
     */
    public double getX() {
        return x;
    }

    /**
     * Set x pos of entity
     * @param x - the x pos to change to
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Get the y pos of entity
     * @return - the y pos of the entity
     */
    public double getY() {
        return y;
    }

    /**
     * Set the y pos of entity
     * @param y - the y pos to change to
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the width of entity
     * @return - the width of entity
     */
    public int getW() {
        return w;
    }

    /**
     * Set the width of entity
     * @param w - the width of the entity
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * Get the height of entity
     * @return - the height of the entity
     */
    public int getH() {
        return h;
    }

    /**
     * Set the height of entity
     * @param h - the height to change to
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Get the image of the entity
     * @return - the image of the entity
     */
    public Image getImage() {
        return imgPlayer;
    }

    /**
     * Set the image
     * @param image - image to be set to
     */
    public void setImageIcon(Image image) {
        this.imgPlayer = image;
    }

    /**
     * Get the x pos of hitbox
     * @return - the x pos of hitbox
     */
    public double getHitX() {
        return hitX;
    }

    /**
     * Set the x pos of hitbox
     * @param hitX - the x pos of hitbox to be changed to
     */
    public void setHitX(double hitX) {
        this.hitX = hitX;
    }

    /**
     * Get the y pos of hitbox
     * @return - the y pos of hitbox
     */
    public double getHitY() {
        return hitY;
    }

    /**
     * Set the y pos of hitbox
     * @param hitY - the y pos of hitbox to be changed to
     */
    public void setHitY(double hitY) {
        this.hitY = hitY;
    }

    /**
     * Get the hitbox width
     * @return - width
     */
    public int getHitW() {
        return hitW;
    }

    /**
     * Get the hitbox width
     * @param hitW - the hitbox width
     */
    public void setHitW(int hitW) {
        this.hitW = hitW;
    }

    /**
     * Get the hitbox height
     * @return - the hitbox height
     */
    public int getHitH() {
        return hitH;
    }

    /**
     * Set the hitbox height
     * @param hitH - the hitbox height to be changed to
     */
    public void setHitH(int hitH) {
        this.hitH = hitH;
    }

    /**
     * Check to see if two Entity are equal
     * @param otherEntity - the other entity to compare to
     * @return - true if equal, false if not
     */
    public boolean equals(Entity otherEntity){
        return (x == otherEntity.x && y == otherEntity.y && w == otherEntity.w && h == otherEntity.h && hitX == otherEntity.hitX
                && hitY == otherEntity.hitY && hitW == otherEntity.hitW && hitH == otherEntity.hitH && imgPlayer.equals(otherEntity.imgPlayer));
    }

    /**
     * Get a string representation of this class
     * @return - the string representation of this class
     */
    public String toString(){
        return "\nX Position: " + x + "\nY Position: " + y + "\nWidth: " + w + "\nHeigth: "
                + h + "\nHitbox X: " + hitX + "\nHitboxY: " + hitY + "\nHitbox width: " + hitW + "\nHitbox height: " + hitH ;
    }
}