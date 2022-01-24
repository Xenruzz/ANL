package finalproject;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Entity {
    private int dx;
    private int dy;

    public Player(int x, int y) {
        super(x, y, 20, 20);
        initPlayer();
    }

    private void initPlayer() {
        loadImage();
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/finalproject/player_down_walk2.png");
        imgPlayer = ii.getImage(); 
        
        w = imgPlayer.getWidth(null);
        h = imgPlayer.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT -> dx = -2;
            case KeyEvent.VK_RIGHT -> dx = 2;
            case KeyEvent.VK_UP -> dy = -2;
            case KeyEvent.VK_DOWN -> dy = 2;
            default -> {
                dy = 0;
                dx = 0;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> dx = 0;
            case KeyEvent.VK_RIGHT -> dx = 0;
            case KeyEvent.VK_UP -> dy = 0;
            case KeyEvent.VK_DOWN -> dy = 0;
            default -> {
                dy = 0;
                dx = 0;
            }
        }
    }
}
