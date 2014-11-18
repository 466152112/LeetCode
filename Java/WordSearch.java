// DP recursive, keep isVisited as flag
public boolean exist(char[][] board, String word) {
    boolean[][] isVisited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == word.charAt(0) && find(board, isVisited, word, i, j, 0))
                return true;
        }
    }
    return false;
}

private boolean find(char[][] board, boolean[][] isVisited, String word, int i, int j, int start) {
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || isVisited[i][j] == true || board[i][j] != word.charAt(start))
        return false;
    if (start == word.length() - 1)
        return true;
    isVisited[i][j] = true;
    boolean result = find(board, isVisited, word, i - 1, j, start + 1) || find(board, isVisited, word, i + 1, j, start + 1) || find(board, isVisited, word, i, j + 1, start + 1) || find(board, isVisited, word, i, j - 1, start + 1);
    isVisited[i][j] = false;
    return result;
}
