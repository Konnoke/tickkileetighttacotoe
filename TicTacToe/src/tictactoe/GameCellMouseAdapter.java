/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
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
import java.awt.event.MouseEvent;

/**
 *
 * @author Konnoke
 */
public class GameCellMouseAdapter extends MouseAdapter{

    GameCellMouseAdapter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
