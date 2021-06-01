# https://leetcode.com/problems/implement-strstr/submissions/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == '': return 0
        elif needle not in haystack: return -1
        else:
            for i in range(len(haystack)):
                if haystack[i:(i+len(needle))] == needle:
                    return i

"""
Runtime: 24 ms, faster than 95.33% of Python3 online submissions for Implement strStr().
Memory Usage: 14.1 MB, less than 7.97% of Python3 online submissions for Implement strStr().
"""
