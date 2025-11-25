class SolutionA:
    def isPowerOfFour(self, n: int) -> bool:
        if n == 1 or n == 4: return True
        if n <= 0 or n % 4 != 0: return False
        return self.isPowerOfFour(n / 4)

def testA():
    sol = SolutionA()
    assert sol.isPowerOfFour(16) == True
    assert sol.isPowerOfFour(5) == False
    assert sol.isPowerOfFour(1) == True

# Runtime Beats 100.00%
# Memory Beats 87.19%