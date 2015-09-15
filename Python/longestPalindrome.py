class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # DP, table[i][j] True s[i:j] palindrome
        n = len(s)
        max_len = 1
        start = 0
        # the first way to initial is wrong, [[]]*n just copy the reference of the list, not deep copy
        #table = [[False]*n]*n # init nXn table
        table = [[False for i in range(n)] for j in range(n)]
        for i in range(n):
            table[i][i] = True
        for i in range(1,n):
            table[i-1][i] = s[i-1] == s[i]
            if table[i-1][i]:
                max_len = 2
                start = i-1
        for step in range(2,n-2):
            for i in range(n-step):
                table[i][i+step] = table[i+1][i+step-1] and s[i] == s[i+step]
                if table[i][i+step] and step+1 > max_len:
                    max_len = step+1
                    start = i
        return s[start:start+max_len]
