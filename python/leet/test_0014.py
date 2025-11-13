# https://leetcode.com/problems/longest-common-prefix/

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0: return ''
        if len(strs) == 1: return strs[0]
        i = 0
        common_prefix = ''
        check = set()
        lengths = []
        for s in strs:
            lengths.append(len(s))
        l = min(lengths)
        print(l)
        for i in range(l):
            for s in strs:
                check.add(s[i])
            if len(check) == 1:
                common_prefix += list(check)[0]
                check.clear()
            else:
                return common_prefix
        return common_prefix
            
trial = Solution()
trial.longestCommonPrefix(["flower","flow","flight"])
trial.longestCommonPrefix(["dog","racecar","car"])

"""
Runtime: 32 ms, faster than 77.97% of Python3 online submissions for Longest Common Prefix.
Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Longest Common Prefix.
"""
