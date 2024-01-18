package org.example.gui;

import org.example.macro.DoubleLionelMacro;
import org.example.macro.InPlaceMacro;
import org.example.macro.LionelMacro;
import org.example.macro.RedNoseMacro;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMain {
    private static boolean isThreadRunning = false;

    public static void main(String[] args) {
        try{
            Robot robot = new Robot();
        }catch (Exception e){
            e.printStackTrace();
        }

        InPlaceMacro.initInPlaceMacroClass();
        RedNoseMacro.initRedNoseMacroClass();
        LionelMacro.initLionelMacroClass();
        DoubleLionelMacro.initLionelMacroClass();

        JFrame frame = new JFrame("Threaded Swing Example");
        JPanel inPlaceMacroPanel = new JPanel();
        JLabel inPlaceMacroLabel = new JLabel("제자리 시작/종료 버튼");
        JLabel inPlaceMacroStatus = new JLabel("제자리 정지중");
        JButton inPlaceMacroButton = new JButton("Start/Stop Thread");

        JPanel redNoseMacroPanel = new JPanel();
        JLabel redNoseMacroLabel = new JLabel("빨간코 시작/종료 버튼");
        JLabel redNoseMacroStatus = new JLabel("빨간코 매크로 정지중");
        JButton redNoseMacroButton = new JButton("Start/Stop Thread");

        JPanel lionelMacroPanel = new JPanel();
        JLabel lionelMacroLabel = new JLabel("라이오넬 시작/종료 버튼");
        JLabel lionelMacroStatus = new JLabel("라이오넬 매크로 정지중");
        JButton lionelMacroButton = new JButton("Start/Stop Thread");

        JPanel doubleLionelMacroPanel = new JPanel();
        JLabel doubleLionelMacroLabel = new JLabel("더블 라이오넬 시작/종료 버튼");
        JLabel doubleLionelMacroStatus = new JLabel("더블 라이오넬 매크로 정지중");
        JButton doubleLionelMacroButton = new JButton("더블 Start/Stop Thread");


        JPanel downBannerPanel = new JPanel();
        JLabel downBannerLabel = new JLabel("모든 매크로 종료");
        JLabel downBannerStatus = new JLabel("모든 매크로 종료 중");
        JButton downBannerButton = new JButton("Start/Stop Thread");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        inPlaceMacroPanel.setSize(300,200);
        inPlaceMacroLabel.setSize(300,50);
        inPlaceMacroStatus.setSize(300,50);
        inPlaceMacroButton.setSize(300,50);

        redNoseMacroPanel.setSize(300,200);
        redNoseMacroLabel.setSize(300,50);
        redNoseMacroStatus.setSize(300,50);
        redNoseMacroButton.setSize(300,50);

        lionelMacroPanel.setSize(300,200);
        lionelMacroLabel.setSize(300,50);
        lionelMacroStatus.setSize(300,50);
        lionelMacroButton.setSize(300,50);

        doubleLionelMacroPanel.setSize(300,200);
        doubleLionelMacroLabel.setSize(300,50);
        doubleLionelMacroStatus.setSize(300,50);
        doubleLionelMacroButton.setSize(300,50);

        downBannerPanel.setSize(300,200);
        downBannerLabel.setSize(300,50);
        downBannerStatus.setSize(300,50);
        downBannerButton.setSize(300,50);


        inPlaceMacroPanel.setLayout(new FlowLayout());
        redNoseMacroPanel.setLayout(new FlowLayout());
        lionelMacroPanel.setLayout(new FlowLayout());
        downBannerPanel.setLayout(new FlowLayout());
        doubleLionelMacroPanel.setLayout(new FlowLayout());


        // 버튼에 대한 이벤트 리스너 등록
        inPlaceMacroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isThreadRunning) {
                    // 스레드 시작
                    startInPlaceMacroThread(inPlaceMacroStatus);
                    inPlaceMacroButton.setText("Stop Thread");
                } else {
                    // 스레드 종료
                    stopInPlaceMacroThread(inPlaceMacroStatus);
                    inPlaceMacroButton.setText("Start Thread");
                }
            }
        });

        redNoseMacroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isThreadRunning) {
                    // 스레드 시작
                    startRedNoseMacroThread(redNoseMacroStatus);
                    redNoseMacroButton.setText("Stop Thread");
                } else {
                    // 스레드 종료
                    stopRedNoseMacroThread(redNoseMacroStatus);
                    redNoseMacroButton.setText("Start Thread");
                }
            }
        });

        lionelMacroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isThreadRunning) {
                    // 스레드 시작
                    startLionelMacroThread(lionelMacroStatus);
                    lionelMacroButton.setText("Stop Thread");
                } else {
                    // 스레드 종료
                    stopLionelMacroThread(lionelMacroStatus);
                    lionelMacroButton.setText("Start Thread");
                }
            }
        });

        doubleLionelMacroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isThreadRunning) {
                    // 스레드 시작
                    startDoubleLionelMacroThread(doubleLionelMacroStatus);
                    doubleLionelMacroButton.setText("Stop Thread");
                } else {
                    // 스레드 종료
                    stopDoubleLionelMacroThread(doubleLionelMacroStatus);
                    doubleLionelMacroButton.setText("Start Thread");
                }
            }
        });



        downBannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allStop(downBannerLabel);
            }
        });

        // 컴포넌트들을 패널에 추가
        inPlaceMacroPanel.add(inPlaceMacroLabel);
        inPlaceMacroPanel.add(inPlaceMacroStatus);
        inPlaceMacroPanel.add(inPlaceMacroButton);

        redNoseMacroPanel.add(redNoseMacroLabel);
        redNoseMacroPanel.add(redNoseMacroStatus);
        redNoseMacroPanel.add(redNoseMacroButton);

        lionelMacroPanel.add(lionelMacroLabel);
        lionelMacroPanel.add(lionelMacroStatus);
        lionelMacroPanel.add(lionelMacroButton);

        doubleLionelMacroPanel.add(doubleLionelMacroLabel);
        doubleLionelMacroPanel.add(doubleLionelMacroStatus);
        doubleLionelMacroPanel.add(doubleLionelMacroButton);

        downBannerPanel.add(downBannerLabel);
        downBannerPanel.add(downBannerStatus);
        downBannerPanel.add(downBannerButton);



        // 프레임에 패널 추가
        frame.add(inPlaceMacroPanel);
        frame.add(redNoseMacroPanel);
        frame.add(lionelMacroPanel);
        frame.add(doubleLionelMacroPanel);
        frame.add(downBannerPanel);
        // 프레임 크기 설정
        frame.setSize(500, 600);
        // 프레임 표시
        frame.setVisible(true);
    }


    private static boolean changeStatus(String flag){

        if(flag.equalsIgnoreCase("start")){
            if(isThreadRunning){
                return false;
            }else{
                isThreadRunning=true;
                return true;
            }
        }else if(flag.equalsIgnoreCase("stop")){
            if(isThreadRunning){
                isThreadRunning=false;
                return true;
            }else{
                return false;

            }
        }else{
            return false;
        }
    }

    private static void startInPlaceMacroThread(JLabel label) {
        if(changeStatus("start"))
            InPlaceMacro.startInplaceMacro(label);
    }

    private static void stopInPlaceMacroThread(JLabel label) {
        if(changeStatus("stop"))
            InPlaceMacro.stopInplaceMacro(label);
    }

    private static void startRedNoseMacroThread(JLabel label) {
        if(changeStatus("start"))
            RedNoseMacro.startRedNoseMacro(label);
    }

    private static void stopRedNoseMacroThread(JLabel label) {
        if(changeStatus("stop"))
            RedNoseMacro.stopRedNoseMacro(label);
    }

    private static void startLionelMacroThread(JLabel label) {
        if(changeStatus("start"))
            LionelMacro.startLionelMacro(label);
    }

    private static void stopLionelMacroThread(JLabel label) {
        if(changeStatus("stop"))
            LionelMacro.stopLionelMacro(label);
    }

    private static void startDoubleLionelMacroThread(JLabel label) {
        if(changeStatus("start"))
            DoubleLionelMacro.startDoubleLionelMacro(label);
    }

    private static void stopDoubleLionelMacroThread(JLabel label) {
        if(changeStatus("stop"))
            DoubleLionelMacro.stopDoubleLionelMacro(label);
    }
    //



    private static void allStop(JLabel label){
        RedNoseMacro.stopRedNoseMacro(label);
        InPlaceMacro.stopInplaceMacro(label);
        LionelMacro.stopLionelMacro(label);
        DoubleLionelMacro.stopDoubleLionelMacro(label);
    }

}
