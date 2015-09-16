class Solution(object):
    def fourSum(self, nums, target):
        nums = sorted(nums)
        third_party = {}
        for i in range(len(nums)):
            third_party[nums[i]] = i
        result = []
        for i in range(len(nums)-3):
            if i != 0 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1,len(nums)-2):
                if j != i+1 and nums[j] == nums[j-1]:
                    continue
                for k in range(j+1,len(nums)-1):
                    if k != j+1 and nums[k] == nums[k-1]:
                        continue                
                    third_value = target-nums[i]-nums[j]-nums[k]
                    if third_value in third_party and third_party[third_value] > k:
                        result.append([nums[i], nums[j], nums[k], third_value])
        return result
