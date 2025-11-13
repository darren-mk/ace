class Solution:
    def __init__(self) -> None:
        self.memo = {0:1, 1:1, 2:2}
    def climbStairs(self, n: int) -> int:
        if n == 0:
            return 1
        if n < 0:
            return 0
        sum = 0
        for x in [1, 2]:
            found = self.memo.get(n - x)
            if not found:
                found = self.climbStairs(n - x)
                self.memo[n - x] = found
            sum += found 
        return sum

def test():
    sol = Solution()
    assert sol.climbStairs(2) == 2
    assert sol.climbStairs(3) == 3

# Runtime Beats 2.82%
# Memory Beats 78.06%