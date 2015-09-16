class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        third_party = {}
        for i in range(len(nums)):
            third_party[nums[i]] = i
        result = []
        for i in range(len(nums)-2):
            if i != 0 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1,len(nums)-1):
                if j != i+1 and nums[j] == nums[j-1]:
                    continue
                third_value = -nums[i]-nums[j]
                if third_value in third_party and third_party[third_value] > j:
                    result.append([nums[i], nums[j], third_value])
        return result
