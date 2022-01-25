package finalproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Levels extends JFrame {
    BulletBox menu;
    
    public Levels(BulletBox m) {
        initUI();
        menu = m;
    }

    private void initUI() { 
        add(new Board());

        setTitle("Bullet Box");
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
