//Alex, Lado, Nathan
//January 27 2022
//Projectile class, an entity that dissapears upon hitting a wall, and hurts player
package finalproject;


import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Projectile extends Entity{

    /**
     * Get the image of this projectile
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Set the image of this projectile
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    private double xVel, yVel;
    private Image image;
    private boolean visible;

    /**
     * Check whether this object is visible
     * @return - whether this projectile is visible or not
     */
    public boolean getVisible() {
        return visible;
        
    }

    /**
     * Set whether this object is visible or not
     * @param visible - the boolean to be set to
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
        
    }
    
    /**
     * Primary constructor for a projectile
     * @param x - x pos
     * @param y - y pos
     * @param xVel - x velocity
     * @param yVel - y velocity
     */
    public Projectile(double x, double y, double xVel, double yVel) {
        super(x, y, 0, 0);

        this.xVel = xVel;
        this.yVel = yVel;

        initProjectile();

    }

    /**
     * Create projectile
     */
    public void initProjectile() {
        //load image
        loadImage();

        //set visible
        visible = true;

    }

    /**
     * Load image to projectile
     */
    private void loadImage() {
        //get image icon
        ImageIcon ii = new ImageIcon("src/finalproject/impShot.png");
        //sets image to object
        setImage(ii.getImage());

        //sets width and height to image width and height
        w = getImage().getWidth(null);
        h = getImage().getHeight(null);

        //set the hitbox width and height to be the width and height
        hitW = w;
        hitH = h;

        //create a rectangle that will represent the hitbox
        hitBox = new Rectangle((int)x, (int)y, hitW, hitH);
    }

    /**
     * Move the projectile
     * @param level - the level its in
     * @return whether it was moved successfully (not into a wall). True if not in wall, false if in wall
     */
    public boolean move(Level level) {
        //increase x pos and hitbox x pos by x velocity
        x += xVel;
        hitX += xVel;
        //increase y pos and hitbox y pos by x velocity
        y += yVel;
        hitY += yVel;

        //set the hitbox location
        hitBox.setLocation((int)hitX, (int)hitY);
        //return whether this projectile is in a wall or not
        return level.checkWall(this);
    }
}