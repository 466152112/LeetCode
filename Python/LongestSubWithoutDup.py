class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) < 1:
            return 0
        dup_map = {}
        max_length = 0
        start = 0
        for i in range(len(s)):
            c = s[i]
            if c in dup_map and dup_map[c] >= start:
                max_length = max(max_length, i - start)
                start = dup_map[c] + 1
            dup_map[c] = i
        return max(max_length, len(s) - start)

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        i = 0
        j = 0
        hashmap = {}
        max_length = 0
        while j < len(s):
            if s[j] in hashmap and hashmap[s[j]] >= i:
                max_length = max(max_length, j-i)
                i = hashmap[s[j]] + 1
            hashmap[s[j]] = j
            j += 1
        return max(max_length, j - i)
