package org.example.macro;

import java.awt.*;
import java.awt.event.InputEvent;

public class GlassMacro {


//    public static void main(String[] args) throws Exception{
//        try {
//            // Robot 인스턴스 생성
//            Robot robot = new Robot();
//            int count =0;
//            // 마우스를 (x, y) 좌표로 이동
//            while(true){
//                count++;
//                int x = 358;
//                int y = 365;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 642;
//                y = 372;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 849;
//                y = 466;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 746;
//                y = 504;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 358;
//                y = 365;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 659;
//                y = 452;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 845;
//                y = 502;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//
//                x = 845;
//                y = 502;
//                robot.mouseMove(x, y);
//                // 마우스 왼쪽 버튼 클릭
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(350);
//                System.out.println(count);
//                if(count>140){
//                    break;
//                }
//            }
//
//
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        // 현재 마우스의 위치 얻기
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        java.awt.Point mouseLocation = pointerInfo.getLocation();

        // 마우스의 x 및 y 좌표 출력
        System.out.println("Mouse X: " + (int) mouseLocation.getX());
        System.out.println("Mouse Y: " + (int) mouseLocation.getY());
    }
}
