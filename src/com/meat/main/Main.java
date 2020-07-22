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

    JTextField tf1, tf2, tf3, tf4;

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


        JFrame frame = new JFrame("Click-a-tron");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myPanel = frame.getContentPane();

        frame.setSize(600, 600);

        GroupLayout groupLayout = new GroupLayout(myPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        myPanel.setLayout(groupLayout);


        button = new JButton("Start");
        check = new JCheckBox("Infinite");
        tf1 = new JTextField(trigger);
        JLabel label1 = new JLabel("Trigger: ");

        tf2 = new JTextField(delay);
        JLabel label2 = new JLabel("Delay: ");

        tf3 = new JTextField(key);
        JLabel label3 = new JLabel("Key to click: ");

        tf4 = new JTextField(clicks);
        JLabel label4 = new JLabel("Click Num: ");


        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(button)
                        .addComponent(label1).addComponent(label2).addComponent(label3).addComponent(label4))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(tf1)
                        .addComponent(tf2).addComponent(tf3).addComponent(tf4).addComponent(check)));
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(tf1).addComponent(label1))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2).addComponent(tf2))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label3).addComponent(tf3))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label4).addComponent(tf4).addComponent(check)));


        button.setActionCommand("btn1");
        check.setActionCommand("chk");
        tf1.setActionCommand("text1");
        tf2.setActionCommand("text1");
        tf3.setActionCommand("text1");
        tf4.setActionCommand("text1");

        button.addActionListener((ActionListener) this);
        check.addActionListener((ActionListener) this);
        tf1.addActionListener((ActionListener) this);
        tf2.addActionListener((ActionListener) this);
        tf3.addActionListener((ActionListener) this);
        tf4.addActionListener((ActionListener) this);

        tf1.setText(Integer.toString(trigger));
        tf2.setText(Integer.toString(delay));
        tf3.setText(Integer.toString(key));
        tf4.setText(Integer.toString(clicks));

        button.setBackground(Color.green);

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
                    stTrigger();
                    stClicks();
                    stKey();
                    stDelay();
                    clicking();
                    state = true;
                    button.setBackground(Color.green);
                    button.setText("Start");
                } else {
                    button.setBackground(Color.green);
                    button.setText("Start");
                    state = true;
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

    /*
    public int getKeyEvent(final KeyEvent ev) {
        return ev.getKeyCode();
    }

    public void coords() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
    }
*/

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public void stTrigger() {
        System.out.println(trigger);
        trigger = InputEvent.BUTTON1_MASK;
    }

    public void stDelay() {
        String num = tf2.getText();
        System.out.println(num);

        if (isNumeric(num)) {
            delay = Integer.parseInt(num);
            clicker.setDelay(delay);
        }
    }

    public void stKey() {
        System.out.println(key);
        key = InputEvent.BUTTON1_MASK;
    }

    public void stClicks() {
        String num = tf4.getText();
        System.out.println(num);

        if (isNumeric(num)) {
            clicks = Integer.parseInt(num);
        }
    }


    public void clicking() {
        if (!state) {
            for (int i = 0; !(i == clicks); i++) {
                clicker.clickMouse(key);
                System.out.println("clicking");
            }
            System.out.println("done");
        }
    }

}
