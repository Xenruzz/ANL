package com.company;

import java.awt.*;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Image image;
    protected boolean hitOn;
    protected boolean clipOn;
    protected double hitX;
    protected double hitY;
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
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
}