class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        import sys
        nums = sorted(nums)
        min_gap = sys.maxint
        result = 0
        for i in range(len(nums)-2):
            if i != 0 and nums[i] == nums[i-1]:
                continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                value = nums[i] + nums[left] + nums[right]
                if value == target:
                    return target
                elif value < target:
                    if target - value < min_gap:
                        min_gap = target - value
                        result = value
                    left += 1
                else:
                    if value - target < min_gap:
                        min_gap = value - target
                        result = value
                    right -= 1
        return result
