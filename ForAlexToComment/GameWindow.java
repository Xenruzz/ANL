//Alex, Lado, Nathan
//January 27 2022
//GameWindow class

package com.company.Sprites;

import javax.swing.*;

public class GameWindow extends JFrame {

    public static BulletBox menu;
    public static LevelSelect levels;

    /**
     * Primary Constructor for a GameWindow
     * @param m - the BulletBox menu
     * @param l - the level selected
     * @param level - the level number
     */
    public GameWindow(BulletBox m, LevelSelect l, int level) {
        initUI(level);
        levels = l;
        menu = m;
    }

    /**
     * Create a UI
     * @param level - the level used
     */
    private void initUI(int level) {
        //create a new Game with the given level
        add(new Game(level));

        //set title to Bullet Box
        setTitle("Bullet Box");
        //resize window
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
