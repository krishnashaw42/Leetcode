class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        NQueen(board, 0, n, result);

        return result.size();
    }

    private void NQueen(char[][] board, int row, int n,
                        List<List<String>> result) {

        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {

            if (isSafe(board, row, j, n)) {

                board[row][j] = 'Q';

                NQueen(board, row + 1, n, result);

                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}