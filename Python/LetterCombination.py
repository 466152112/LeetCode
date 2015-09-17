class Solution(object):
    result = []
    one = ''    
    mapping = {'2':['a','b','c'],
               '3':['d','e','f'],
               '4':['g','h','i'],                   
               '5':['j','k','l'],
               '6':['m','n','o'],
               '7':['p','q','r','s'],
               '8':['t','u','v'],                   
               '9':['w','x','y','z'],                   
               '0':[' ']}    
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        self.result = []
        self.one = ''
        if len(digits) < 1:
            return self.result
        self.helper(digits)
        return self.result

    def helper(self, digits):
        if len(digits) == 0:
            self.result.append(self.one[:])
            return
        c = digits[0]
        dicts = self.mapping[c]
        for i in dicts:
            self.one += i
            self.helper(digits[1:])
            self.one = self.one[:-1]
