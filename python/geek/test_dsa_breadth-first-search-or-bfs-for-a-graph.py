# https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/

from typing import List, Deque
from collections import deque

AdjacencyList = List[List[int]]

def bfs_connected(adj: AdjacencyList) -> List[int]:
    res: List[int] = []
    visited: List[bool] = [False] * len(adj)
    q: Deque[int] = deque()
    visited[0] = True 
    q.append(0)
    while q:
        cursor = q.popleft()
        res.append(cursor)
        for dst in adj[cursor]:
            if not visited[dst]:
                visited[dst] = True
                q.append(dst)
    return res

def test_bfs_connected():
    assert bfs_connected([[1,2],[0,2],[0,1,3,4],[2],[2]]) == [0,1,2,3,4]
    
def bfs_unconnected(adj: AdjacencyList):

    def recur(src: int, visited: List[bool], res: List[int]):
        q: Deque[int] = deque()
        visited[src] = True
        q.append(src)
        while q:
            cursor = q.popleft()
            res.append(cursor)
            for dst in adj[cursor]:
                if not visited[dst]:
                    visited[dst] = True
                    q.append(dst)
    
    visited = [False] * len(adj)
    res: List[int] = []
    for i in range(len(adj)):
        if not visited[i]:
            recur(i, visited, res)
    return res

def test_bfs_unconnected():
    assert bfs_unconnected([[2,3],[2],[0,1],[0],[5],[4]]) == [0,2,3,1,4,5]