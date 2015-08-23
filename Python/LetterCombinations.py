class Solution:
    # @param {string} digits
    # @return {string[]}
    def letterCombinations(self, digits):
        if digits == None or len(digits) < 1:
            return []
        mapping = [[],[],['a', 'b', 'c'],['d', 'e', 'f'],['g', 'h', 'i'],['j', 'k', 'l'],['m', 'n', 'o'],['p', 'q', 'r', 's'],['t', 'u', 'v'],['w', 'x', 'y', 'z']]
        result = []
        one = ''
        self.helper(mapping, result, one, digits)
        return result
        
    def helper(self, mapping, result, one, digits):
        if len(one) == len(digits):
            result.append(one)
            return
        for c in mapping[int(digits[len(one)])]:
            one += c
            self.helper(mapping, result, one, digits)
            one = one[:-1]
