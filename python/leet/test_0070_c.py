class Solution:
    def climbStairs(self, n: int) -> int:
        a, b = 1, 1  # F(0)=1, F(1)=1
        for _ in range(n):
            a, b = b, a + b
        return a

def test():
    sol = Solution()
    assert sol.climbStairs(2) == 2
    assert sol.climbStairs(3) == 3

# Runtime Beats 2.82%
# Memory Beats 78.06%