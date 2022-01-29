/* Alex, Lado, Nathan
 * January 23, 2022
 * The class the runs the actual game
 */
package finalproject;

import static finalproject.BulletBox.level;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
    private Timer timer;
    private Player God; //The player
    private Level currentLevel; //Keeps track of the current level
    public static BulletBox menu; 
    public static DeathWindow death;
    public static WinWindow win;
    private final int DELAY = 10;
    private BigInteger time; //Keeps track of the time it takes to complete a level
    private final BigInteger a = new BigInteger("1");
    private SaveData[] saves; //Array of saves

    
    
    /** Constructor
     * Creates a viewable game
     * @param level the level that is being played
     */
    public Game(int level) {
        try{
            if (level == 0){ //Sets the current level to the correct text files
                currentLevel = new Level(Entity.class.getResourceAsStream("level0.txt"), 0);
                saves = readSaveData(new FileInputStream(System.getProperty("user.dir") + "/saves/level0scores.txt"));

            } else if (level == 1) {
                currentLevel = new Level(Entity.class.getResourceAsStream("level1.txt"), 1);
                saves = readSaveData( new FileInputStream(System.getProperty("user.dir") + "/saves/level1scores.txt"));

            } else if (level == 2) {
                currentLevel = new Level(Entity.class.getResourceAsStream("level2.txt"), 2);
                saves = readSaveData( new FileInputStream(System.getProperty("user.dir") + "/saves/level2scores.txt"));

            } else {
                currentLevel = new Level(Entity.class.getResourceAsStream("level3.txt"), 3);
                saves = readSaveData( new FileInputStream(System.getProperty("user.dir") + "/saves/level3scores.txt"));

            }
      
        } catch (Exception e){
            System.out.println(e);
        }
        
        initBoard();
        
    }

    private void initBoard() {
        addKeyListener(new TAdapter()); //Adds a key listener
        setBackground(Color.black); //Sets the background to black
        setFocusable(true);
        
        
        timer = new Timer(DELAY, this);
        timer.start(); 
        time = new BigInteger("0"); //Sets the time to 0
        God = new Player(currentLevel.getSpawnX(), currentLevel.getSpawnY()); //Creates the player
        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            doDrawing(g); //Calls the do drawing method 
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    /** Do Drawing method
     * Draws the game
     * @param g the graphics to draw the game
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void doDrawing(Graphics g) throws FileNotFoundException, IOException {
        double arrowAngle;
        Projectile temp;
        Graphics2D g2d = (Graphics2D) g;
        //Loops through the entire 2D array of tiles
        for (int i = 0; i < currentLevel.getArrayWidth(); i++){
            for(int j = 0; j < currentLevel.getArrayHeight(); j++){
                //Draws the image of the tile
                g2d.drawImage(currentLevel.findTile(i,j).getImage(), ((int)currentLevel.findTile(i,j).getX()) - ((int)God.getX()) + 400, ((int)currentLevel.findTile(i,j).getY()) - ((int)God.getY()) + 300, this);
            } 
        }
        //Updates the enemies in the level
        currentLevel.updateEnemies(God);
        g2d.setColor(Color.red); //Sets the color to red
        
        for (int i = 0; i<currentLevel.getEnemyNumber(); i++){ //Loops through every enemy
            //Calculates the angle between the player and the enemy
            arrowAngle = Math.atan2( currentLevel.findEnemy(i).getY() + currentLevel.findEnemy(i).getH()/2 - God.getY() - God.getH()/2 ,  currentLevel.findEnemy(i).getX() + currentLevel.findEnemy(i).getW()/2 - God.getX() - God.getW()/2 );
            //Draws the enemy image
            g2d.drawImage(currentLevel.findEnemy(i).getImage(), (int)currentLevel.findEnemy(i).getX() - (int)God.getX() + 400, (int)currentLevel.findEnemy(i).getY() - (int)God.getY() + 300, this);
            //If the enemy is off the screen then an arrow is drawn pointing towards them
            if (Math.abs(God.getX() - currentLevel.findEnemy(i).getX()) > 400 || Math.abs(God.getY() - currentLevel.findEnemy(i).getY()) > 300){
                g2d.fillPolygon( new int[] {400 + God.getW()/2 + (int)(Math.cos(arrowAngle)*230),400 + God.getW()/2 + (int)(Math.cos(arrowAngle + Math.PI/72)*210),400 + God.getW()/2 + (int)(Math.cos(arrowAngle - Math.PI/72)*210)}, 
                        new int[] {300 + God.getH()/2 + (int)(Math.sin(arrowAngle)*230),300 + God.getH()/2 + (int)(Math.sin(arrowAngle + Math.PI/72)*210),300 + God.getH()/2 + (int)(Math.sin(arrowAngle - Math.PI/72)*210)}, 3);
            }
            
            for (int j = 0; j<currentLevel.findEnemy(i).getProjectileNumber(); j++){ //Loops through all the projectiles
                temp = currentLevel.findEnemy(i).findProjectile(j); //Finds every projectile and draws its image
                g2d.drawImage(temp.getImage(),(int)temp.getX() - (int)God.getX() + 400, (int)temp.getY() - (int)God.getY() + 300, this);

               
            }
        }
        
        int health = God.getHealth(); //Gets the players health
        for (int i = 0; i < health; i++) { //Draws an heart image for each health unit the player has
            g2d.drawImage(SpriteSheet.heart.getImage(), 50 + i * 50, 20, this);
        }
        
        //If the user loses all their health
        if (health <= 0) {
            if (death == null) {
                death = new DeathWindow(menu); //The death menu is set
            }
            level.dispose(); //This level is removed 
            death.setVisible(true);
            //get rid of this window
            remove(this);
        }
        
        g2d.setColor(Color.blue); //Sets the colour to blue
        //Draws the win tile square
        g2d.fillRect(currentLevel.getWinIndexX()*50 - (int)God.getX() + 400, currentLevel.getWinIndexY()*50 - (int)God.getY() + 300, Tile.TILESIZE, Tile.TILESIZE);
        arrowAngle = Math.atan2( currentLevel.getWinIndexY()*50 + Tile.TILESIZE/2 - God.getY() - God.getH()/2 ,  currentLevel.getWinIndexX()*50 + Tile.TILESIZE/2 - God.getX() - God.getW()/2 );
        //If the win tile is off the screen then a blue arrow is drawn pointing towards it
        if (Math.abs(God.getX() - currentLevel.getWinIndexX()*50) > 400 || Math.abs(God.getY() - currentLevel.getWinIndexY()*50) > 300){
        g2d.fillPolygon( new int[] {400 + God.getW()/2 + (int)(Math.cos(arrowAngle)*230),400 + God.getW()/2 + (int)(Math.cos(arrowAngle + Math.PI/72)*210),400 + God.getW()/2 + (int)(Math.cos(arrowAngle - Math.PI/72)*210)}, 
                        new int[] {300 + God.getH()/2 + (int)(Math.sin(arrowAngle)*230),300 + God.getH()/2 + (int)(Math.sin(arrowAngle + Math.PI/72)*210),300 + God.getH()/2 + (int)(Math.sin(arrowAngle - Math.PI/72)*210)}, 3);
        }
        
        g2d.drawImage(God.getImage(), 400, 300, this);//Draws the player image
        
        g2d.setColor(Color.white); //Sets the colour to white
        //If the current level is the tutorial level then this text is drawn
        if (currentLevel.getLevelNum() == 0 && God.getTextBox() == true){
            Font infoFont = new Font("TimesRoman", Font.BOLD, 20);
            g2d.setFont(infoFont);
            String str = "Use the arrow keys to move!";    
            g2d.drawString(str, 300 - str.length()*2, 200);  
            str = "Dodge the bullets shot from the enemies to survive!";
            g2d.drawString(str, 300 - str.length()*2, 216);
            str = "Get to the win tile without dying to win!";
            g2d.drawString(str, 300 - str.length()*2, 232);
            str = "If the win tile or enemies are offscreen an arrow will point out their direction!";
            g2d.drawString(str, 300 - str.length()*3, 248);
            str = "Good luck and have fun!";
            g2d.drawString(str, 300 - str.length()*2, 264);
            str = "Press Enter to make this text disappear!";
            g2d.drawString(str, 300 - str.length()*2, 280); 
        }
        
        if (currentLevel.checkWinTile(God) == true){//This checks if the player has reached the win tile
            
            //Calculates the users score
            time.divide(BigInteger.valueOf(100)).add(BigInteger.valueOf(5)).subtract(BigInteger.valueOf(God.getHealth())).multiply(BigInteger.valueOf(100));
            int score = Integer.parseInt(time.toString());
            level.dispose(); //This level is removed 
            win = new WinWindow(menu, saves, score, currentLevel.getLevelNum()); //The win menu is set
 
            win.setVisible(true); //Win screen is shown
            //get rid of this window
            remove(this);
        }
            
            
            
           
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step(); //Every time an action is performed this method is called
    }
    
    /** Step method
     * moves the player and redraws the screen
     */
    private void step() {
        God.move(currentLevel); //Moves the player
        repaint(0, 0, 800, 600); //Repaints the level     
        time = time.add(a); //Increases the time
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            God.keyReleased(e); //If a key is released the player is notified
        }

        @Override
        public void keyPressed(KeyEvent e) {
            God.keyPressed(e); //If a key is pressed the player is notified
        }
    } 
    
    public SaveData[] readSaveData(InputStream file){
        try{
        Scanner scanner = new Scanner(file); //Creates a scanner
        saves = new SaveData[scanner.nextInt() + 1]; //Initializes the 
        for(int i = 0; i<saves.length-1; i++){ //Loops through the entire file
            saves[i] = new SaveData(scanner.nextInt(), scanner.next()); //Adds the contents of the file to the array
        }
        } catch (Exception e){
            System.out.println(e);
        }
        return saves;
    }
    
    
}