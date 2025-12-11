from typing import List

class SolutionA:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        size = len(nums)
        min_len = None
        left = 0
        right = 1
        running_sum = 0
        while left <= right and right < size:
            l = nums[left:right]
            n = len(l)
            if running_sum < target:
                right += 1
                running_sum += nums[right]
                continue
            if target <= running_sum:
                if min_len is None or n < min_len:
                    min_len = n
                running_sum -= nums[left]
                left += 1
                continue
        return 0 if min_len is None else min_len

def testA():
    sol = SolutionA()
    assert sol.minSubArrayLen(7, [2,3,1,2,4,3]) == 2
    assert sol.minSubArrayLen(4, [1,4,4]) == 1
    assert sol.minSubArrayLen(11, [1,1,1,1,1,1,1,1]) == 0

# fail