// simple DP recursive
public int uniquePaths(int m, int n) {
    if (m < 1 || n < 1)
        return 0;
    if (m == 1 || n == 1)
        return 1;
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
}

// more time efficient, use table to store the already calculated values
public int uniquePaths(int m, int n) {
    if (m < 1 || n < 1)
        return 0;
    int[][] result = new int[m + 1][n + 1];
    result[m - 1][n] = 1;   // extra value to help initial the right-bottem value to 1 + 0
    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            result[i][j] = result[i + 1][j] + result[i][j + 1];
        }
    }
    return result[0][0];
}
