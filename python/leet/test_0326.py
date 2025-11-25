class SolutionA:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0 or n == 2 or n != int(n): return False
        if n ==1 or n == 3: return True
        return self.isPowerOfThree(n / 3)

def testA():
    sol = SolutionA()
    assert sol.isPowerOfThree(27) == True
    assert sol.isPowerOfThree(0) == False
    assert sol.isPowerOfThree(1) == True
    assert sol.isPowerOfThree(-1) == False

# Runtime Beats 14.19%
# Memory Beats 44.03%

class SolutionB:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0 or n != int(n): return False
        if n ==1 or n == 3: return True
        if n % 3 != 0: return False
        return self.isPowerOfThree(n / 3)

def testB():
    sol = SolutionB()
    assert sol.isPowerOfThree(27) == True
    assert sol.isPowerOfThree(0) == False
    assert sol.isPowerOfThree(1) == True
    assert sol.isPowerOfThree(-1) == False

# Runtime Beats 41.56%
# Memory Beats 99.01%

class SolutionC:
    def isPowerOfThree(self, n: int) -> bool:
        return 0 < n and 1162261467 % n == 0

def testC():
    sol = SolutionC()
    assert sol.isPowerOfThree(27) == True
    assert sol.isPowerOfThree(0) == False
    assert sol.isPowerOfThree(1) == True
    assert sol.isPowerOfThree(-1) == False

# Runtime Beats 71.92%
# Memory Beats 72.68%