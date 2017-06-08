/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentristesting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import static pentristesting.PentrisTesting.colBoard;

public class GraphicsBoard extends JPanel {

    private int x, y;

    public GraphicsBoard() {
        x = 0;
        y = 0;
    }

    public GraphicsBoard(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void paintComponent(Graphics g2) {
        int w = 0;
        super.paintComponent(g2);

        Graphics g = (Graphics) g2;

        for (int i = 5; i < colBoard.length; i++, w++) {
            for (int j = 0; j < colBoard[i].length; j++) {
                g.setColor(Color.gray);
                x = j * 30 + 240;
                g.fillRect(x, y, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 30, 30);

            }
            y = w * 30;
        }
        w = 0;
        for (int i = 5; i < colBoard.length; i++, w++) {
            y = w * 30;

            for (int j = 0; j < colBoard[i].length; j++) {
                
                switch (colBoard[i][j]){
                    case 0: 
                        g.setColor(Color.gray);
                        break;
                    case 1:
                        g.setColor (new Color (255,102,102)); //red
                        break;
                    case 2:
                        g.setColor (new Color (255,255,153));//yellow
                        break;
                    case 3:
                        g.setColor (new Color (153,255,153));//green
                        break;
                    case 4:
                        g.setColor (new Color (153,255,255));//blue
                        break;
                    case 5:
                        g.setColor (new Color (153,204,255));//blue-purple
                        break;
                    case 6:
                        g.setColor (new Color (153,153,255));//purple
                        break;
                    case 7:
                        g.setColor (new Color (255,153,255));//pink
                        break;
                    case 8:
                        g.setColor (new Color (204,153,255)); //purple-pink
                        break;
                    case 9:
                        g.setColor (new Color (255,178,102));//orange
                        break;
                }

                    x = j * 30 + 240;
                    g.fillRect(x, y, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 30, 30);
                
            }
        }
        repaint();
    }
}
