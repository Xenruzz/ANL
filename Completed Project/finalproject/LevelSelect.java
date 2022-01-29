//Alex, Lado, Nathan
//January 27 2022
//Level select class
//Creates the level selection screen

package finalproject;

import static finalproject.GameWindow.menu;
import static finalproject.BulletBox.level;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LevelSelect extends JFrame implements ActionListener {

    /**
     * Priamry constructor
     * @param m - the bulletbox menu
     */
    public LevelSelect(BulletBox m) {
        initUI();   
        menu = m;
    }

    /**
     * Create UI
     */
    private void initUI() {
        //set the look
        JFrame.setDefaultLookAndFeelDecorated(true);

        //create new panel
        JPanel panel = new JPanel();
        //set to box layout
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(200, 350, 0, 0)));
        //set title Level select
        panel.setBorder(BorderFactory.createTitledBorder("Level Select"));
        //set background white
        panel.setBackground(Color.WHITE);
        
        //make the main buttons
        JButton button1 = new JButton("Level 1");
        JButton button2 = new JButton("Level 2");
        JButton button3 = new JButton("Level 3");
        JButton button4 = new JButton("Back");
        
        //set fonts and formatting for button text
        button1.setFont(new Font("Serif", Font.BOLD, 40));
        button2.setFont(new Font("Serif", Font.BOLD, 40));
        button3.setFont(new Font("Serif", Font.BOLD, 40));
        button4.setFont(new Font("Serif", Font.BOLD, 40));
        
        //set action listeners for buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        
        //add buttons to the frame
        //with spaces
        panel.add(Box.createRigidArea(new Dimension(0,30)));
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0,30)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(0,30)));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(0,200)));
        panel.add(button4);
        
        //add menu panel to frame, and make frame
        add(panel);
        pack();
        setVisible(true);
        setTitle("Bullet Box");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set size of window and title of title
        setTitle("Bullet Box");
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Listens for actions
     * @param ae - the ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Level 1")) {
            level = new GameWindow(menu, this, 1);
            //set the other window to be visible
            level.setVisible(true);
            //get rid of this window
            dispose();
        }
        if (action.equals("Level 2")) {
            level = new GameWindow(menu, this, 2);
            //set the other window to be visible
            level.setVisible(true);
            //get rid of this window
            dispose();
        }
        if (action.equals("Level 3")) {
            level = new GameWindow(menu, this, 3);
            //set the other window to be visible
            level.setVisible(true);
            //get rid of this window
            dispose();
        } if (action.equals("Back")) {
            menu.setVisible(true);
            this.dispose();
        }
    }
}
