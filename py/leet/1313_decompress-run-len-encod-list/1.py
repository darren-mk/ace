# https://leetcode.com/problems/decompress-run-length-encoded-list/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        decomp = []
        half = int(len(nums)/2)
        for i in range(half):
            twice = int(i * 2)
            first = nums[twice]
            second = nums[twice + 1]
            for _ in range(first):
                decomp.append(second)
        return decomp
t = Solution()
t.decompressRLElist([1,2,3,4])        
