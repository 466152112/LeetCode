public boolean isValidSudoku(char[][] board) {
	// row
    for (int i = 0; i < 9; i++) {
        int[] flag = {-1,0,0,0,0,0,0,0,0,0};
        for (int ii = 0; ii < 9; ii++) {
            if (check(board[i][ii], flag))
                return false;
        }
    }
    // col
    for (int i = 0; i < 9; i++) {
        int[] flag = {-1,0,0,0,0,0,0,0,0,0};
        for (int ii = 0; ii < 9; ii++) {
            if (check(board[ii][i], flag))
                return false;
        }
    }
    // box
    for (int i = 0; i < 9; i += 3) {
        for (int j = 0; j < 9; j += 3) {
            int[] flag = {-1,0,0,0,0,0,0,0,0,0};
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (check(board[i + l][j + k], flag))
                        return false;
                }
            }
        }
    }
    return true;
}

// check valid or not, if not valid return true
private boolean check(char c, int[] flag) {
    if (c == '.')
        return false;
    if (flag[c - '0'] == 1)
        return true;
    else 
        flag[c-'0'] = 1;
    return false;
}
