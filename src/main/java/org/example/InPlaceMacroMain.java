package org.example;
import java.awt.*;
import java.awt.event.KeyEvent;

public class InPlaceMacroMain {
    static Robot robot;
    public static void main(String[] args) {

        try {
            robot = new Robot();
            try {

                Thread genesisThread = new Thread(() -> {
                    try {
                        while(true){
                            pressKey("A");
                            releaseKey("A");
                            Thread.sleep(20050);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });



                // 각 스레드 시작
                genesisThread.start();
                genesisThread.join();


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

