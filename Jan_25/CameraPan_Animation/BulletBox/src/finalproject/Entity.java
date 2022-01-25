package finalproject;

import java.awt.*;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Image imgPlayer;
    protected boolean hitOn;
    protected boolean clipOn;
    protected int hitX;
    protected int hitY;
    protected int hitW;
    protected int hitH;

    public Entity(int x, int y, int w, int h) {
        
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

    }

    public Entity(int x, int y, int w, int h, boolean hitOn, int hitX, int hitY, int hitW, int hitH, boolean clipOn) {
        this(x, y, w, h);

        this.setHitOn(hitOn);
        this.setHitX(hitX);
        this.setHitY(hitY);
        this.setHitW(hitW);
        this.setHitH(hitH);
        this.setClipOn(clipOn);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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

    public int getHitX() {
        return hitX;
    }

    public void setHitX(int hitX) {
        this.hitX = hitX;
    }

    public int getHitY() {
        return hitY;
    }

    public void setHitY(int hitY) {
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
