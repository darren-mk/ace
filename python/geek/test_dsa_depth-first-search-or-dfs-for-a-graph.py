# https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

from typing import List

AdjacencyList = List[List[int]]

def dfs(adjl:AdjacencyList) -> List[int]:
    V = len(adjl)
    visited = [False] * V
    res = []
    def go(src):
        visited[src] = True
        res.append(src)
        for dst in adjl[src]:
            if not visited[dst]:
                go(dst)
    for src in range(V):
        if not visited[src]:
            go(src)
    return res

def test():
    assert dfs([[1], [0, 2], [1], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs([[1, 2], [0], [0], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs([[2, 3], [2], [0, 1], [0], [5], [4]]) == [0, 2, 1, 3, 4, 5]
