from typing import List

class SolutionA:
    def countKDifference(self, nums: List[int], k: int) -> int:
        size = len(nums)
        count = 0
        for i in range(size):
            for j in range(i, size):
                if nums[i] - nums[j] == k or nums[j] - nums[i] == k:
                    count += 1
        return count

def test_2006_a():
    sol = SolutionA()
    assert sol.countKDifference([1,2,2,1], 1) == 4
    assert sol.countKDifference([1,3], 3) == 0
    assert sol.countKDifference([3,2,1,5,4], 2) == 3