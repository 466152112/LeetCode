// too simple, if you know how to deal with obstacles in the smart way, just like life
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (m < 1 || n < 1)
        return 0;
    int[][] result = new int[m + 1][n + 1];
    result[m - 1][n] = 1;   // extra value to help initial the right-bottem value to 1 + 0
    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            if (obstacleGrid[i][j] == 0)
                result[i][j] = result[i + 1][j] + result[i][j + 1];
            else
               result[i][j] = 0; 
        }
    }
    return result[0][0];
}
