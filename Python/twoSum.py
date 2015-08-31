class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        low = 0
        high = 0
        hashmap = {}
        for i in range(len(nums)):
            if target - nums[i] in hashmap:
                low = hashmap[target - nums[i]] + 1
                high = i + 1
            else:
                hashmap[nums[i]] = i
        return [low,high]
