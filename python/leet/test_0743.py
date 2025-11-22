import heapq
import sys
from typing import List

class Solution:
    def buildAdj(self, times, n):
        res = [[] for _ in range(n+1)]
        for start, end, weight in times:
            res[start].append((end, weight))
        return res
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = self.buildAdj(times, n)
        V = len(adj)
        distances = [ sys.maxsize for _ in range(V) ]
        distances[k] = 0
        pq = []
        heapq.heappush(pq, (0, k))
        while pq:
            src_dist, src_node = heapq.heappop(pq)
            if distances[src_node] < src_dist: continue
            for neighbor, weight in adj[src_node]:
                if src_dist + weight < distances[neighbor]:
                    distances[neighbor] = src_dist + weight
                    heapq.heappush(pq, (distances[neighbor], neighbor))
        max_dist = max(distances[1:])
        return -1 if max_dist == sys.maxsize else max_dist

def test():
    assert [ 0 for _ in range(3) ] == [0,0,0]
    assert min([1,2,3]) == 1
    sol = Solution()
    adj = sol.buildAdj([[2,1,1],[2,3,1],[3,4,1]], 4)
    assert sorted(adj[2]) == [(1,1), (3,1)]
    assert sol.networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2) == 2
    assert sol.networkDelayTime([[1,2,1]], 2, 1) == 1
    assert sol.networkDelayTime([[1,2,1]], 2, 2) == -1