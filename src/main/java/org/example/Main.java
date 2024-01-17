package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Robot robot;
    public static void main(String[] args) {


        List<String> macroList = new ArrayList<>();
        macroList.add("A");

        try {
            robot = new Robot();
            try {

                Thread teleportThread = new Thread(() -> {
                    try {
                        while(true){
                            move("LEFT");
                            move("RIGHT");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                Thread genesisThread = new Thread(() -> {
                    try {
                        while(true){
                            pressKey("A");
                            releaseKey("A");
                            Thread.sleep(3500);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                Thread buffThread = new Thread(() -> {
                    try {
                        while(true){
                            pressKey("END");
                            releaseKey("END");
                            Thread.sleep(500);
                            pressKey("HOME");
                            releaseKey("HOME");
                            Thread.sleep(60000);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });



                // 각 스레드 시작
                teleportThread.start();
                genesisThread.start();
                buffThread.start();

                // 메인 스레드는 아래의 스레드가 모두 종료될 때까지 대기
                teleportThread.join();
                genesisThread.join();
                buffThread.join();

                System.out.println("Both threads are finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void move(String directionWord){

        try{
            if(directionWord.equalsIgnoreCase("LEFT")){
                pressKey("LEFT");
                Thread.sleep(5000);
                releaseKey("LEFT");

            }else if (directionWord.equalsIgnoreCase("RIGHT")){
                pressKey("RIGHT");
                Thread.sleep(7000);
                releaseKey("RIGHT");
            }
        }catch (Exception e) {
            System.err.println("teleport error");
            e.printStackTrace();
        }
    }

    private static void teleport(String directionWord){

        try{
            if(directionWord.equalsIgnoreCase("UP")){
                pressKey("UP");
                pressKey("PAGE_DOWN");
                Thread.sleep(500);
                releaseKey("PAGE_DOWN");
                releaseKey("UP");

            }else if (directionWord.equalsIgnoreCase("DOWN")){
                pressKey("DOWN");
                pressKey("PAGE_DOWN");
                Thread.sleep(500);
                releaseKey("PAGE_DOWN");
                releaseKey("DOWN");
            }
        }catch (Exception e) {
            System.err.println("teleport error");
            e.printStackTrace();
        }
    }
    private static void pressKey(String key) {
        int keyCode = getKeyCode(key);
        robot.keyPress(keyCode);
    }

    private static void releaseKey(String key) {
        int keyCode = getKeyCode(key);
        robot.keyRelease(keyCode);
    }

    private static int getKeyCode(String key) {
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

            // 다른 키들도 필요에 따라 추가하세요.
            default:
                return KeyEvent.getExtendedKeyCodeForChar(key.charAt(0));
        }
    }


}