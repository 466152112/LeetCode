class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 3:
            return 0
        result = 0
        # find peak
        peak_index = height.index(max(height))
        # collect from left
        left_bound = height[0]
        for i in range(peak_index):
            if height[i] >= left_bound:
                left_bound = height[i]
            else:
                result += left_bound - height[i]
        # collect from right
        right_bound = height[-1]
        for i in range(len(height)-1,peak_index,-1):
            if height[i] >= right_bound:
                right_bound = height[i]
            else:
                result += right_bound - height[i]
        return result
