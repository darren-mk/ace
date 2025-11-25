from typing import List

class NumArrayA:
    def __init__(self, nums: List[int]):
        self.nums = nums
    def sumRange(self, left: int, right: int) -> int:
        if left > right: return 0
        acc = 0
        for num in self.nums[left:right+1]:
            acc += num
        return acc

def testA():
    numArray = NumArrayA([-2, 0, 3, -5, 2, -1])
    assert numArray.sumRange(0, 2) == 1
    assert numArray.sumRange(2, 5) == -1
    assert numArray.sumRange(0, 5) == -3

# runtime: 15.05%
# memory: 96.48%

class NumArrayB:
    def __init__(self, nums: List[int]):
        self.acc = [0]
        for num in nums:
            v = (self.acc[-1] if self.acc else 0) + num
            self.acc.append(v)
    def sumRange(self, left: int, right: int) -> int:
        return self.acc[right+1] - self.acc[left]

def testB():
    numArray = NumArrayB([-2, 0, 3, -5, 2, -1])
    assert numArray.sumRange(0, 2) == 1
    assert numArray.sumRange(2, 5) == -1
    assert numArray.sumRange(0, 5) == -3

# runtime: 74.11%
# memory: 26.84%