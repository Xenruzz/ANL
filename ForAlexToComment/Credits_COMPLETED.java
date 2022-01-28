//Alex, Lado, Nathan
//January 27 2022
//Credits screen

package com.company.Sprites;

import static finalproject.GameWindow.menu;
import static finalproject.BulletBox.level;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Credits extends JFrame implements ActionListener {
    
    private BufferedImage image;
    private JButton home;

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
            //invoke super method
            super.paintComponent(g);
            //draw the image
            g.drawImage(image, 0, 0, this);
        }
    }

    /**
     * Primary Constructor
     * @param m - the BulletBox object
     */
    public Credits(BulletBox m) {
        //start UI
        initUI();
        //set the menu to m
        menu = m;
    }

    /**
     * Create UI
     */
    private void initUI() {
        try { //try to get image
            image = ImageIO.read(new File("src/finalproject/credits.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //set background image
        JFrame.setDefaultLookAndFeelDecorated(true);
        setContentPane(new Credits.ImagePanel(image));

        //get image icon
        ImageIcon iconHome = new ImageIcon("src/finalproject/homeButton.jpg");
        //get the image from the icon
        Image img1 = iconHome.getImage();
        //resize image icon
        Image newimg1 = img1.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
        //get image home image
        iconHome = new ImageIcon(newimg1);
        //create home button
        home = new JButton(iconHome);
        //set home button background to black
        home.setBackground(Color.BLACK);
        //set home button to be opaque
        home.setOpaque(true);
        //add actionlistener to homebutton
        home.addActionListener(this);
        //set bounds for home button
        home.setBounds(300, 270, 200, 50);
        //add home to JFrame
        add(home);
        pack();
        //set title
        setTitle("Bullet Box");
        //set dimensions
        setSize(800, 600);
        //set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * ActionEvent listener
     * @param e the ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            //if menu does not exit
            if (menu == null) {
                //create new menu
                menu = new BulletBox();
            }
            //set menu to visible
            menu.setVisible(true);
            //hide this window
            this.dispose();
        }
    }
}
