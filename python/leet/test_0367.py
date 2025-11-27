class SolutionA:
    def isPerfectSquare(self, num: int) -> bool:
        left = 1
        right = num
        while left <= right:
            mid = (left + right) // 2
            mm = mid * mid
            if num == mm:
                return True
            elif num < mm:
                right = mid - 1
            elif mm < num:
                left = mid + 1
        return False

def testA():
    sol = SolutionA()
    assert sol.isPerfectSquare(16) is True
    assert sol.isPerfectSquare(14) is False

# time: O(logN)
# space: O(1)
# runtime: 100.00%
# memory: 79.28%