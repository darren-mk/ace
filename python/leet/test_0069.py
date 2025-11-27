class SolutionA:
    def mySqrt(self, x: int) -> int:
        left = 1
        right = x
        while left <= right:
            mid = (left + right) // 2
            mm = mid * mid
            if mm == x:
                return mid
            elif mm < x:
                left = mid + 1
            else:
                right = mid - 1
        return left - 1

def testA():
    sol = SolutionA()
    assert sol.mySqrt(4) == 2
    assert sol.mySqrt(8) == 2
    assert sol.mySqrt(0) == 0
    assert sol.mySqrt(1) == 1
    assert sol.mySqrt(15) == 3
    assert sol.mySqrt(16) == 4
    assert sol.mySqrt(2147395599) == 46339

# Time: O(log x)
# space: O(1)
# runtime: 62.82%
# memory: 10.12%