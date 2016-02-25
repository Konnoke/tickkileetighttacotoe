/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 *
 * @author Konnoke
 */
public class GameCell extends JComponent{
    private char token = ' ';
    
    public GameCell(){
        super.setBorder(new LineBorder(Color.BLACK, 1));
        super.addMouseListener(new GameCellMouseAdapter());
        
        
    }
    
     public char getToken() {
            return this.token;
    }

    public void setToken(char token) {
        this.token = token;
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.token == 'X') {
            g.setColor(Color.RED);
            g.drawLine(10, 10, this.getWidth() - 10, this.getHeight() - 10);
            g.drawLine(this.getWidth() - 10, 10, 10, this.getHeight() - 10);
        }
        else if (this.token == 'O') {
            g.setColor(Color.BLUE);
            g.drawOval(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        }
    }
    
    
}
