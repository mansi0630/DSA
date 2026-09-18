class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char n = '1'; n <= '9'; n++) {

                        if (isSafe(row, col, n, board)) {
                            board[row][col] = n;

                            if (solve(board))
                                return true;

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    boolean isSafe(int row, int col, char n, char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n)
                return false;

            if (board[i][col] == n)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n)
                return false;
        }

        return true;
    }
}