package finalproject;

import java.awt.Image;
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
        
    int xVel, yVel;
    private Image image;
    boolean visible;
    
    public Projectile(int x, int y, int xVel, int yVel) {
       super(x, y, 25, 25);
        
       this.xVel = xVel;
       this.yVel = yVel;
       
       initProjectile();

    }

    public Projectile(int x, int y, int w, int h, boolean hitOn, int hitX, int hitY, int hitW, int hitH, boolean clipOn, int xVel, int yVel) {
        super(x, y, w, h, hitOn, hitX, hitY, hitW, hitH, clipOn);
        
        this.xVel = xVel;
        this.yVel = yVel;
        
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
    }
    
    public void move(Level level) {
        x += xVel;
        hitX += xVel;
        if (level.checkWall(this) == true){
            x -= xVel;
            hitX -= xVel;

        }
        
        y += yVel;
        hitY += yVel;
        if (level.checkWall(this) == true){
            y -= yVel;
            hitY -= yVel;

        }   
    }
}
