package finalproject;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Entity {
    private int dx;
    private int dy;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Player(int x, int y) {
        super(x, y, 20, 20);
        initPlayer();
    }

    private void initPlayer() {
        loadImage();
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/finalproject/playerStandDown.png");
        imgPlayer = ii.getImage(); 
        
        w = imgPlayer.getWidth(null);
        h = imgPlayer.getHeight(null);
        hitW = w;
        hitH = h;
    }

    public void move(Level level) {
        dy = 0;
        dx = 0;
        if (leftPressed == true){
            dx = dx-3;
        }
        if (rightPressed == true){
            dx = dx+3;
        } 
        if (upPressed == true){
            dy = dy-3;
        }
        if (downPressed == true){
            dy = dy+3;
        }
        
        if (dx!=0 && dy!=0){
            dx = (dx/3) * 2;
            dy = (dy/3) * 2;
        }
        
        x += dx;
        hitX+=dx;
        if (level.checkWall(this) == true){
            x-=dx;
            hitX-=dx;

        }
        y += dy;
        hitY+=dy;
        if (level.checkWall(this) == true){
            y-=dy;
            hitY-=dy;

        }
        
        
        
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        
        if (key == KeyEvent.VK_LEFT){
            leftPressed = true;
        } 
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = true;
        } 
        if (key == KeyEvent.VK_UP){
            upPressed = true;
        } 
        if (key == KeyEvent.VK_DOWN){
            downPressed = true;
        } 
        
        
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            leftPressed = false;
        } 
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (key == KeyEvent.VK_UP){
            upPressed = false;
        } 
        if (key == KeyEvent.VK_DOWN){
            downPressed = false;
        } 
    }
}