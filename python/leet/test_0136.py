from typing import List

class SolutionA:
    def singleNumber(self, nums: List[int]) -> int:
        acc = 0
        for num in nums:
            acc = acc ^ num
        return acc

def testA():
    sol = SolutionA()
    assert sol.singleNumber([2,2,1]) == 1
    assert sol.singleNumber([4,1,2,1,2]) == 4
    assert sol.singleNumber([1]) == 1

# time: O(n)
# space: O(1)
# runtime: 45.96%
# memory: 76.94%