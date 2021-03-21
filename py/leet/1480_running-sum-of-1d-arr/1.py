# https://leetcode.com/problems/running-sum-of-1d-array/

# trial 1
from typing import List, Dict, Tuple, Sequence
import functools as f
def product(nums):
    return f.reduce(lambda x, y : x + y, nums)
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        lst = []
        for i in range(1, len(nums) + 1):
            part = [nums[x] for x in range(i) if x <= i]
            prd = product(part)
            lst.append(prd)
        return lst
trial = Solution()
trial.runningSum([3,1,2,10,1])

# trial 2
from typing import List, Dict, Tuple, Sequence
def product(nums):
    p = 0
    for n in nums:
        p = p + n
    return p
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        lst = []
        for i in range(1, len(nums) + 1):
            part = [nums[x] for x in range(i) if x <= i]
            prd = product(part)
            lst.append(prd)
        return lst
trial = Solution()
trial.runningSum([3,1,2,10,1])
