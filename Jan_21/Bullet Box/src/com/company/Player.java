package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private int direction;

    public Player(int x, int y) {
        super(x, y, 20, 20);
        initPlayer();
    }

    private void initPlayer() {

        ImageIcon icon = new ImageIcon("src/Sprites/pacman.png");
        setImage(icon.getImage());

        setX(300);
        setY(300);


    }

    public void move() {
        x += direction;

        if (x < 10) x = 10;
        else if (x > 590) x = 590;

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            direction = -2;

        } else if (key == KeyEvent.VK_RIGHT) {
            direction = 2;

        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            direction = 0;

        }
    }
}
