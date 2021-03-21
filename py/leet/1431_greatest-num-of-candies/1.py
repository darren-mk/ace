# https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        greatest = []
        for i in range(len(candies)):
            greatest.append((candies[i] + extraCandies) >= max(candies))
        return greatest           
t = Solution()
t.kidsWithCandies([2,3,5,1,3], 3)
