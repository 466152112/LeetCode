class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m, n = len(word1), len(word2)
        if m*n == 0:
            return max(m,n)
        table = [[0 for j in range(n)] for i in range(m)]
        table[0][0] = 0 if word1[0] == word2[0] else 1
        # initial boundry
        for j in range(1,n):
            table[0][j] = j if word1[0] == word2[j] else table[0][j-1] + 1
        for i in range(1,m):
            table[i][0] = i if word1[i] == word2[0] else table[i-1][0] + 1
        # fill full table
        for i in range(1,m):
            for j in range(1,n):
                var = 0 if word1[i] == word2[j] else 1
                table[i][j] = min(min(table[i][j-1]+1,table[i-1][j]+1),table[i-1][j-1]+var)
        return table[m-1][n-1]
