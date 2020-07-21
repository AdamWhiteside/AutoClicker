package com.meat.main;

import java.awt.Robot;

public class AutoClicker {

    private Robot robot;

    private int delay;

    public AutoClicker() {

        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        delay = 300;
    }

    //clicks mouse takes in button to click
    public void clickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(250);
            robot.mouseRelease(button);
            robot.delay(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //sets the delay between clicks
    public void setDelay(int delay) {
        if (delay > 0) {
            this.delay = delay;
        }
    }
}
