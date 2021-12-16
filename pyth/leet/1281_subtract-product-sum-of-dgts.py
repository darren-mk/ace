# https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        nums = []
        for s in str(n): nums.append(int(s))
        prd = 1
        sm = 0
        for n in nums:
            prd = prd * n
            sm = sm + n
        return (prd - sm)
trial = Solution()
trial.subtractProductAndSum(234)
