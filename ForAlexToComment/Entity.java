package finalproject;

import java.awt.*;

public abstract class Entity {

    /**
     * @return the hitBox
     */
    public Rectangle getHitBox() {
        return hitBox;
    }

    /**
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
    protected boolean hitOn;
    protected boolean clipOn;
    protected double hitX;
    protected double hitY;
    protected int hitW;
    protected int hitH;
    protected Rectangle hitBox;

    public Entity(double x, double y, int w, int h) {
        
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
        
        setHitX(x);
        setHitY(y);

        setHitW(w);
        setHitH(h);

        setHitOn(true);
        setClipOn(true);

        hitBox = null;
    }

    public Entity(double x, double y, int w, int h, boolean hitOn, double hitX, double hitY, int hitW, int hitH, boolean clipOn) {
        this(x, y, w, h);

        this.setHitOn(hitOn);
        this.setHitX(hitX);
        this.setHitY(hitY);
        this.setHitW(hitW);
        this.setHitH(hitH);
        this.setClipOn(clipOn);
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Image getImage() {
        return imgPlayer;
    }

    public void setImageIcon (Image image) {
        this.imgPlayer = image;
    }

    public boolean isHitOn() {
        return hitOn;
    }

    public void setHitOn(boolean hitOn) {
        this.hitOn = hitOn;
    }

    public boolean isClipOn() {
        return clipOn;
    }

    public void setClipOn(boolean clipOn) {
        this.clipOn = clipOn;
    }

    public double getHitX() {
        return hitX;
    }

    public void setHitX(double hitX) {
        this.hitX = hitX;
    }

    public double getHitY() {
        return hitY;
    }

    public void setHitY(double hitY) {
        this.hitY = hitY;
    }

    public int getHitW() {
        return hitW;
    }

    public void setHitW(int hitW) {
        this.hitW = hitW;
    }

    public int getHitH() {
        return hitH;
    }

    public void setHitH(int hitH) {
        this.hitH = hitH;
    }
    
    public boolean equals(Entity otherEntity){
        return (x == otherEntity.x && y == otherEntity.y && w == otherEntity.w && h == otherEntity.h && hitOn == otherEntity.hitOn && clipOn == otherEntity.clipOn && hitX == otherEntity.hitX
               && hitY == otherEntity.hitY && hitW == otherEntity.hitW && hitH == otherEntity.hitH && imgPlayer.equals(otherEntity.imgPlayer));
    }
    
    public String toString(){
        return "\nX Position: " + x + "\nY Position: " + y + "Width: " + w + "\nHeigth: " 
                + h + "\nHit On: " + hitOn + "\nClip On: " + clipOn + "Hitbox X: " + hitX + "HitboxY: " + hitY + "Hitbox width: " + hitW + "Hitbox height: " + hitH ;
    }
}
