package com.meat.main;

import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {

    //clicks = number of clicks
    //delay = delay between clicks
    //key = key to click
    //trigger = trigger to start/stop clicks

    boolean state = true;
    String trigger = "`";
    JButton button;
    static int key;

    //main
    public static void main(String[] args) {
        new Main();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter num clicks");
        int clicks = scanner.nextInt();

        System.out.println("enter delay");
        int delay = scanner.nextInt();

        System.out.println("enter key");
        key = InputEvent.BUTTON1_MASK;

        //delay the start while program is loading
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AutoClicker clicker = new AutoClicker();
        clicker.setDelay(delay);

        //clicking action
        for (int i = 0; i < clicks; i++) {
clicker.clickMouse(key);
        }

        System.out.println("done");

    }


    //JFrame
    private Main() {

        JFrame frame = new JFrame("GroupLayoutExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myPanel = frame.getContentPane();

        frame.setSize(600, 600);

        GroupLayout groupLayout = new GroupLayout(myPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        myPanel.setLayout(groupLayout);


        button = new JButton("Start");
        JButton button2 = new JButton("Set Trigger");
        JLabel label1 = new JLabel("Trigger: " + trigger);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(button).addComponent(label1))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(button2)));

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button).addComponent(button2))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1)));

        button.setActionCommand("btn1");
        button2.setActionCommand("btn2");

        button.addActionListener((ActionListener) this);
        button2.addActionListener((ActionListener) this);

        button.setBackground(Color.green);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        switch (name) {
            case "btn1":
                if (state) {
                    button.setBackground(Color.red);
                    button.setText("Stop");
                    state = false;
                } else {
                    button.setBackground(Color.green);
                    button.setText("Start");
                    state = true;
                }
                break;

            case "btn2":
                System.out.println("enter key");
                System.out.println("a");

                System.out.println("b");
                break;

        }

    }


}
