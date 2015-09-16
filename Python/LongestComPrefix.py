class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) < 1:
            return ''
        hit_pos = 0
        first_str = strs[0]
        while hit_pos <= len(first_str):
            for str in strs:
                if hit_pos == len(str) or str[hit_pos] != first_str[hit_pos]:
                    return strs[0][:hit_pos]
            hit_pos += 1
