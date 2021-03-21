# https://leetcode.com/problems/implement-strstr/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == '': return 0
        elif needle not in haystack: return -1
        else: return haystack.find(needle)

"""
Runtime: 28 ms, faster than 83.97% of Python3 online submissions for Implement strStr().
Memory Usage: 14.3 MB, less than 7.97% of Python3 online submissions for Implement strStr().
"""
