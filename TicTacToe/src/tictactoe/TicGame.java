/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Konnoke
 */
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
@SuppressWarnings("serial")

public class TicGame extends JFrame{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private JLabel statusLabel;

    private char whoseTurn;
    private boolean gameOver;
    private GameCell[][] GameCell;
    private char token;
    
    
    public TicGame() {
        this.whoseTurn = 'X';
        this.GameCell = new GameCell[3][3];
        this.renderComponents();
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        super.setTitle("Tic Tac Toe");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void renderComponents() {
        this.statusLabel = new JLabel("X's turn");
        JPanel cellsPanel = this.renderCellsPanel();
        super.add(cellsPanel, BorderLayout.CENTER);
        super.add(this.statusLabel, BorderLayout.SOUTH);
    }

    private JPanel renderCellsPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(this.GameCell[i][j] = new GameCell());
            }
        }
        return panel;
    }

    private boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.GameCell[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasAwinner(char token) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (this.GameCell[i][0].getToken() == token && this.GameCell[i][1].getToken() == token
                    && this.GameCell[i][2].getToken() == token) {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (this.GameCell[0][i].getToken() == token && this.GameCell[1][i].getToken() == token
                    && this.GameCell[2][i].getToken() == token) {
                return true;
            }
        }
        // check diagonal
        if (this.GameCell[0][0].getToken() == token && this.GameCell[1][1].getToken() == token
                && this.GameCell[2][2].getToken() == token) {
            return true;
        }
        if (this.GameCell[0][2].getToken() == token && this.GameCell[1][1].getToken() == token
                && this.GameCell[2][0].getToken() == token) {
            return true;
        }
        return false;
    }

    private void setToken(char whoseTurn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public class GameCell extends JComponent{
    private char token = ' ';
    
    public GameCell(){
        super.setBorder(new LineBorder(Color.BLACK, 1));
        super.addMouseListener(new GameCellMouseAdapter());
        
        
    }
    
     public char getToken() {
            return this.token;
    }

        /**
         *
         * @param token
         */
    public void setToken(char token) {
        this.token = token;
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.token == 'X') {
            g.setColor(Color.ORANGE);
            g.drawLine(10, 10, this.getWidth() - 10, this.getHeight() - 10);
            g.drawLine(this.getWidth() - 10, 10, 10, this.getHeight() - 10);
        }
        else if (this.token == 'O') {
            g.setColor(Color.GREEN);
            g.drawOval(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        }
    }
    
 
    public class GameCellMouseAdapter extends MouseAdapter{

    
     @Override
     public void mouseClicked(MouseEvent e) {
         
        if (TicGame.this.gameOver) {
            return;
        }
        if (TicGame.this.token == ' ') {
            TicGame.this.setToken(TicGame.this.whoseTurn);
        }
        if (TicGame.this.hasAwinner(GameCell.this.token)) {
            TicGame.this.statusLabel.setText(TicGame.this.whoseTurn + " has won. Game over!");
            TicGame.this.gameOver = true;
        } else if (TicGame.this.isFull()) {
            TicGame.this.statusLabel.setText("Tie game!");
            TicGame.this.gameOver = true;
        } else {
            TicGame.this.whoseTurn = (TicGame.this.whoseTurn == 'X') ? 'O' : 'X';
            TicGame.this.statusLabel.setText(TicGame.this.whoseTurn + "'s turn.");
            }
        }
}
    
    
}

    
    
    
    
}
