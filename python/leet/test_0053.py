from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        best = nums[0]
        cur = nums[0]
        for num in nums[1:]:
            cur = max(num, cur + num)
            best = max(best, cur)
        return best

def test():
    s = Solution()
    assert s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]) == 6
    assert s.maxSubArray([1]) == 1
    assert s.maxSubArray([5,4,-1,7,8]) == 23
    assert s.maxSubArray([-1]) == -1
    assert s.maxSubArray([-2,-1]) == -1
    assert s.maxSubArray([0]) == 0