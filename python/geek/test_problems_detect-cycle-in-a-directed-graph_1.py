# https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

from typing import List, Deque
from collections import deque

class Solution:
    def isCyclic(self, V: int, edges: List[List[int]]):
        visited: List[int] = [False] * V
        q: Deque[int] = deque()
        visited[0] = True
        q.append(0)
        while q:
            cursor: int = q.popleft()
            for dst in edges[cursor]:
                if visited[dst]:
                    return True
                else:
                    visited[dst] = True
                    q.append(dst)
        return False
    
def test_isCyclic():
    solution = Solution()
    assert solution.isCyclic(4, [[1], [2], [0, 3], []]) == True
    assert solution.isCyclic(3, [[2], [0], []]) == False