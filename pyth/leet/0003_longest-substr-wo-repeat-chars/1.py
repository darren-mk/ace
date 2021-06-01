# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1: return len(s)
        longest = 0
        sub = []
        for c in s:
            if c in sub:
                ind = sub.index(c)
                sub = sub[(ind+1) : len(sub)]
                sub.append(c)
            else:
                sub.append(c)
            longest = max(longest, len(sub))
        return longest

trial = Solution()
trial.lengthOfLongestSubstring("abcabcbb")
trial.lengthOfLongestSubstring("bbbbbbbb")
trial.lengthOfLongestSubstring("a")
trial.lengthOfLongestSubstring("dvdf")

"""
Runtime: 76 ms, faster than 43.43% of Python3 online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 14.3 MB, less than 100.00% of Python3 online submissions for Longest Substring Without Repeating Characters.
"""
