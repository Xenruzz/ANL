//Alex, Lado, Nathan
//January 27 2022
//A Class for the player. Inherits from Entity, difference is has different movement keys, and has health points
package finalproject;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Entity{

    /**
     * Get the player health
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the player health
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
    private Image[][] sprites;

    /**
     * Primary constructor for a player
     * @param x - the x pos
     * @param y - the y pos
     */
    public Player(double x, double y) {
        super(x, y, 0, 0);
        initPlayer();
        textBox = true;
    }

    /**
     * Setup for Player Class
     */
    private void initPlayer() {
        //load image
        loadImage();
        //set initial hp which is 5
        health = 5;

    }

    /**
     * Loads the image for the player
     */
    private void loadImage() {

        //array holds all the sprites
        sprites = new Image[4][3];

        //manually get all the sprites
        //sprites for player down
        sprites[0][0] = SpriteSheet.playerDownStand.getImage();
        sprites[0][1] = SpriteSheet.playerDownWalk1.getImage();
        sprites[0][2] = SpriteSheet.playerDownWalk2.getImage();

        //sprites for player left
        sprites[1][0] = SpriteSheet.playerLeftStand.getImage();
        sprites[1][1] = SpriteSheet.playerLeftWalk1.getImage();
        sprites[1][2] = SpriteSheet.playerLeftWalk2.getImage();

        //sprites for player right
        sprites[2][0] = SpriteSheet.playerRightStand.getImage();
        sprites[2][1] = SpriteSheet.playerRightWalk1.getImage();
        sprites[2][2] = SpriteSheet.playerRightWalk2.getImage();

        //sprites for player up
        sprites[3][0] = SpriteSheet.playerUpStand.getImage();
        sprites[3][1] = SpriteSheet.playerUpWalk1.getImage();
        sprites[3][2] = SpriteSheet.playerUpWalk2.getImage();

        //set the inital sprite for the player
        imgPlayer = sprites[0][0];

        //set the width and height for player
        w = imgPlayer.getWidth(null);
        h = imgPlayer.getHeight(null);
        //set the width to be 20 less than image width
        hitW = w - 20;
        //set height to be 2 less than image height
        hitH = h - 2;
        //set hitbox x to be 11 right of player x
        hitX = x + 11;
        //set hitbox y to be 4 below player y
        hitY = y + 4;

        //create a new rectangle which represents the hitbox
        hitBox = new Rectangle((int)hitX, (int)hitY, hitW, hitH);
    }

    /**
     * Move the player
     * @param level - the level the player is in
     */
    public void move(Level level) {
        //the directions (x and y)
        dy = 0;
        dx = 0;
        //if the player presses left
        if (leftPressed == true){
            //direction x is moving back 3
            dx = dx-3;
            //set sprite based on whether the time is even/odd
            imgPlayer = sprites[1][(int)time%2 + 1];

        }
        //if the player presses right
        if (rightPressed == true){
            //direction x is moving right 3
            dx = dx+3;

            //if the left button is also pressed, reset sprite
            if (leftPressed) imgPlayer = sprites[0][0];
            else imgPlayer = sprites[2][(int)time%2 + 1]; //else, change sprite accordingly
        }
        //if the player presses up
        if (upPressed == true){
            //set direction y to be back 3
            dy = dy-3;
            //set the image of the sprite accordingly
            imgPlayer = sprites[3][(int)time%2 + 1];
        }
        //if the player presses down
        if (downPressed == true){
            //set direction y to go forward 3
            dy = dy+3;
            //if the player also pressed down, reset sprite
            if (upPressed) imgPlayer = sprites[3][0];
            else imgPlayer = sprites[0][(int)time%2 + 1]; //else, change sprite accordingly
        }

        //if player is changing in both x and y
        if (dx!=0 && dy!=0){
            //change it so that the diagonal path is same speed as if walking straight
            dx = Math.cos(Math.PI/4) *dx;
            dy = Math.sin(Math.PI/4)*dy;
        }

        //change x position
        x += dx;
        //change x hitbox
        hitX += dx;
        //if the player is in a wall
        if (level.checkWall(this) == true){
            //move back to original x positions
            x-=dx;
            hitX -= dx;

        }

        //change y pos
        y += dy;
        //change hitbox y pos
        hitY += dy;
        //if the player is in a wall
        if (level.checkWall(this) == true){
            //move back to original y positions
            y-=dy;
            hitY -= dy;

        }

        //set the hitbox to new hitbox locations
        hitBox.setLocation((int)hitX, (int)hitY);

        //increment the time
        time += 0.05;
        //use modulus so that long value doesnt wrap
        time %= 1000007;
    }

    /**
     * Check if a key has been pressed
     * @param e - the KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        //get which key has been pressed
        int key = e.getKeyCode();

        //if enter key is pressed, set textbox to false
        if (key == KeyEvent.VK_ENTER){
            textBox = false;
        }

        //if left key is pressed, set the boolean for left pressed to be true
        if (key == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        //if the right key is pressed, set the boolean for the right pressed to be true
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        //if the up key is pressed, set the boolean for the up pressed to be true
        if (key == KeyEvent.VK_UP){
            upPressed = true;
        }
        //if the down key is pressed, set the boolean for the down pressed to be true
        if (key == KeyEvent.VK_DOWN){
            downPressed = true;
        }
    }

    /**
     * Check to see which keys are released
     * @param e - the KeyEvent
     */
    public void keyReleased(KeyEvent e) {
        //get the key event key
        int key = e.getKeyCode();

        //if the left key is released, set the boolean for left pressed to be false
        if (key == KeyEvent.VK_LEFT){
            leftPressed = false;
            //reset sprite
            imgPlayer = sprites[1][0];
        }
        //if the right key is released, set the boolean for right pressed to be false
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = false;
            //reset sprite
            imgPlayer = sprites[2][0];
        }
        //if the up key is released, set the boolean for the up pressed to be false
        if (key == KeyEvent.VK_UP){
            upPressed = false;
            //reset sprite
            imgPlayer = sprites[3][0];
        }
        //if the down key is released, set the boolean for the down pressed to be false
        if (key == KeyEvent.VK_DOWN){
            downPressed = false;
            //reset sprite
            imgPlayer = sprites[0][0];
        }
    }

    /**
     * Take 1 damage, remove 1 health point
     */
    public void takeDamage() {
        setHealth(getHealth() - 1);

    }

    /**
     * Get the textbox (tutorial)
     * @return - the textbox
     */
    public boolean getTextBox(){
        return textBox;
    }
}
