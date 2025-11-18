# https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/

from typing import List
from collections import deque

AdjacencyList = List[List[int]]
    
def bfs(adjl: AdjacencyList):
    V = len(adjl)
    visited = [False] * V 
    res = []
    def go(start):
        q = deque([start])
        visited[start] = True
        while q:
            node = q.popleft()
            res.append(node)
            for neighbor in adjl[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    q.append(neighbor)
    for start in range(V):
        if not visited[start]:
            go(start)
    return res

def test():
    assert bfs([[2,3],[2],[0,1],[0],[5],[4]]) == [0,2,3,1,4,5]
    assert bfs([[1,2],[3],[3],[]]) == [0,1,2,3]
    assert bfs([]) == []
    assert bfs([[]]) == [0]
    assert bfs([[], []]) == [0, 1]
    assert bfs([[1], [0, 2], [1]]) == [0, 1, 2]
    assert bfs([[1, 2, 3], [0], [0], [0]]) == [0, 1, 2, 3]
    assert bfs([[1, 2], [0, 2], [0, 1]]) == [0, 1, 2]
    assert bfs([[1], [0], [], [4], [3]]) == [0, 1, 2, 3, 4]