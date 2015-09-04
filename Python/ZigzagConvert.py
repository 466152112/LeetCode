class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        result = ''
        if numRows < 1:
            return result
        if numRows == 1:
            return s
        gap = 2*numRows - 2
        # 1st row
        row = 0
        idx = row
        while idx < len(s):
            result += s[idx]
            idx += gap
        # mid rows
        for row in range(1, numRows - 1):
            idx = row
            while idx < len(s):
                result += s[idx]
                idx2 = gap + idx - 2*row # jump to the next pattern, then go back some steps
                if idx2 < len(s):
                    result += s[idx2]
                idx += gap
        # last row
        row = numRows - 1
        idx = row
        while idx < len(s):
            result += s[idx]
            idx += gap
        return result
