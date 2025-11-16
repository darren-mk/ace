from typing import List

class SolutionA:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        cost = sum(prices)  
        for i in range(len(prices)):
            if prices[i] < cost: 
                cost = prices[i]
            if prices[i] - cost > profit: 
                profit = prices[i] - cost
        return profit 
    
def test_a():
    s = SolutionA()
    assert s.maxProfit([7,1,5,3,6,4]) == 5
    assert s.maxProfit([7,6,4,3,1]) == 0

class SolutionB:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        cost = prices[0]
        for price in prices:
            if price < cost:
                cost = price
            if price > cost:
                profit = max(profit, price - cost)
        return profit
    
def test_b():
    s = SolutionB()
    assert s.maxProfit([7,1,5,3,6,4]) == 5
    assert s.maxProfit([7,6,4,3,1]) == 0