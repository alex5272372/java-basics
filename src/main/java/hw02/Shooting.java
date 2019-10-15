package hw02;

import java.util.Scanner;

public class Shooting {
    private final static int SIZE = 5;
    private final static int TARGET_SIZE = 3;

    public static void main(String[] args) {
        Board board = new Board(SIZE, SIZE, TARGET_SIZE);
        Scanner sc = new Scanner(System.in);
        System.out.println("All set. Get ready to rumble!");

        while(true) {
            System.out.println("Enter row number, or 0 for exit");
            int rowNum = -1;

            while(rowNum == -1 || !isValidInput(rowNum)) {
                String row = sc.next();
                rowNum = processNextInt(row);

                if (rowNum == 0) {
                    return;
                }
            }

            System.out.println("Enter column number, or 0 for exit");
            int colNum = -1;

            while(colNum == -1 || !isValidInput(colNum)) {
                String col = sc.next();
                colNum = processNextInt(col);

                if (colNum == 0) {
                    return;
                }
            }

            board.shot(rowNum - 1, colNum - 1);
            System.out.println(board.toString(false));

            if(board.isGameOver()) {
                System.out.println("You have won!");
                return;
            }
        }
    }

    private static boolean isValidInput(int val) {
        if(val >= 0 && val <= SIZE) {
            return true;
        } else {
            System.out.println(String.format("Wrong input. Value must be between 0 and %s.", SIZE));
            return false;
        }
    }

    private static int processNextInt(String val) {
        try {
            return Integer.parseInt(val);
        } catch (Exception e) {
            System.out.println(String.format("Wrong input. %s.", e.getMessage()));
            return -1;
        }
    }
}
