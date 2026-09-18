class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return count;
    }

    void backtrack(int r, int n, boolean[] col, boolean[] d1, boolean[] d2) {
        if (r == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || d1[r-c+n] || d2[r+c]) continue;

            col[c] = d1[r-c+n] = d2[r+c] = true;
            backtrack(r+1, n, col, d1, d2);
            col[c] = d1[r-c+n] = d2[r+c] = false;
        }
    }
}