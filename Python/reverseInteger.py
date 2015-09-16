class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        neg = 1 if x >= 0 else -1
        x *= neg
        rev_x = 0
        while x > 0:
            rev_x = rev_x*10 + x%10
            x = x/10
        result = rev_x*neg if rev_x <= 2147483647 else 0
        return result
