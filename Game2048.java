package Assignment_5;

import java.util.Random;
import java.util.Scanner;

public class Game2048 {

    private static final int SIZE = 4;
    private int[][] board;
    private Random random;
    private boolean hasWon;
    private int score;

    public Game2048() {
        board = new int[SIZE][SIZE];
        random = new Random();
        hasWon = false;
        score = 0;
        addRandomTile();
        addRandomTile();
    }

    public static void main(String[] args) {
        Game2048 game = new Game2048();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();

            if (game.hasWon) {
                System.out.println("Congratulations! You won the game.");
                break;
            }

            if (!game.canMove()) {
                System.out.println("Game Over! No more possible moves.");
                break;
            }

            System.out.println("Enter move (W - Up, S - Down, A - Left, D - Right, Q - Quit): ");
            char move = scanner.next().charAt(0);

            if (move == 'Q' || move == 'q') {
                System.out.println("Thanks for playing!");
                break;
            }

            boolean moved = game.move(move);

            if (moved) {
                game.addRandomTile();
            }
        }

        scanner.close();
    }

    private void printBoard() {
        System.out.println("Score: " + score);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print(".\t");
                } else {
                    System.out.print(board[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void addRandomTile() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (board[x][y] != 0);

        board[x][y] = random.nextInt(10) < 9 ? 2 : 4;
    }

    private boolean canMove() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) return true;
                if (i < SIZE - 1 && board[i][j] == board[i + 1][j]) return true;
                if (j < SIZE - 1 && board[i][j] == board[i][j + 1]) return true;
            }
        }
        return false;
    }

    private boolean move(char direction) {
        boolean moved = false;
        switch (direction) {
            case 'W':
            case 'w':
                moved = moveUp();
                break;
            case 'S':
            case 's':
                moved = moveDown();
                break;
            case 'A':
            case 'a':
                moved = moveLeft();
                break;
            case 'D':
            case 'd':
                moved = moveRight();
                break;
            default:
                System.out.println("Invalid move! Use W, A, S, D to move.");
        }
        return moved;
    }

    private boolean moveUp() {
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
                        if (board[target - 1][j] == 2048) {
                            hasWon = true;
                        }
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
        return moved;
    }

    private boolean moveDown() {
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
                        if (board[target + 1][j] == 2048) {
                            hasWon = true;
                        }
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
        return moved;
    }

    private boolean moveLeft() {
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
                        if (board[i][target - 1] == 2048) {
                            hasWon = true;
                        }
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
        return moved;
    }

    private boolean moveRight() {
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
                        if (board[i][target + 1] == 2048) {
                            hasWon = true;
                        }
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
        return moved;
    }
}
