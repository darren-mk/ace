import heapq
import sys
from typing import List

class Solution:
    def buildAdj(self, n, flights):
        adj = [ [] for _ in range(n) ]
        for src, dst, price in flights:
            adj[src].append((dst, price))
        return adj
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        return -1

def test():
    sol = Solution()
    assert sol.buildAdj(3,[[0,1,100],[1,2,100],[0,2,500]]) == [[(1,100),(2,500)],[(2,100)],[]]
    assert sol.findCheapestPrice(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 1) == 200
    assert sol.findCheapestPrice(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 0) == 500
    assert sol.findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1) == 700
    assert sol.findCheapestPrice(5, [[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]], 2, 1, 1) == -1
    assert sol.findCheapestPrice(5,[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]],0,2,2) == 7 # FAIL