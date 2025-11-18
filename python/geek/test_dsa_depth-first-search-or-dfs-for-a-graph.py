# https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

from typing import List

AdjacencyList = List[List[int]]

def dfs(adjl:AdjacencyList) -> List[int]:
    V = len(adjl)
    visited = [False] * V 
    res = []
    def go(start):
        visited[start] = True
        res.append(start)
        for neighbor in adjl[start]:
            if not visited[neighbor]:
                go(neighbor)
    for start in range(V):
        if not visited[start]:
            go(start)
    return res

def test():
    assert dfs([[1], [0, 2], [1], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs([[1, 2], [0], [0], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs([[2, 3], [2], [0, 1], [0], [5], [4]]) == [0, 2, 1, 3, 4, 5]                            