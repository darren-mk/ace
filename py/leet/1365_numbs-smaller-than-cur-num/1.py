# https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            smaller = [x for x in nums if x < nums[i]]
            result.append(len(smaller))
        return result
t = Solution()
t.smallerNumbersThanCurrent([8,1,2,2,3])
