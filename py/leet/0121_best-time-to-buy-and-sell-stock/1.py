# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

# solution 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        cost = sum(prices)  
        for i in range(len(prices)):
            if prices[i] < cost: cost = prices[i]
            if prices[i] - cost > profit: profit = prices[i] - cost
        return profit 