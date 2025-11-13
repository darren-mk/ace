class Solution:
    def __init__(self):
        self.bad_version = -1
    def setBadVersion(self, version: int) -> None:
        self.bad_version = version
    def isBadVersion(self, version: int) -> bool:
        return version >= self.bad_version
    def firstBadVersion(self, n: int) -> int:
        left = 0
        right = n - 1
        while left <= right:
            mid = (left + right) // 2
            if self.isBadVersion(mid):
                right = mid - 1
            else: 
                left = mid + 1
        return left

def test():
    sol = Solution()
    sol.setBadVersion(4)
    assert sol.firstBadVersion(5) == 4
    sol.setBadVersion(1)
    assert sol.firstBadVersion(1) == 1
    sol.setBadVersion(3)
    assert sol.firstBadVersion(5) == 3
