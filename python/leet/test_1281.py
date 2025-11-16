# https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

from typing import List

class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        nums: List[int] = []
        for s in str(n): nums.append(int(s))
        prd = 1
        sm = 0
        for n in nums:
            prd = prd * n
            sm = sm + n
        return (prd - sm)