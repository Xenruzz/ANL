package com.company;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Board extends JPanel {

    private Player player;
    Dimension d;
    private Timer timer;

    public Board() {
        initBoard();

    }

    private void initBoard() {

        addKeyListener(new TAdapter());

        setFocusable(true);

        d = new Dimension(800, 600);

        timer = new Timer(17, new GameCycle());
        timer.start();

        gameInit();

    }

    private void gameInit() {
        player = new Player(300, 300);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }

    private void doDrawing(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        drawPlayer(g);

        Toolkit.getDefaultToolkit().sync();

    }

    private void drawPlayer(Graphics g) {

        g.drawImage(player.getImage(), player.getX(), player.getY(), this);


    }

    private void update() {
        player.move();

    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {

        update();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);

        }
    }
}

