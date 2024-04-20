package Rough;

import java.util.Arrays;

class Solution1 {
    public static void main(String[] args) {
        // Change the board to your desired Sudoku puzzle

        char[][] arr = {
                {'1', '2', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '8', '.', '4', '.', '9', '.', '2', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'.', '3', '.', '5', '.', '1', '.', '8', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '2', '.', '.', '.', '.', '8'},
                {'8', '4', '.', '6', '.', '7', '.', '1', '9'},
        };
        
        char[][] arr2 = {
                {'.','.','.','.'},
                {'.','.','1','.'},
                {'.','.','.','1'},
                {'3','.','2','.'},
        };

        solveSudoku(arr);
        solveSudoku(arr2);
        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }
        for (char[] chars : arr2) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static void solveSudoku(char[][] board) {
        int n = board.length; // Get the board size
        solve(board, n);
    }

    public static boolean solve(char[][] board, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == '.') {

                    for (char c = '1'; c <= '1' + (n - 1); c++) {
                        if (isValid(board, row, col, c, n)) {
                            board[row][col] = c;

                            if (solve(board, n)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c, int n) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;
            int subBoxRowStart = (row / getBoxSize(n)) * getBoxSize(n);
            int subBoxColStart = (col / getBoxSize(n)) * getBoxSize(n);
            if (board[subBoxRowStart + i / getBoxSize(n)][subBoxColStart + i % getBoxSize(n)] == c)
                return false;
        }
        return true;
    }

    public static int getBoxSize(int n) {
        // Adjust box size based on board size (assuming square boxes)
        return (int) Math.sqrt(n);
    }
}
