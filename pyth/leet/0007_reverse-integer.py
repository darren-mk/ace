# https://leetcode.com/problems/reverse-integer/

class Solution:
    def reverse(self, x: int) -> int:
        if x == 0: return 0
        t = ''
        sign = 1
        if x < 0:
            sign = -1
            t = str(-x)
        else:
            t = str(x)
        lst = list(t)
        lst.reverse()
        num = int(''.join(lst)) * sign
        if -2**31 < num < 2**31: return num
        else: return 0  

trial = Solution()
trial.reverse(123)
trial.reverse(-12345678)

"""
Runtime: 40 ms, faster than 15.42% of Python3 online submissions for Reverse Integer.
Memory Usage: 14.1 MB, less than 99.99% of Python3 online submissions for Reverse Integer.
"""
