class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp_table = [1]*n
        for i in range(m - 1):
            for j in range(n - 2, -1, -1):
                dp_table[j] += dp_table[j + 1]
        return dp_table[0]

    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp_table = [0]*(n+1) # extra col to check to wall
        if obstacleGrid[m-1][n-1] == 0:
            dp_table[n-1] = 1
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if obstacleGrid[i][j] == 1:
                    dp_table[j] = 0
                else:
                    dp_table[j] += dp_table[j + 1]
        return dp_table[0]        
