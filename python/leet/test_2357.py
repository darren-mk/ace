from typing import List

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        nums.sort()
        count = 0
        prev = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                jump = nums[i] - prev
                if jump > 0:
                    count += 1
                prev = nums[i]
        return count

def test():
    sol = Solution()
    assert sol.minimumOperations([1,5,0,3,5]) == 3
    assert sol.minimumOperations([0]) == 0

# Runtime Beats 100.00%
# Memory Beats 51.47%