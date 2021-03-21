# https://leetcode.com/problems/climbing-stairs/

# solution 1
import typing
class Solution:
    def climbStairs(self, n: int) -> int:
        def recurse(n, acc):
            if acc > n: return 0
            if acc == n: return 1
            return recurse(n, acc + 1) + recurse(n, acc + 2)
        return recurse(n, 0)
trial = Solution()
trial.climbStairs(2) #2
trial.climbStairs(3) #2
# time limit exceeded

# solution 2

