class SolutionA:
    def climbStairs(self, n: int) -> int:
        a, b = 1, 1  # F(0)=1, F(1)=1
        for _ in range(n):
            a, b = b, a + b
        return a

def test_a():
    sol = SolutionA()
    assert sol.climbStairs(2) == 2
    assert sol.climbStairs(3) == 3

# Runtime Beats 2.82%
# Memory Beats 78.06%

class SolutionB:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        else:
            a = 1
            b = 2
            for _ in range(3, n+1):
                a, b = b, a + b
            return b

def test_b():
    sol = SolutionB()
    assert sol.climbStairs(0) == 0
    assert sol.climbStairs(1) == 1
    assert sol.climbStairs(2) == 2 # 1-1, 2
    assert sol.climbStairs(3) == 3 # 1-1-1, 1-2, 2-1
    assert sol.climbStairs(4) == 5 # 1-1-1-1, 2-1-1, 1-2-1, 1-1-2, 2-2
    assert sol.climbStairs(5) == 8 # 1-1-1-1-1, 2-1-1-1, 1-2-1-1, 1-1-2-1, 1-1-1-2, 2-2-1, 2-1-2, 1-2-2  