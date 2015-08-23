// combination is different from permutation,
// permutation care about the order, so any one can be add to the front
// combination is no order, so the front should be from the "start"
// combination is just a specitial case for subset problem, combinations are a small subset of the results of subset problem

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        one = []
        if nums == None or len(nums) < 1:
            return result
        self.helper(nums,result,one)
        return result
        
    def helper(self, nums, result, one):
        if len(one) == len(nums):
            result.append(one[:])
            return
        for i in range(len(nums)):
            if nums[i] in one:
                continue
            one.append(nums[i])
            self.helper(nums,result,one)
            del one[-1]
