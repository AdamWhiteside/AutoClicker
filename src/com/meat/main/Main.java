package com.meat.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        System.out.println("hey");
        new Main();
    }



    //JFrame
    private Main(){
    JFrame f = new JFrame();
    f.setSize(600, 600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(true);
    f.setVisible(true);
f.setLayout(new FlowLayout());

    JButton button = new JButton("Set Trigger");
    f.add(button);
}


}
