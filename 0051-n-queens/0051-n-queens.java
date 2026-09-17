class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, n);
        return ans;
    }

    void solve(int r, char[][] board, int n) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board)
                list.add(new String(row));
            ans.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (safe(r, c, board, n)) {
                board[r][c] = 'Q';
                solve(r + 1, board, n);
                board[r][c] = '.';
            }
        }
    }

    boolean safe(int r, int c, char[][] b, int n) {
        for (int i = 0; i < r; i++)
            if (b[i][c] == 'Q') return false;

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (b[i][j] == 'Q') return false;

        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++)
            if (b[i][j] == 'Q') return false;

        return true;
    }
}