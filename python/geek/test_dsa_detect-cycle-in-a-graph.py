# https://www.geeksforgeeks.org/dsa/detect-cycle-in-a-graph/

from typing import List, Deque
from collections import deque

def dfs_approach(adj: List[List[int]]):
    visited: List[int] = [False] * len(adj)
    q: Deque[int] = deque()
    visited[0] = True
    q.append(0)
    while q:
        cursor: int = q.popleft()
        for dst in adj[cursor]:
            if visited[dst]:
                return True
            else:
                q.append(dst)
    return False 

def test_dfs_approach():
    assert dfs_approach([[1], [2], [0, 3], []]) == True
    assert dfs_approach([[2], [0], []]) == False