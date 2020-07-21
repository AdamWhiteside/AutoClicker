package com.meat.main;

import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.Thread;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {

    //clicks = number of clicks
    //delay = delay between clicks
    //key = key to click
    //trigger = trigger to start/stop clicks

    boolean state = true;
    boolean newClick = true;
    boolean newDelay = false;
    boolean newButton = false;
    boolean newTrigger = false;
    boolean inf = true;

    int trigger = InputEvent.BUTTON1_MASK;
    JButton button, button2, button3, button4, button5;
    JCheckBox check;
    static int key = InputEvent.BUTTON1_MASK;
    static int clicks = 10;
    static int delay = 10;
    AutoClicker clicker;
    Scanner scanner;

    //main
    public static void main(String[] args) {
        new Main();


    }


    //JFrame
    private Main() {
        scanner = new Scanner(System.in);


        JFrame frame = new JFrame("GroupLayoutExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myPanel = frame.getContentPane();

        frame.setSize(600, 600);

        GroupLayout groupLayout = new GroupLayout(myPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        myPanel.setLayout(groupLayout);


        button = new JButton("Start");
        button2 = new JButton("Trigger: " + trigger);
        button3 = new JButton("Delay: " + delay);
        button4 = new JButton("Click Key: " + key);
        button5 = new JButton("Click Num: " + clicks);
        check = new JCheckBox("Infinite");
        //JTextField tf1 = new JTextField("hey");
        //JLabel label1 = new JLabel("Trigger: " + trigger);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(button).addComponent(button3).addComponent(button4))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(button5).addComponent(button2))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(check)));
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button3).addComponent(button5).addComponent(check))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button4).addComponent(button2)));

        button.setActionCommand("btn1");
        button2.setActionCommand("btn2");
        button3.setActionCommand("btn3");
        button4.setActionCommand("btn4");
        button5.setActionCommand("btn5");
        check.setActionCommand("chk");


        button.addActionListener((ActionListener) this);
        button2.addActionListener((ActionListener) this);
        button3.addActionListener((ActionListener) this);
        button4.addActionListener((ActionListener) this);
        button5.addActionListener((ActionListener) this);
        check.addActionListener((ActionListener) this);

        button.setBackground(Color.green);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);

        frame.setVisible(true);

//clicker setup
        clicker = new AutoClicker();

        //delay the start while program is loading
        /*
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

        //clicking action
        //actions();
    }

    /*
    public void actions() {
        while (1 > 0) {

            stClicks();
            stDelay();
            stKey();
            stTrigger();
            clicking();
        }
    }

     */

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        switch (name) {
            case "btn1":
                if (state) {
                    button.setBackground(Color.red);
                    button.setText("Stop");
                    state = false;
                    clicking();
                } else {
                    button.setBackground(Color.green);
                    button.setText("Start");
                    state = true;
                }
                break;

            case "btn2":
                System.out.println("Set Trigger");
                stTrigger();
                    button2.setText("Trigger: " + trigger);
                break;

            case "btn3":
                System.out.println("Set Delay");
                stDelay();
                    button3.setText("Delay: " + delay);
                break;

            case "btn4":
                System.out.println("Set Click Key");
                stKey();
                    button4.setText("Click Key: " + key);
                break;

            case "btn5":
                System.out.println("Set Click Num");
                if (newClick) {
                    stClicks();
                    button5.setText("Click Num: " + clicks);
                }
                break;

            case "chk":
                System.out.println("enter key");
                if (newClick) {
                    newClick = false;
                    button5.setBackground(Color.gray);
                    button5.setText("Click Num: inf");
                    clicks = -1;
                } else {
                    newClick = true;
                    button5.setBackground(Color.white);
                }
                break;
        }

    }
/*
    public void keyPressCheck(){
        textField.addKeyListener(new KeyAdapter() {

              When you type the character "a" into the text field you will see
              an information dialog box

            public void keyTyped(KeyEvent ke) {
                char keyChar = ke.getKeyChar();
                if (keyChar == 'a') {
                    System.out.println("You typed 'a'");
                }
            }
    }
    */

    public int getKeyEvent(final KeyEvent ev){
        return ev.getKeyCode();
    }

    public void coords(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
    }

    public void stClicks() {
        if (newClick) {
            System.out.println("enter num clicks");
            clicks = scanner.nextInt();
        }
    }

    public void stTrigger() {
        if (newTrigger) {
            System.out.println("set trigger");
            trigger = InputEvent.BUTTON1_MASK;
        }
    }

    public void stDelay() {
        if (newDelay) {
            System.out.println("enter delay");
            delay = scanner.nextInt();
            clicker.setDelay(delay);
        }
    }

    public void stKey() {
        if (newButton) {
            System.out.println("enter key");
            key = InputEvent.BUTTON1_MASK;
        }
    }

    public void clicking() {
        if (!state) {
            for (int i = 0; i < clicks; i++) {
                clicker.clickMouse(key);
                System.out.println("clicking");
            }
            System.out.println("done");
            state = true;
        }
    }

}
