package com.company;

import java.awt.EventQueue;
import javax.swing.*;

public class BulletBox extends JFrame {

    public BulletBox() {
        initUI();

    }

    private void initUI() {

        add(new Board());

        setTitle("Bullet Box");
        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new BulletBox();
            ex.setVisible(true);
        });
    }
}
