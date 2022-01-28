package finalproject;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Entity{

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    private double dx;
    private double dy;
    private int health;
    private boolean upPressed, downPressed, leftPressed, rightPressed, textBox;
    private double time = 0;
    Image[][] sprites;

    public Player(double x, double y) {
        super(x, y, 20, 20);
        initPlayer();
        textBox = true;
    }

    private void initPlayer() {
        loadImage();
        health = 5;
        
    }
    
    private void loadImage() {
        
        sprites = new Image[4][3];
        
        sprites[0][0] = SpriteSheet.playerDownStand.getImage();
        sprites[0][1] = SpriteSheet.playerDownWalk1.getImage();
        sprites[0][2] = SpriteSheet.playerDownWalk2.getImage();
        
        sprites[1][0] = SpriteSheet.playerLeftStand.getImage();
        sprites[1][1] = SpriteSheet.playerLeftWalk1.getImage();
        sprites[1][2] = SpriteSheet.playerLeftWalk2.getImage();
        
        sprites[2][0] = SpriteSheet.playerRightStand.getImage();
        sprites[2][1] = SpriteSheet.playerRightWalk1.getImage();
        sprites[2][2] = SpriteSheet.playerRightWalk2.getImage();
        
        sprites[3][0] = SpriteSheet.playerUpStand.getImage();
        sprites[3][1] = SpriteSheet.playerUpWalk1.getImage();
        sprites[3][2] = SpriteSheet.playerUpWalk2.getImage();
        
        imgPlayer = sprites[0][0];
        
        w = imgPlayer.getWidth(null);
        h = imgPlayer.getHeight(null);
        hitW = w - 20;
        hitH = h - 2;
        hitX = x + 11;
        hitY = y + 4;
        
        hitBox = new Rectangle((int)hitX, (int)hitY, hitW, hitH);
    }

    public void move(Level level) {
        dy = 0;
        dx = 0;
        if (leftPressed == true){
            dx = dx-3;
            imgPlayer = sprites[1][(int)time%2 + 1];
            
        }
        if (rightPressed == true){
            dx = dx+3;
            
            if (leftPressed) imgPlayer = sprites[0][0];
            else imgPlayer = sprites[2][(int)time%2 + 1];
        } 
        if (upPressed == true){
            dy = dy-3;
            imgPlayer = sprites[3][(int)time%2 + 1];
        }
        if (downPressed == true){
            dy = dy+3;
            if (upPressed) imgPlayer = sprites[3][0];
            else imgPlayer = sprites[0][(int)time%2 + 1];
        }
        
        if (dx!=0 && dy!=0){
            dx = Math.cos(Math.PI/4) *dx;
            dy = Math.sin(Math.PI/4)*dy;
        }
        
        
        x += dx;
        hitX += dx;
        if (level.checkWall(this) == true){
            x-=dx;
            hitX -= dx;

        }
        
        y += dy;
        hitY += dy;
        if (level.checkWall(this) == true){
            y-=dy;
            hitY -= dy;

        }
        
        

        
        hitBox.setLocation((int)hitX, (int)hitY);
        
        time += 0.05;
        time %= 1000007;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER){
            textBox = false;
        }

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
            imgPlayer = sprites[1][0];
        } 
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = false;
            imgPlayer = sprites[2][0];
        }
        if (key == KeyEvent.VK_UP){
            upPressed = false;
            imgPlayer = sprites[3][0];
        } 
        if (key == KeyEvent.VK_DOWN){
            downPressed = false;
            imgPlayer = sprites[0][0];
        } 
    }
    
    public void takeDamage() {
        setHealth(getHealth() - 1);
        
    }
    
    public boolean getTextBox(){
        return textBox;
    }
}