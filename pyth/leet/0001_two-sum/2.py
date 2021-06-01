# https://leetcode.com/problems/two-sum/

from typing import List, Dict, Tuple, Sequence
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in nums:
                if nums.index(complement) != i:
                    return [i, nums.index(complement)]       
trial = Solution()
trial.twoSum([3,2,4], 6)
