class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0 or n != int(n): return False
        if n <= 2: return True
        return self.isPowerOfTwo(n / 2)

def test():
    assert 3 / 2 == 1.5
    assert 3 == int(3)
    assert 3.3 != int(3.3)
    sol = Solution()
    assert sol.isPowerOfTwo(1) == True
    assert sol.isPowerOfTwo(16) == True
    assert sol.isPowerOfTwo(3) == False