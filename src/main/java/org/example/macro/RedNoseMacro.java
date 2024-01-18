package org.example.macro;

import org.example.util.KeyboardUtil;

import javax.swing.*;
import java.awt.*;

public class RedNoseMacro {

    static boolean isThreadRunning = false;
    static KeyboardUtil keyboardUtil = null;

    public static void initRedNoseMacroClass(){
        try{
            Robot robot = new Robot();
            keyboardUtil = new KeyboardUtil(robot);
        }catch (Exception e){
            System.out.println("## RedNoseMacro init error");
            e.printStackTrace();
        }
    }


    public static void startRedNoseMacro(JLabel label){
        isThreadRunning = true;
        label.setText("빨간코 매크로 사용중");
        teleportThread();
        genesisThread();
        buffThread();
    }

    public static void stopRedNoseMacro(JLabel label){
        isThreadRunning = false;
        label.setText("빨간코 매크로 정지중");
    }
    public static void teleportThread(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // 백그라운드에서 실행되는 작업
                while (isThreadRunning) {
                    // 예시: 1초마다 레이블 업데이트
                    keyboardUtil.move("LEFT",5000);
                    keyboardUtil.move("RIGHT",7000);
                }
                return null;
            }
            @Override
            protected void done() {
                // 스레드 종료 후에 실행되는 작업
            }
        };
        worker.execute();
    }
    public static void genesisThread(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (isThreadRunning) {
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    Thread.sleep(3500);
                }
                return null;
            }
            @Override
            protected void done() {
                // 스레드 종료 후에 실행되는 작업
            }
        };
        worker.execute();
    }
    public static void buffThread(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // 백그라운드에서 실행되는 작업
                while (isThreadRunning) {
                    keyboardUtil.pressKey("END");
                    keyboardUtil.releaseKey("END");
                    Thread.sleep(500);
                    keyboardUtil.pressKey("HOME");
                    keyboardUtil.releaseKey("HOME");
                    Thread.sleep(500);
                    keyboardUtil.pressKey("DELETE");
                    keyboardUtil.releaseKey("DELETE");
                    Thread.sleep(60000);
                }
                return null;
            }
            @Override
            protected void done() {
                // 스레드 종료 후에 실행되는 작업
            }
        };
        worker.execute();
    }

    
}
