class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {

        if (row == 9)
            return true;

        int nextRow = row;
        int nextCol = col + 1;

        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.')
            return helper(board, nextRow, nextCol);

        for (char d = '1'; d <= '9'; d++) {

            if (isSafe(board, row, col, d)) {

                board[row][col] = d;

                if (helper(board, nextRow, nextCol))
                    return true;

                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char dig) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == dig)
                return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == dig)
                return false;
        }

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == dig)
                    return false;
            }
        }

        return true;
    }
}