from typing import Dict

class Solution:
    def tribonacci(self, n: int, memo: Dict[int, int] = {}) -> int:
        if memo.get(n):
            return memo[n]
        elif n <= 1:
            return n
        elif n == 2:
            return 1
        else:
            memo[n] = self.tribonacci(n-1, memo) + self.tribonacci(n-2, memo) + self.tribonacci(n-3, memo)
            return memo[n]
        
def test_a():
    s = Solution()
    assert s.tribonacci(4) == 4
    assert s.tribonacci(25) == 1389537