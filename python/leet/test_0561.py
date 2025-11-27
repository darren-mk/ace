from typing import List

class SolutionA:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        acc = 0
        pair = []
        for num in nums:
            if len(pair) < 2:
                pair.append(num)
            if len(pair) == 2:
                acc += min(pair)
                pair = []
        return acc

def testA():
    assert min([1,2,3]) == 1
    sol = SolutionA()
    assert sol.arrayPairSum([1, 4, 3, 2]) == 4
    assert sol.arrayPairSum([6, 2, 6, 5, 1, 2]) == 9
    assert sol.arrayPairSum([1, 2]) == 1
    assert sol.arrayPairSum([-1, 3]) == -1
    assert sol.arrayPairSum([0, 0]) == 0
    assert sol.arrayPairSum([-1, 2, -3, 4]) == -1
    assert sol.arrayPairSum([-5, -4, -3, -2]) == -8
    assert sol.arrayPairSum([1, 1, 1, 1]) == 2
    assert sol.arrayPairSum([1, 2, 1, 0]) == 1
    assert sol.arrayPairSum([1, 2, 3, 4, 5, 6]) == 9

# time: n * log n
# space: 1
# runtime: 10.17%
# memory: 32.86%