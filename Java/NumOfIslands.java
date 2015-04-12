// mark BFS
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
        return 0;
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '0')
                continue;
            if (grid[i][j] == '1') {
                bfs(i, j, grid);
                result++;
            }
        }
    }
    return result;
}

// BFS from the point (i,j), mark all the visited point to '#'
private void bfs(int i, int j, char[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
        return;
    if (grid[i][j] == '0' || grid[i][j] == '#')
        return;
    grid[i][j] = '#';
    bfs(i - 1, j, grid);
    bfs(i + 1, j, grid);
    bfs(i, j - 1, grid);
    bfs(i, j + 1, grid);
}
