package org.example.macro;

import org.example.util.KeyboardUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LionelMacro {

    static boolean isThreadRunning = false;
    static KeyboardUtil keyboardUtil = null;

    public static void initLionelMacroClass(){
        try{
            Robot robot = new Robot();
            keyboardUtil = new KeyboardUtil(robot);
        }catch (Exception e){
            System.out.println("## RedNoseMacro init error");
            e.printStackTrace();
        }
    }


    public static void startLionelMacro(JLabel label){
        isThreadRunning = true;
        label.setText("라이오넬 매크로 사용중");
        teleportThread();
        //genesisThread();
        //buffThread();
    }

    public static void stopLionelMacro(JLabel label){
        isThreadRunning = false;
        label.setText("라이오넬 매크로 정지중");
    }
    public static void teleportThread(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // 백그라운드에서 실행되는 작업
                java.util.List<String> buffList = new ArrayList();
                int count =0;
                while (isThreadRunning) {
                    keyboardUtil.teleport("LEFT",1300);
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    keyboardUtil.pressKey("ART");
                    keyboardUtil.releaseKey("ART");
                    Thread.sleep(3000);
                    keyboardUtil.teleport("RIGHT",1500);
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    keyboardUtil.pressKey("ART");
                    keyboardUtil.releaseKey("ART");

                    count++;
                    if(count>20){
                        for(String buffName : buffList){
                            keyboardUtil.pressKey(buffName);
                            keyboardUtil.releaseKey(buffName);
                            Thread.sleep(2000);
                        }
                        count=0;
                    }
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
                    Thread.sleep(500);
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
                    keyboardUtil.pressKey("DELETE");
                    keyboardUtil.releaseKey("DELETE");
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
