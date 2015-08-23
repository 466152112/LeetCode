class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result_all = [['']]
        for i in range(1,n+1):
            result_this = []
            for j in range(i):
                for e in  result_all[j]:
                    for f in result_all[i - j - 1]:
                        result_this.append('('+ e +')' + f)
            result_all.append(result_this)
        return result_all[-1]
