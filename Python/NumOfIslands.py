class Solution:
    # @param {character[][]} grid
    # @return {integer}
    def numIslands(self, grid):
        if grid == None or len(grid) < 1 or len(grid[0]) < 1:
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid,i,j)
        return count

    def dfs(self, grid, x, y):
        if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]):
            return
        if grid[x][y] != '1':
            return
        grid[x][y] = '-1'
        self.dfs(grid,x-1,y)
        self.dfs(grid,x+1,y)
        self.dfs(grid,x,y-1)
        self.dfs(grid,x,y+1)
