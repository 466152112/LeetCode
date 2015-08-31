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
