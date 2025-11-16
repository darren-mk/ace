# https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

from typing import List, Deque
from collections import deque

AdjacencyList = List[List[int]]

def dfs_connected(adj:AdjacencyList):
    visited: List[bool] = [False] * len(adj) 
    res: List[int] = []
    stack: Deque[int] = deque()
    visited[0] = True 
    stack.append(0)
    while stack:
        cursor = stack.pop()
        res.append(cursor)
        for dst in reversed(adj[cursor]):
            if not visited[dst]:
                visited[dst] = True
                stack.append(dst)
    return res 

def test_dfs_connected():
    assert dfs_connected([[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]) == [0, 1, 2, 3, 4]

def dfs_disconnected(adj:AdjacencyList):
    visited: List[bool] = [False] * len(adj) 
    res: List[int] = []
    
    def f(src: int, stack: Deque[int]):
        visited[src] = True 
        stack.append(src)
        while stack:
            cursor = stack.pop()
            res.append(cursor)
            for dst in reversed(adj[cursor]):
                if not visited[dst]:
                    visited[dst] = True
                    stack.append(dst)

    for i in range(len(adj)):
        if not visited[i]:
            stack: Deque[int] = deque()
            f(i, stack)

    return res

def test_dfs_disconnected():
    assert dfs_disconnected([[1], [0, 2], [1], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs_disconnected([[1, 2], [0], [0], [4], [3]]) == [0, 1, 2, 3, 4]
    assert dfs_disconnected([[2, 3], [2], [0, 1], [0], [5], [4]]) == [0, 2, 1, 3, 4, 5]