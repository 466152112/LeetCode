// one pass, DP table
public int minPathSum(int[][] grid) {
    if (grid == null)
        return Integer.MAX_VALUE;
    int m = grid.length;
    int n = grid[0].length;
    int[][] table = new int[m][n];  // current minSum of this point
    table[m - 1][n - 1] = grid[m - 1][n - 1];   // destination
    // bottem and right edge
    for (int i = n - 2; i >= 0; i--)
        table[m - 1][i] = grid[m - 1][i] + table[m - 1][i + 1];
    for (int i = m - 2; i >= 0; i--)
        table[i][n - 1] = grid[i][n - 1] + table[i + 1][n - 1];
    // inside blocks
    for (int i = m - 2; i >= 0 ; i--) {
        for (int j = n - 2; j >= 0; j--) {
            table[i][j] = grid[i][j] + Math.min(table[i + 1][j], table[i][j + 1]);
        }
    }
    return table[0][0];
}
