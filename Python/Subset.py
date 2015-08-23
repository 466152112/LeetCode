class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        one = []
        nums = sorted(nums)
        if nums == None or len(nums) < 1:
            return [[]]
        self.helper(nums,result,one,0)
        return result

    def helper(self, nums, result, one, start):
        result.append(one[:])
        for i in range(start,len(nums)):
            one.append(nums[i])
            self.helper(nums,result,one,i+1)
            del one[-1]
