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
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(God.getImage(), God.getX(), God.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        step();
    }
    
    private void step() {
        
        God.move();
        
        repaint(God.getX()-2, God.getY()-2, 
                God.getW()+4, God.getH()+4);     
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
