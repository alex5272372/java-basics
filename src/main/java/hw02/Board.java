package hw02;

import java.util.Random;

public class Board {
    private int sizeX;
    private int sizeY;
    private int targetSize;
    private int[][] board;

    public Board(int sizeY, int sizeX, int targetSize) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.targetSize = targetSize;
        this.board = new int[sizeY][sizeX];
        addHits();
    }

    private void addHits() {
        int direction = generateRandomInt(2);
        if(direction == 0) {
            int firstCell = generateRandomInt(sizeX - targetSize + 1);
            int position = generateRandomInt(sizeY);
            for(int i = firstCell; i < firstCell + targetSize; i++) {
                board[position][i] = 1;
            }

        } else {
            int firstCell = generateRandomInt(sizeY - targetSize + 1);
            int position = generateRandomInt(sizeX);
            for(int i = firstCell; i < firstCell + targetSize; i++) {
                board[i][position] = 1;
            }
        }
    }

    private int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public boolean isGameOver() {
        int res = 0;

        for(int row = 0; row < sizeY; row++) {
            for(int col = 0; col < sizeX; col++) {
                if(board[row][col] == 3) {
                    res++;
                }
            }
        }

        return res == targetSize;
    }

    public void shot(int y, int x) {
        if(board[y][x] == 0) {
            board[y][x] = 2;
        } else if(board[y][x] == 1) {
            board[y][x] = 3;
        }
    }

    /*
    Chars in cells
    0 - (-) closed cell
    1 - (-) closed hit
    2 - (*) cell shot
    3 - (x) hit the target
    */
    private String getChar(int val) {
        String res = "";

        if(val == 0 || val == 1) {
            res = "-";
        } else if(val == 2) {
            res = "*";
        } else if(val == 3) {
            res = "x";
        }

        return res;
    }

    public String toString(boolean intVal) {
        String res = String.format("%3d |", 0);
        for(int col = 0; col < sizeX; col++) {
            res = res + String.format("%3d |", col + 1);
        }
        res = res + "\n";

        for(int row = 0; row < sizeY; row++) {
            res = res + String.format("%3d |", row + 1);
            for(int col = 0; col < sizeX; col++) {
                if(intVal) {
                    res = res + String.format("%3d |", board[row][col]);
                } else {
                    res = res + "  " + getChar(board[row][col]) + " |";
                }
            }
            res = res + "\n";
        }

        return res;
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5, 3);
        System.out.println(board.toString(true));
    }
}
