// Brute force, checking all the possiable solutions
public void solveSudoku(char[][] board) {
    solve(board);
}
// add a return value to solve, for recurive flag
public boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.')
                continue;
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (valid(board, i, j) && solve(board))
                    return true;
                board[i][j] = '.'; // not valid, set back to '.'
            }
            return false; // check all the 1~9, not valid, return false for backtracking
        }
    }
    // all the i j from 0~9 are filled with numbers
    return true;
}

// check whether i,j location in the board is valid or not
private boolean valid(char[][] board, int i, int j) {
    int[] table = {0,0,0,0,0,0,0,0,0}; // flag as a HashSet for checking whether certain character has appeared
    // check row
    for (int k = 0; k < 9; k++) {
        if (board[i][k] == '.')
            continue;
        else if (table[board[i][k] - '1'] == 0)
            table[board[i][k] - '1'] += 1;
        else
            return false;
    }
    // check column
    Arrays.fill(table, 0);
    for (int k = 0; k < 9; k++) {
        if (board[k][j] == '.')
            continue;
        else if (table[board[k][j] - '1'] == 0)
            table[board[k][j] - '1'] += 1;
        else
            return false;
    }        
    // check box
    Arrays.fill(table, 0);
    int row = i/3*3, col = j/3*3;
    for (int m = row; m < row + 3; m++) {
        for (int n = col; n < col + 3; n++) {
            if (board[m][n] == '.')
                continue;
            else if (table[board[m][n] - '1'] == 0)
                table[board[m][n] - '1'] += 1;
            else
                return false;
        }
    }
    return true;
}
