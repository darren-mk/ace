# https://leetcode.com/problems/longest-palindromic-substring/

from typing import List

# 1
class Solution_01:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 1: return s
        longest = ''
        for i in range(0, len(s), +1):
            for j in range(i+len(longest), len(s), +1):
                taken = s[i:j+1:+1]
                if taken == taken[::-1]:
                    if len(longest) < len(taken):
                        longest = taken
        return longest            
''' time limit exceeded '''

# 2
class Solution_02:
    def longestPalindrome(self, s: str) -> str:
        lns = len(s)
        if lns == 1 or len(set(s)) == 1:
            return s
        longest = ''
        for i in range(lns):
            for j in range(i+1,lns+1):
                sub = s[i:j]
                rsub = sub[::-1]
                if sub == rsub:
                    if len(longest) < len(sub):
                        longest = sub
        return longest
''' time limit exceeded '''