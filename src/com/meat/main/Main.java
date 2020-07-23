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
import java.awt.event.KeyEvent;

import static javafx.scene.input.KeyCode.getKeyCode;

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


    JButton button, button2, button3, button4, button5;
    JCheckBox check;
    int trigger = java.awt.event.KeyEvent.VK_A;
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

        tf1.setText(ConvertVKint(trigger));
        tf2.setText(Integer.toString(delay));
        tf3.setText(ConvertVKint(key));
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
                if (newClick) {
                    newClick = false;
                    clicks = -1;
                    tf4.setText(Integer.toString(clicks));
                } else {
                    newClick = true;
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

    public String ConvertVKint(int character) {
        switch (character) {
            case (java.awt.event.KeyEvent.VK_A):
                return "a";
            case (java.awt.event.KeyEvent.VK_B):
                return "b";
            case (java.awt.event.KeyEvent.VK_C):
                return "c";
            case (java.awt.event.KeyEvent.VK_D):
                return "d";
            case (java.awt.event.KeyEvent.VK_E):
                return "e";
            case (java.awt.event.KeyEvent.VK_F):
                return "f";
            case (java.awt.event.KeyEvent.VK_G):
                return "g";
            case (java.awt.event.KeyEvent.VK_H):
                return "h";
            case (java.awt.event.KeyEvent.VK_I):
                return "i";
            case (java.awt.event.KeyEvent.VK_J):
                return "j";
            case (java.awt.event.KeyEvent.VK_K):
                return "k";
            case (java.awt.event.KeyEvent.VK_L):
                return "l";
            case (java.awt.event.KeyEvent.VK_M):
                return "m";
            case (java.awt.event.KeyEvent.VK_N):
                return "n";
            case (java.awt.event.KeyEvent.VK_O):
                return "o";
            case (java.awt.event.KeyEvent.VK_P):
                return "p";
            case (java.awt.event.KeyEvent.VK_Q):
                return "q";
            case (java.awt.event.KeyEvent.VK_R):
                return "r";
            case (java.awt.event.KeyEvent.VK_S):
                return "s";
            case (java.awt.event.KeyEvent.VK_T):
                return "t";
            case (java.awt.event.KeyEvent.VK_U):
                return "u";
            case (java.awt.event.KeyEvent.VK_V):
                return "v";
            case (java.awt.event.KeyEvent.VK_W):
                return "w";
            case (java.awt.event.KeyEvent.VK_X):
                return "x";
            case (java.awt.event.KeyEvent.VK_Y):
                return "y";
            case (java.awt.event.KeyEvent.VK_Z):
                return "z";
            case (java.awt.event.KeyEvent.VK_BACK_QUOTE):
                return "`";
            case (java.awt.event.KeyEvent.VK_0):
                return "0";
            case (java.awt.event.KeyEvent.VK_1):
                return "1";
            case (java.awt.event.KeyEvent.VK_2):
                return "2";
            case (java.awt.event.KeyEvent.VK_3):
                return "3";
            case (java.awt.event.KeyEvent.VK_4):
                return "4";
            case (java.awt.event.KeyEvent.VK_5):
                return "5";
            case (java.awt.event.KeyEvent.VK_6):
                return "6";
            case (java.awt.event.KeyEvent.VK_7):
                return "7";
            case (java.awt.event.KeyEvent.VK_8):
                return "8";
            case (java.awt.event.KeyEvent.VK_9):
                return "9";
            case (java.awt.event.KeyEvent.VK_MINUS):
                return "-";
            case (java.awt.event.KeyEvent.VK_EQUALS):
                return "=";
            case (java.awt.event.KeyEvent.VK_EXCLAMATION_MARK):
                return "!";
            case (java.awt.event.KeyEvent.VK_AT):
                return "@";
            case (java.awt.event.KeyEvent.VK_NUMBER_SIGN):
                return "#";
            case (java.awt.event.KeyEvent.VK_DOLLAR):
                return "$";
            case (java.awt.event.KeyEvent.VK_CIRCUMFLEX):
                return "^";
            case (java.awt.event.KeyEvent.VK_AMPERSAND):
                return "&";
            case (java.awt.event.KeyEvent.VK_ASTERISK):
                return "*";
            case (java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS):
                return "(";
            case (java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS):
                return ")";
            case (java.awt.event.KeyEvent.VK_UNDERSCORE):
                return "_";
            case (java.awt.event.KeyEvent.VK_PLUS):
                return "+";
            case (java.awt.event.KeyEvent.VK_TAB):
                return "\t";
            case (java.awt.event.KeyEvent.VK_ENTER):
                return "\n";
            case (java.awt.event.KeyEvent.VK_OPEN_BRACKET):
                return "[";
            case (java.awt.event.KeyEvent.VK_CLOSE_BRACKET):
                return "]";
            case (java.awt.event.KeyEvent.VK_BACK_SLASH):
                return "\\";
            case (java.awt.event.KeyEvent.VK_SEMICOLON):
                return ";";
            case (java.awt.event.KeyEvent.VK_COLON):
                return ":";
            case (java.awt.event.KeyEvent.VK_QUOTE):
                return "'";
            case (java.awt.event.KeyEvent.VK_QUOTEDBL):
                return "\"";
            case (java.awt.event.KeyEvent.VK_COMMA):
                return ",";
            case (java.awt.event.KeyEvent.VK_PERIOD):
                return ".";
            case (java.awt.event.KeyEvent.VK_SLASH):
                return "/";
            case InputEvent.BUTTON1_MASK:
                return "Lmb";
            case InputEvent.BUTTON2_MASK:
                return "Mmb";
            case InputEvent.BUTTON3_MASK:
                return "Rmb";
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    public int ConvertVK(String character) {
        switch (character) {
            case "a":
                return (java.awt.event.KeyEvent.VK_A);
            case "b":
                return (java.awt.event.KeyEvent.VK_B);
            case "c":
                return (java.awt.event.KeyEvent.VK_C);
            case "d":
                return (java.awt.event.KeyEvent.VK_D);
            case "e":
                return (java.awt.event.KeyEvent.VK_E);
            case "f":
                return (java.awt.event.KeyEvent.VK_F);
            case "g":
                return (java.awt.event.KeyEvent.VK_G);
            case "h":
                return (java.awt.event.KeyEvent.VK_H);
            case "i":
                return (java.awt.event.KeyEvent.VK_I);
            case "j":
                return (java.awt.event.KeyEvent.VK_J);
            case "k":
                return (java.awt.event.KeyEvent.VK_K);
            case "l":
                return (java.awt.event.KeyEvent.VK_L);
            case "m":
                return (java.awt.event.KeyEvent.VK_M);
            case "n":
                return (java.awt.event.KeyEvent.VK_N);
            case "o":
                return (java.awt.event.KeyEvent.VK_O);
            case "p":
                return (java.awt.event.KeyEvent.VK_P);
            case "q":
                return (java.awt.event.KeyEvent.VK_Q);
            case "r":
                return (java.awt.event.KeyEvent.VK_R);
            case "s":
                return (java.awt.event.KeyEvent.VK_S);
            case "t":
                return (java.awt.event.KeyEvent.VK_T);
            case "u":
                return (java.awt.event.KeyEvent.VK_U);
            case "v":
                return (java.awt.event.KeyEvent.VK_V);
            case "w":
                return (java.awt.event.KeyEvent.VK_W);
            case "x":
                return (java.awt.event.KeyEvent.VK_X);
            case "y":
                return (java.awt.event.KeyEvent.VK_Y);
            case "z":
                return (java.awt.event.KeyEvent.VK_Z);
            case "A":
                return (java.awt.event.KeyEvent.VK_A);
            case "B":
                return (java.awt.event.KeyEvent.VK_B);
            case "C":
                return (java.awt.event.KeyEvent.VK_C);
            case "D":
                return (java.awt.event.KeyEvent.VK_D);
            case "E":
                return (java.awt.event.KeyEvent.VK_E);
            case "F":
                return (java.awt.event.KeyEvent.VK_F);
            case "G":
                return (java.awt.event.KeyEvent.VK_G);
            case "H":
                return (java.awt.event.KeyEvent.VK_H);
            case "I":
                return (java.awt.event.KeyEvent.VK_I);
            case "J":
                return (java.awt.event.KeyEvent.VK_J);
            case "K":
                return (java.awt.event.KeyEvent.VK_K);
            case "L":
                return (java.awt.event.KeyEvent.VK_L);
            case "M":
                return (java.awt.event.KeyEvent.VK_M);
            case "N":
                return (java.awt.event.KeyEvent.VK_N);
            case "O":
                return (java.awt.event.KeyEvent.VK_O);
            case "P":
                return (java.awt.event.KeyEvent.VK_P);
            case "Q":
                return (java.awt.event.KeyEvent.VK_Q);
            case "R":
                return (java.awt.event.KeyEvent.VK_R);
            case "S":
                return (java.awt.event.KeyEvent.VK_S);
            case "T":
                return (java.awt.event.KeyEvent.VK_T);
            case "U":
                return (java.awt.event.KeyEvent.VK_U);
            case "V":
                return (java.awt.event.KeyEvent.VK_V);
            case "W":
                return (java.awt.event.KeyEvent.VK_W);
            case "X":
                return (java.awt.event.KeyEvent.VK_X);
            case "Y":
                return (java.awt.event.KeyEvent.VK_Y);
            case "Z":
                return (java.awt.event.KeyEvent.VK_Z);
            case "`":
                return (java.awt.event.KeyEvent.VK_BACK_QUOTE);
            case "0":
                return (java.awt.event.KeyEvent.VK_0);
            case "1":
                return (java.awt.event.KeyEvent.VK_1);
            case "2":
                return (java.awt.event.KeyEvent.VK_2);
            case "3":
                return (java.awt.event.KeyEvent.VK_3);
            case "4":
                return (java.awt.event.KeyEvent.VK_4);
            case "5":
                return (java.awt.event.KeyEvent.VK_5);
            case "6":
                return (java.awt.event.KeyEvent.VK_6);
            case "7":
                return (java.awt.event.KeyEvent.VK_7);
            case "8":
                return (java.awt.event.KeyEvent.VK_8);
            case "9":
                return (java.awt.event.KeyEvent.VK_9);
            case "-":
                return (java.awt.event.KeyEvent.VK_MINUS);
            case "=":
                return (java.awt.event.KeyEvent.VK_EQUALS);
            case "!":
                return (java.awt.event.KeyEvent.VK_EXCLAMATION_MARK);
            case "@":
                return (java.awt.event.KeyEvent.VK_AT);
            case "#":
                return (java.awt.event.KeyEvent.VK_NUMBER_SIGN);
            case "$":
                return (java.awt.event.KeyEvent.VK_DOLLAR);
            case "^":
                return (java.awt.event.KeyEvent.VK_CIRCUMFLEX);
            case "&":
                return (java.awt.event.KeyEvent.VK_AMPERSAND);
            case "*":
                return (java.awt.event.KeyEvent.VK_ASTERISK);
            case "(":
                return (java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS);
            case ")":
                return (java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS);
            case "_":
                return (java.awt.event.KeyEvent.VK_UNDERSCORE);
            case "+":
                return (java.awt.event.KeyEvent.VK_PLUS);
            case "\t":
                return (java.awt.event.KeyEvent.VK_TAB);
            case "\n":
                return (java.awt.event.KeyEvent.VK_ENTER);
            case "[":
                return (java.awt.event.KeyEvent.VK_OPEN_BRACKET);
            case "]":
                return (java.awt.event.KeyEvent.VK_CLOSE_BRACKET);
            case "\\":
                return (java.awt.event.KeyEvent.VK_BACK_SLASH);
            case ";":
                return (java.awt.event.KeyEvent.VK_SEMICOLON);
            case ":":
                return (java.awt.event.KeyEvent.VK_COLON);
            case "\"":
                return (java.awt.event.KeyEvent.VK_QUOTE);
            case "'":
                return (java.awt.event.KeyEvent.VK_QUOTEDBL);
            case ",":
                return (java.awt.event.KeyEvent.VK_COMMA);
            case ".":
                return (java.awt.event.KeyEvent.VK_PERIOD);
            case "/":
                return (java.awt.event.KeyEvent.VK_SLASH);
            case "Lmb":
                return InputEvent.BUTTON1_MASK;
            case "Mmb":
                return InputEvent.BUTTON2_MASK;
            case "Rmb":
                return InputEvent.BUTTON3_MASK;
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

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
        trigger = ConvertVK(tf1.getText());
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
        key = ConvertVK(tf3.getText());
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
                if (key == InputEvent.BUTTON1_MASK || key == InputEvent.BUTTON2_MASK || key == InputEvent.BUTTON3_MASK) {
                    clicker.clickMouse(key);
                    System.out.println("clicking");
                } else {
                    clicker.pressKey(key);
                    System.out.println("pressing");
                }
            }
            System.out.println("done");
        }
    }

}
