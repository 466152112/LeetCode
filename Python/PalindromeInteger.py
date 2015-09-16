class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        rev_x = 0
        old_x = x
        while x > 0:
            rev_x = rev_x*10 + x%10
            x = x/10            
        return rev_x == old_x
