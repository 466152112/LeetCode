class Solution(object):
    import sys
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        m = len(dungeon)
        n = len(dungeon[0])
        dp_table = [0]*n + [sys.maxint] # for the last col
        dp_table[n-1] = max(1,1 - dungeon[m-1][n-1])
        # initi the last raw
        for j in range(n - 2, -1, -1):
            dp_table[j] = max(1,dp_table[j+1] - dungeon[m-1][j])
        for i in range(m - 2, -1, -1):
            for j in range(n - 1, -1, -1):
                dp_table[j] = min(max(1,dp_table[j+1] - dungeon[i][j]),max(1,dp_table[j] - dungeon[i][j]))
        return dp_table[0]

class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        import sys
        m, n = len(dungeon), len(dungeon[0])
        dp = [[sys.maxint for i in range(n+1)] for j in range(m+1)]
        dp[m-1][n], dp[m][n-1] = 1, 1 # for the last cell
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                min_require = min(dp[i+1][j],dp[i][j+1])
                dp[i][j] = max(1, min_require - dungeon[i][j])
        return dp[0][0]
