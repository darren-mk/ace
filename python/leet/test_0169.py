from typing import List

class SolutionA:
    def majorityElement(self, nums: List[int]) -> int:
        memo = {}
        n = len(nums)
        for num in nums:
            memo[num] = memo.get(num,0) + 1
            if memo[num] > (n / 2):
                return num

def testA():
    sol = SolutionA()
    assert sol.majorityElement([3,2,3]) == 3
    assert sol.majorityElement([2,2,1,1,1,2,2]) == 2

# time: O(N)
# space: O(N)
# runtime: 29.69%
# memory: 51.12%