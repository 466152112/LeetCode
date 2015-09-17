class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        table = {')':'(',']':'[','}':'{'}
        for c in s:
            if c not in table:
                stack.append(c)
            # c in the table, stack empyt, pop not match
            elif len(stack) == 0 or stack.pop() != table[c]:
                    return False
        return len(stack) == 0
