from typing import List

class SolutionA:
    def minOperations(self, nums: List[int], k: int) -> int:
        return sum(nums) % k

# runtime: 100.00%
# memory: 30.50%