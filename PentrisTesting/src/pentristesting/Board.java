/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentristesting;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import static pentristesting.PentrisTesting.frame;

public class Board extends JComponent implements ActionListener {

    private static int level, difficulty, dropSpeed, speedChange;
    private static boolean mute = true;
    private static int xLoc = 0;
    private static int yLoc = 0;   
    public static int[][] boardArray = new int[25][10];

    public Board(int difficulty) {
        this.dropSpeed = 1000;
        this.level = 1;
        this.difficulty = difficulty;
        //called each time a level is passed
        //can be put into levelUp() method or something similar
        speedChange += ((dropSpeed / difficulty) * 5);
        dropSpeed -= speedChange;

        Timer timer = new Timer(1000, this);
//        timer.start();
    }

    public void play() throws LineUnavailableException {
        File themeSong = new File("src/TetrisThemeSong.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            if (mute == false) {
                audioClip.start();
            } else {
                audioClip.stop();
            }

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }

    private int updateYLoc() {
        yLoc += (frame.getHeight() / 40);
        System.out.println("drop amount = " + (frame.getHeight() / 20));
        repaint();
        return yLoc;
    }

    @Override
    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics g2d = (Graphics2D) g;
//
//        //setting the background color to white
//        g2d.setColor(Color.black);
//        g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
//
//        g2d.setColor(Color.white);
//        g2d.drawImage(JBlock4, xLoc, yLoc, 100, 150, this);
//        //        g2d.drawImage(IBlock4, 0, 0, this);
//        //        g2d.drawImage(JBlock4, 0, 565, this);
//        //        g2d.drawImage(LBlock4, 0, 150, this);
//        //        g2d.drawImage(OBlock4, 550, 0, this);
//        //        g2d.drawImage(SBlock4, 550, 300, this);
//        //        g2d.drawImage(TBlock4, 550, 600, this);
//        //        g2d.drawImage(ZBlock4, 300, 700, this);
    }

    public void up() {
        //should actually rotate
        yLoc += -10;
    }

    public void down() {
        yLoc += frame.getHeight() / 20;
    }

    public void left() {
        System.out.println("moving left");
        xLoc += -(frame.getWidth() / 10);
        repaint();
    }

    public void right() {
        System.out.println("moving right");
        xLoc += frame.getWidth() / 10;
        repaint();
    }

    public static boolean isMute() {
        return mute;
    }

    public static void setMute(boolean mute) {
        Board.mute = mute;
    }

    public static int[][] getBoardArray() {
        return boardArray;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("task performed");
        if (yLoc < 865) {
            updateYLoc();
        }
        repaint();
    }

}