package org.example.util;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyboardUtil {
    public Robot robot;
    public KeyboardUtil(Robot robot){
        this.robot = robot;
    }

    public void teleport(String directionWord,int time){

        try{
            if(directionWord.equalsIgnoreCase("UP")){
                pressKey("UP");
                pressKey("PAGE_DOWN");
                Thread.sleep(time);
                releaseKey("PAGE_DOWN");
                releaseKey("UP");

            }else if (directionWord.equalsIgnoreCase("DOWN")){
                pressKey("DOWN");
                pressKey("PAGE_DOWN");
                Thread.sleep(time);
                releaseKey("PAGE_DOWN");
                releaseKey("DOWN");
            }else if (directionWord.equalsIgnoreCase("LEFT")){
                pressKey("LEFT");
                pressKey("PAGE_DOWN");
                Thread.sleep(time);
                releaseKey("PAGE_DOWN");
                releaseKey("LEFT");
            }else if (directionWord.equalsIgnoreCase("RIGHT")){
                pressKey("RIGHT");
                pressKey("PAGE_DOWN");
                Thread.sleep(time);
                releaseKey("PAGE_DOWN");
                releaseKey("RIGHT");
            }
        }catch (Exception e) {
            System.err.println("teleport error");
            e.printStackTrace();
        }
    }

    public void move(String directionWord, int time){

        try{
            if(directionWord.equalsIgnoreCase("LEFT")){
                pressKey("LEFT");
                Thread.sleep(time);
                releaseKey("LEFT");

            }else if (directionWord.equalsIgnoreCase("RIGHT")){
                pressKey("RIGHT");
                Thread.sleep(time);
                releaseKey("RIGHT");
            }
        }catch (Exception e) {
            System.err.println("teleport error");
            e.printStackTrace();
        }
    }


    public void click(int x , int y ){
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void pressKey(String key) {
        int keyCode = getKeyCode(key);
        robot.keyPress(keyCode);
    }

    public void releaseKey(String key) {
        int keyCode = getKeyCode(key);
        robot.keyRelease(keyCode);
    }

    public void jump(){
        int keyCode = getKeyCode("ALT");
        robot.keyRelease(keyCode);
    }
    public int getKeyCode(String key) {
        switch (key.toUpperCase()) {
            case "A":
                return KeyEvent.VK_A;
            case "B":
                return KeyEvent.VK_B;
            case "SHIFT":
                return KeyEvent.VK_SHIFT;
            case "CTRL":
                return KeyEvent.VK_CONTROL;
            case "ALT":
                return KeyEvent.VK_ALT;
            case "DOWN":
                return KeyEvent.VK_DOWN;
            case "UP":
                return KeyEvent.VK_UP;
            case "LEFT":
                return KeyEvent.VK_LEFT;
            case "RIGHT":
                return KeyEvent.VK_RIGHT;
            case "PAGE_DOWN":
                return KeyEvent.VK_PAGE_DOWN;
            case "END":
                return KeyEvent.VK_END;
            case "HOME":
                return KeyEvent.VK_HOME;
            case "INSERT":
                return KeyEvent.VK_INSERT;
            case "PAGE_UP":
                return KeyEvent.VK_PAGE_UP;
            case "DELETE":
                return KeyEvent.VK_DELETE;


            // 다른 키들도 필요에 따라 추가하세요.
            default:
                return KeyEvent.getExtendedKeyCodeForChar(key.charAt(0));
        }
    }
}
