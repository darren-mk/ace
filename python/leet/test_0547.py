# https://leetcode.com/problems/number-of-provinces/?envType=problem-list-v2&envId=graph

from collections import deque
from typing import Deque, List

class SolutionA:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        V = len(isConnected)
        visited: List[bool] = [False] * V
        
        def bfs(src: int):
            q: Deque[int] = deque()
            q.append(src)
            visited[src] = True
            while q: 
                cur = q.popleft()
                for j in range(V):
                    if isConnected[cur][j] == 1 and not visited[j]:
                        visited[j] = True
                        q.append(j)
        
        province_count = 0
        for i in range(V):
            if visited[i] is False:
                province_count += 1
                bfs(i)
        return province_count

def test_a():
    s = SolutionA()
    assert s.findCircleNum([[1,1,0],[1,1,0],[0,0,1]]) == 2
    assert s.findCircleNum([[1,0,0],[0,1,0],[0,0,1]]) == 3

# Runtime Beats 56.25%
# Memory Beats 58.73%