# https://leetcode.com/problems/create-target-array-in-the-given-order/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        lst = []
        for i in range(len(index)):
            lst.insert(index[i], nums[i])
        return lst
t = Solution()
t.createTargetArray([0,1,2,3,4], [0,1,2,2,1])
