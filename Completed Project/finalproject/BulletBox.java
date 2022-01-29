//Alex, Lado, Nathan
//January 27 2022
//Main class for the game
//Runs the JFrames
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class BulletBox extends JFrame implements ActionListener {

    public static GameWindow level;
    public static LevelSelect levels;
    public static Credits credits;
    private static final long serialVersionUID = 1L;

    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;

    private BufferedImage image;
    
    /**
     * Class to run a background image for a JFrame
     */
    class ImagePanel extends JComponent {

        private final Image image;
        
         /**
         * Primary Constructor for an Image Panel
         * @param image - the image to be set to
         */
        public ImagePanel(Image image) {
            this.image = image;
        }

        /**
         * Paint the component
         * @param g - the graphics to paint with
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //invoke the super method
            g.drawImage(image, 0, 0, this); //draw the image
        }
    }
    
    /**
     * Main class for the Game
     */
    public BulletBox() {
        //read background image
        try {
            image = ImageIO.read(new File("src/finalproject/mainmenu.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //set background image
        setContentPane(new ImagePanel(image));
        //get button images
        ImageIcon iconPlay = new ImageIcon("src/finalproject/playBtn.png");
        ImageIcon iconQuit = new ImageIcon("src/finalproject/exitBtn.jpg");
        ImageIcon iconTutorial = new ImageIcon("src/finalproject/tutorialBtn.png");
        ImageIcon iconCredits = new ImageIcon("src/finalproject/creditsBtn.png");

        Image img1 = iconPlay.getImage();
        Image img2 = iconQuit.getImage();
        Image img3 = iconTutorial.getImage();
        Image img4 = iconCredits.getImage();
        
        //Scale the images
        Image newimg1 = img1.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
        Image newimg2 = img2.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
        Image newimg3 = img3.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
        Image newimg4 = img4.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
        //Sets icons to scaled images
        iconPlay = new ImageIcon(newimg1);
        iconQuit = new ImageIcon(newimg2);
        iconTutorial = new ImageIcon(newimg3);
        iconCredits = new ImageIcon(newimg4);
        //make the main buttons
        button1 = new JButton(iconPlay);
        button2 = new JButton(iconTutorial);
        button3 = new JButton(iconQuit);
        button4 = new JButton(iconCredits);

        button1.setBackground(Color.BLACK);
        button1.setOpaque(true);
        button2.setBackground(Color.BLACK);
        button2.setOpaque(true);
        button3.setBackground(Color.BLACK);
        button3.setOpaque(true);
        button4.setBackground(Color.BLACK);
        button4.setOpaque(true);

        //set action listeners for buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        //add buttons to the frame in specified positions
        button1.setBounds(300, 260, 200, 50);
        button2.setBounds(300, 340, 200, 50);
        button3.setBounds(300, 420, 200, 50);
        button4.setBounds(300, 500, 200, 50);
        add(button1);
        add(button2);
        add(button3);
        add(button4);

        //make frame
        pack();
        setVisible(true);
        setTitle("Bullet Box");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

      /**
     * Check action listener for events
     * @param ae - the ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {
            //check if the second window
            //has already been created
            if (levels == null) {
                levels = new LevelSelect(this);
            }
            //set the other window to be visible
            levels.setVisible(true);
            //get rid of this window
            dispose();
        } else if (ae.getSource() == button3) {
            System.exit(0);
        } else if (ae.getSource() == button2) {
            level = new GameWindow(this, levels, 0);
            //set the other window to be visible
            level.setVisible(true);
            //get rid of this window
            dispose();
        } else if (ae.getSource() == button4) {
            //check if the second window
            //has already been created
            if (credits == null) {
                credits = new Credits(this);
            }
            //set the other window to be visible
            credits.setVisible(true);
            //get rid of this window
            dispose();
        }
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BulletBox();
            }
        });
    }

}

