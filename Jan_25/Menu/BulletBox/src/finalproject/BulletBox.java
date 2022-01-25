package finalproject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BulletBox extends JFrame implements ActionListener {

    private Levels level;
    private static final long serialVersionUID = 1L;

    public BulletBox() {

        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());

        JButton button1 = new JButton("Play");
        JButton button2 = new JButton("Exit");

        //set action listeners for buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        
        //add buttons to the frame
        add(button1);
        add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Play")) {
            //check if the second window
            //has already been created
            if (level == null) {
                level = new Levels(this);
            }
            //set the other window to be visible
            level.setVisible(true);
            //hide this window
            this.setVisible(false);
        } else if (action.equals("Exit")) {
            System.exit(0);
        }
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new BulletBox();
        //Display the window.
        frame.pack();
        frame.setTitle("Bullet Box");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
