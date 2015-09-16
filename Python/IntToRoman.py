class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        digits = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
        romans = ["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"]
        result = ''
        for i in range(len(digits)):
            while num >= digits[i]:
                num -= digits[i]
                result += romans[i]
        return result
