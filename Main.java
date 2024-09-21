/*
 * This is the main file where all methods and constant are called.
 * Created By : Sachin Gupta
 * Created Date : 21/9/2024
 */

package Assignment_5;

import Assignment_5.Constant;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        Constant constant = new Constant();
        Board game = new Board();
        View view = new View();

        view.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        SoundPlayer.playSound(constant.SoundFilePath);
                        game.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        SoundPlayer.playSound(constant.SoundFilePath);
                        game.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        SoundPlayer.playSound(constant.SoundFilePath);
                        game.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        SoundPlayer.playSound(constant.SoundFilePath);
                        game.moveRight();
                        break;
                }
                view.updateBoard(game);
                if (game.isGameWon()) {
                    JOptionPane.showMessageDialog(view, constant.WinningMessage);
                }
                if (game.isGameOver()) {
                    JOptionPane.showMessageDialog(view, constant.GameOverMessage);
                    game.newGame();
                    view.updateBoard(game);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used
            }
        });
        view.setFocusable(true);
        view.requestFocusInWindow();
    }
}
