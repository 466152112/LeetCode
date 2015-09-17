class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 2:
            return 0
        result = 0
        i, j = 0, len(height) - 1
        while i < j:
            if height[i] < height[j]:
                result = max(result, height[i]*(j-i))
                i += 1
            else:
                result = max(result, height[j]*(j-i))
                j -= 1                
        return result
