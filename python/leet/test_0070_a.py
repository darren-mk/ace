class Solution:
    def climbStairs(self, n: int) -> int:
        def recurse(n: int, acc: int) -> int:
            if acc > n: return 0
            if acc == n: return 1
            return recurse(n, acc + 1) + recurse(n, acc + 2)
        return recurse(n, 0)
    
def test():
    sol = Solution()
    assert sol.climbStairs(2) == 2
    assert sol.climbStairs(3) == 3