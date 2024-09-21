/*
 * These files contain GUI view of the 2048 game.
 * Created By : Sachin Gupta
 * Created Date : 21/9/2024
 */

package Assignment_5;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    static Constant constant = new Constant();
    Board game = new Board();
    public static final int TILE_WIDTH = 100;
    public static final int TILE_HEIGHT = 100;
    public static final int WINDOW_WIDTH = TILE_WIDTH * Board.SIZE + 50;
    public static final int WINDOW_HEIGHT = TILE_HEIGHT * Board.SIZE + 100;

    private static final Color COLOR_BLANK_TILE = new Color(197, 183, 170);
    private static final Color COLOR_2 = new Color(240, 240, 240);
    private static final Color COLOR_4 = new Color(237, 224, 200);
    private static final Color COLOR_8 = new Color(242, 177, 121);
    private static final Color COLOR_16 = new Color(245, 149, 99);
    private static final Color COLOR_32 = new Color(246, 124, 95);
    private static final Color COLOR_64 = new Color(246, 94, 59);
    private static final Color COLOR_128 = new Color(237, 207, 114);
    private static final Color COLOR_256 = new Color(237, 204, 97);
    private static final Color COLOR_512 = new Color(237, 200, 80);
    private static final Color COLOR_1024 = new Color(237, 197, 63);
    private static final Color COLOR_2048 = new Color(237, 194, 46);

    private Tile[][] tiles;
    private JLabel labelScore;
    private JLabel labelMoves;

    //View method is show the GUI panel.
    public View() {
        setup();
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setTitle(constant.GameWindowTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        updateBoard(game);
    }

    //Setup method set up the GUI panel and layout.
    private void setup() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setFocusable(true);

        JPanel gameTitlePanel = new JPanel(new FlowLayout());
        JLabel labelGame = new JLabel();
        ImageIcon gameIcon = new ImageIcon(constant.GameButtonsImagePath);
        Image img = gameIcon.getImage();
        Image newImg = img.getScaledInstance(110, 70, Image.SCALE_SMOOTH);
        gameIcon = new ImageIcon(newImg);

        if (gameIcon.getIconWidth() == -1) {
            System.out.println(constant.ImageNotFound);
        } else {
            labelGame.setIcon(gameIcon);
        }
        JLabel titleText = new JLabel(constant.GameTitle);
        titleText.setFont(new Font(constant.TextFont, Font.BOLD, 40));
        gameTitlePanel.add(titleText);
        gameTitlePanel.add(labelGame);

        JPanel scorePanel = new JPanel(new FlowLayout());
        labelScore = new JLabel(constant.InitialScore);
        labelMoves = new JLabel(constant.InitialMoves);
        labelScore.setFont(new Font(constant.TextFont, Font.BOLD, 20));
        labelMoves.setFont(new Font(constant.TextFont, Font.BOLD, 20));
        scorePanel.add(labelScore);
        scorePanel.add(labelMoves);

        JPanel centerPanel = new JPanel(new GridLayout(Board.SIZE, Board.SIZE));
        tiles = new Tile[Board.SIZE][Board.SIZE];

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                tiles[i][j] = new Tile();
                centerPanel.add(tiles[i][j]);
            }
        }

        mainPanel.add(gameTitlePanel, BorderLayout.NORTH);
        mainPanel.add(scorePanel, BorderLayout.SOUTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }


    // updateBoard method update the game board.
    public void updateBoard(Board boardObject) {
        labelScore.setText(constant.Score + Board.score + "            ");
        labelMoves.setText(constant.Moves + Board.moves);
        int[][] board = boardObject.printBoard();
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                tiles[i][j].setNumber(board[i][j]);
            }
        }
    }

    // Tile class representing each tile on the board.
    public static class Tile extends JLabel {
        public Tile() {
            setOpaque(true);
            setPreferredSize(new Dimension(TILE_WIDTH, TILE_HEIGHT));
            setBorder(BorderFactory.createLineBorder(new Color(147, 133, 120), 3));
            setBackground(COLOR_BLANK_TILE);
            setFont(new Font(constant.TextFont, Font.BOLD, 40));
        }

        public void setNumber(int n) {
            if (n == 0) {
                setText("");
            } else {
                setText("" + n);
            }
            switch (n) {
                case 0 -> setBackground(COLOR_BLANK_TILE);
                case 2 -> setBackground(COLOR_2);
                case 4 -> setBackground(COLOR_4);
                case 8 -> setBackground(COLOR_8);
                case 16 -> setBackground(COLOR_16);
                case 32 -> setBackground(COLOR_32);
                case 64 -> setBackground(COLOR_64);
                case 128 -> setBackground(COLOR_128);
                case 256 -> setBackground(COLOR_256);
                case 512 -> setBackground(COLOR_512);
                case 1024 -> setBackground(COLOR_1024);
                case 2048 -> setBackground(COLOR_2048);
            }
        }
    }
}
