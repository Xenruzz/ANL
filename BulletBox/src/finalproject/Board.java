package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Player God;
    private Level Devil;
    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        
        gameInit();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void gameInit() {
        God = new Player(300, 300);
        Devil = new Level(Entity.class.getResourceAsStream("level1.txt"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i<Devil.getArrayWidth(); i++){
            for(int j = 0; j<Devil.getArrayHeight(); j++){
                g2d.drawImage(Devil.findTile(i,j).getImage(), Devil.findTile(i,j).getX() - God.getX() + 300, Devil.findTile(i,j).getY() - God.getY() + 300, this);
            }
        }
        g2d.drawImage(God.getImage(), 300, 300, this);      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        step();
    }
    
    private void step() {
        
        God.move(Devil);
        
        repaint(0, 0, 800, 600);         
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            God.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            God.keyPressed(e);
        }
    } 
}