/*
 * These files contain the 2048 game logic and method.
 * Created By : Sachin Gupta
 * Created Date : 21/9/2024
 */

package Assignment_5;

import Assignment_5.Constant;

import java.util.Random;

public class Board {
    Constant constant = new Constant();
    static final int SIZE = 4;
    private int[][] board;
    private Random random;
    public static int score;
    public static int moves;
    boolean hasWon;

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    //Board method initialized the Board with initial values.
    public Board() {
        board = new int[SIZE][SIZE];
        random = new Random();
        score = 0;
        moves = 0;
        hasWon = false;
        addRandomTile();
        addRandomTile();
    }

    //printBoard method print the board of 2048 game.
    int[][] printBoard() {
        System.out.println(BOLD + constant.GameTitle + RESET);
        System.out.println(constant.Score + score + "   " + constant.Moves + moves);
        System.out.println();
        System.out.println("+-----+-----+-----+-----+");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print("    | ");
                } else {
                    System.out.printf("%-3d | ", board[i][j]);
                }
            }
            System.out.println();
            System.out.println("+-----+-----+-----+-----+");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        return board;
    }

    // addRandomTile method add the random tiles on the board.
    void addRandomTile() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (board[x][y] != 0);
        board[x][y] = random.nextInt(10) < 9 ? 2 : 4;
    }

    //newGame method re-initialized the game board.
    public void newGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
        score = 0;
        moves = 0;
        hasWon = false;
        addRandomTile();
        addRandomTile();
        printBoard();
        System.out.println(constant.NewGameStartedMessage);
    }

    //moveUp method move the tiles to up and merged tiles.
    public boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int[] merged = new int[SIZE];
            int target = 0;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != 0) {
                    if (target > 0 && board[target - 1][j] == board[i][j] && merged[target - 1] == 0) {
                        board[target - 1][j] *= 2;
                        score += board[target - 1][j];
                        merged[target - 1] = 1;
                        board[i][j] = 0;
                        moved = true;
                    } else {
                        if (i != target) {
                            board[target][j] = board[i][j];
                            board[i][j] = 0;
                            moved = true;
                        }
                        target++;
                    }
                }
            }
        }
        if (moved) {
            moves++;
            addRandomTile();
        }
        return moved;
    }

    //moveDown method move the tiles to down and merged tiles.
    public boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int[] merged = new int[SIZE];
            int target = SIZE - 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (target < SIZE - 1 && board[target + 1][j] == board[i][j] && merged[target + 1] == 0) {
                        board[target + 1][j] *= 2;
                        score += board[target + 1][j];
                        merged[target + 1] = 1;
                        board[i][j] = 0;
                        moved = true;
                    } else {
                        if (i != target) {
                            board[target][j] = board[i][j];
                            board[i][j] = 0;
                            moved = true;
                        }
                        target--;
                    }
                }
            }
        }
        if (moved) {
            moves++;
            addRandomTile();
        }
        return moved;
    }

    //moveLeft method move the tiles to left and merged tiles.
    public boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] merged = new int[SIZE];
            int target = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    if (target > 0 && board[i][target - 1] == board[i][j] && merged[target - 1] == 0) {
                        board[i][target - 1] *= 2;
                        score += board[i][target - 1];
                        merged[target - 1] = 1;
                        board[i][j] = 0;
                        moved = true;
                    } else {
                        if (j != target) {
                            board[i][target] = board[i][j];
                            board[i][j] = 0;
                            moved = true;
                        }
                        target++;
                    }
                }
            }
        }
        if (moved) {
            moves++;
            addRandomTile();
        }
        return moved;
    }

    //moveRight method move the tiles to right and merged tiles.
    public boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] merged = new int[SIZE];
            int target = SIZE - 1;
            for (int j = SIZE - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (target < SIZE - 1 && board[i][target + 1] == board[i][j] && merged[target + 1] == 0) {
                        board[i][target + 1] *= 2;
                        score += board[i][target + 1];
                        merged[target + 1] = 1;
                        board[i][j] = 0;
                        moved = true;
                    } else {
                        if (j != target) {
                            board[i][target] = board[i][j];
                            board[i][j] = 0;
                            moved = true;
                        }
                        target--;
                    }
                }
            }
        }
        if (moved) {
            moves++;
            addRandomTile();
        }
        return moved;
    }

    //isGameWon method check the game complete 2048 score.
    public boolean isGameWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    //isGameOver method check the game have moves or not.
    public boolean isGameOver() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (board[i][j] == board[i + 1][j] || board[i][j] == board[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

