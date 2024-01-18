package org.example.macro;

import org.example.util.KeyboardUtil;

import javax.swing.*;
import java.awt.*;

public class InPlaceMacro {

    volatile static boolean isThreadRunning = false;
    static KeyboardUtil keyboardUtil = null;

    public static void initInPlaceMacroClass(){
        try{
            Robot robot = new Robot();
            keyboardUtil = new KeyboardUtil(robot);
        }catch (Exception e){
            System.out.println("## InPlaceMacro init error");
            e.printStackTrace();
        }
    }


    public static void startInplaceMacro(JLabel label){
        isThreadRunning = true;
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception{
                // 백그라운드에서 실행되는 작업
                while (isThreadRunning) {
                    // 예시: 1초마다 레이블 업데이트
                    label.setText("제네시스 매크로 사용중");
                    keyboardUtil.pressKey("A");
                    keyboardUtil.releaseKey("A");
                    Thread.sleep(1000);
                }
                return null;
            }
            @Override
            protected void done() {
                // 스레드 종료 후에 실행되는 작업
                label.setText("제네시스 매크로 정지중");
            }
        };
        worker.execute();
    }

    public static void stopInplaceMacro(JLabel label){
        System.out.println("startInplaceMacro stop");
        isThreadRunning = false;
    }
}
