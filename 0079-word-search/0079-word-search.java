class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int idx) {
        // ✅ Base case: all characters matched
        if (idx == word.length()) return true;

        // ❌ Invalid move
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // ✅ Choose: mark cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // ✅ Explore: try all 4 directions
        boolean found = backtrack(board, word, i + 1, j, idx + 1) ||
                        backtrack(board, word, i - 1, j, idx + 1) ||
                        backtrack(board, word, i, j + 1, idx + 1) ||
                        backtrack(board, word, i, j - 1, idx + 1);

        // ✅ Un-choose (backtrack): restore cell
        board[i][j] = temp;

        return found;
    }
}
