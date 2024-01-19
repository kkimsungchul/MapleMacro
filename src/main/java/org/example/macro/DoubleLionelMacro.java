package org.example.macro;

import org.example.util.KeyboardUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoubleLionelMacro {

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
    public static void stopDoubleLionelMacro(JLabel label){
        isThreadRunning = false;
        System.out.println("## doubleLionelThread stop");
        label.setText("라이오넬 매크로 정지중");
    }

    public static void startDoubleLionelMacro(JLabel label){
        isThreadRunning = true;
        label.setText("더블 라이오넬 매크로 사용중");
        doubleLionelThread();
    }

    public static void doubleLionelThread(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                System.out.println("## doubleLionelThread run");
                java.util.List<String> buffList = new ArrayList();
                buffList.add("END");
                buffList.add("HOME");
                buffList.add("INSERT");
                buffList.add("DELETE");
                int count =0;
                Thread.sleep(1000);
                while (isThreadRunning) {
                    keyboardUtil.teleport("LEFT",1300);
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    keyboardUtil.pressKey("ART");
                    keyboardUtil.releaseKey("ART");
                    Thread.sleep(100);
                    keyboardUtil.click(83,166);
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
                    Thread.sleep(100);
                    keyboardUtil.click(21,991);
                    keyboardUtil.teleport("RIGHT",1500);
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    keyboardUtil.pressKey("ART");
                    keyboardUtil.releaseKey("ART");
                    Thread.sleep(3000);
                    count++;
                    if(count>20){
                        for(String buffName : buffList){
                            keyboardUtil.click(83,166);
                            keyboardUtil.pressKey(buffName);
                            keyboardUtil.releaseKey(buffName);
                            Thread.sleep(1000);
                            keyboardUtil.click(21,991);
                            keyboardUtil.pressKey(buffName);
                            keyboardUtil.releaseKey(buffName);
                            Thread.sleep(1000);
                        }
                        count=0;
                    }

//                    keyboardUtil.teleport("RIGHT",1000);
//                    keyboardUtil.pressKey("A");
//                    keyboardUtil.releaseKey("A");
//                    Thread.sleep(3000);
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

