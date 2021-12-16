# https://leetcode.com/problems/longest-substring-without-repeating-characters/

# 1
class Solution_01:
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
''' Runtime: 76 ms, faster than 43.43% 
Memory Usage: 14.3 MB, less than 100.00%  '''

# 2
class Solution_02:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = []
        combi = []
        for c in s:
            if c in combi:
                i = combi.index(c)
                combi = combi[(i+1), len(combi)]
                combi.append(c)
            else:
                combi = combi + [c]
                if len(longest) < len(combi):
                    longest = combi
        return len(longest)
''' Runtime: 146 ms, faster than 21.52%
Memory Usage: 14.2 MB, less than 80.83% '''