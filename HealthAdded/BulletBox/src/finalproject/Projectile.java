package finalproject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Projectile extends Entity{

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
        
    private double xVel, yVel;
    private Image image;
    boolean visible;
    
    public Projectile(double x, double y, double xVel, double yVel) {
       super(x, y, 25, 25);
        
       this.xVel = xVel;
       this.yVel = yVel;

       
       initProjectile();

    }

    
    public void initProjectile() {
        loadImage();
        
        visible = true;
        
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/finalproject/impShot.png");
        setImage(ii.getImage()); 
        
        w = getImage().getWidth(null);
        h = getImage().getHeight(null);
        
        hitW = w;
        hitH = h;
        
        hitBox = new Rectangle((int)x, (int)y, hitW, hitH);
    }
    
    public boolean move(Level level) {
        x += xVel;
        hitX += xVel;
        y += yVel;
        hitY += yVel;
        
        hitBox.translate((int)xVel, (int)yVel);
        return level.checkWall(this);   
    }
}