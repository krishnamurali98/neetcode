class Solution {
    public boolean dfs(char[][] board, int R, int C, int r, int c, String word, int i, boolean[][] visited) {
        if (i == word.length())
            return true;
        if (r < 0 || c < 0 || r >= R || c >= C || board[r][c] != word.charAt(i) || visited[r][c])
            return false;

        visited[r][c] = true;
        boolean res = dfs(board, R, C, r + 1, c, word, i + 1, visited) ||
                dfs(board, R, C, r - 1, c, word, i + 1, visited) ||
                dfs(board, R, C, r, c + 1, word, i + 1, visited) ||
                dfs(board, R, C, r, c - 1, word, i + 1, visited);
        visited[r][c] = false;

        return res;

    }

    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;

        boolean[][] visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (dfs(board, R, C, r, c, word, 0, visited))
                    return true;
            }
        }
        return false;
    }
}
