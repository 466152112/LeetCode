class Solution(object):
    # only one transaction
    def maxProfitI(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        import sys
        min_v = sys.maxint
        result = 0
        for i in prices:
            if i <= min_v:
                min_v = i
            else:
                result = max(result, i - min_v)
        return result
        
    # multiple trasactions
    def maxProfitII(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        import sys
        if len(prices) < 2:
            return 0
        min_v = sys.maxint
        result = 0
        for i in range(len(prices)-1):
            if prices[i] <= min_v:
                min_v = prices[i]
            elif prices[i] > prices[i+1]:
                result += prices[i] - min_v
                min_v = prices[i]
        result += max(prices[-1] - min_v, 0)
        return result
        
        # only two transaction
    def maxProfitIII(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        profit_left = [0]*n
        profit_right = [0]*n
        max_v = prices[-1]
        min_v = prices[0]        
        # left from min point
        for i in range(1,n):
            if prices[i] <= min_v:
                min_v = prices[i]
            profit_left[i] = max(profit_left[i-1], prices[i]-min_v)
        # right from max point
        for i in range(n-2,-1,-1):
            if prices[i] >= max_v:
                max_v = prices[i]
            profit_right[i] = max(profit_right[i+1], max_v-prices[i])
        # find the division point for total max
        result = 0
        for i in range(n):
            result = max(result, profit_left[i] + profit_right[i])
        return result        
