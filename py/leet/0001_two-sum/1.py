# https://leetcode.com/problems/two-sum/

from typing import List, Dict, Tuple, Sequence
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pool = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in pool: return [pool[complement], i]
            else: pool[nums[i]] = i
trial = Solution()
trial.twoSum([2,7,11,15], 9)
