# https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

from typing import List, Deque
from collections import deque

AdjacencyList = List[List[int]]

def iterative_approach(adj:AdjacencyList) -> List[int]:
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

def test_iterative_approach():
    assert iterative_approach([[1], [0, 2], [1], [4], [3]]) == [0, 1, 2, 3, 4]
    assert iterative_approach([[1, 2], [0], [0], [4], [3]]) == [0, 1, 2, 3, 4]
    assert iterative_approach([[2, 3], [2], [0, 1], [0], [5], [4]]) == [0, 2, 1, 3, 4, 5]

def recursive_approach(adj:AdjacencyList) -> List[int]:
    # to write
    return [1]

def test_recursive_approach():
    assert recursive_approach([[1], [0, 2], [1], [4], [3]]) == [0, 1, 2, 3, 4]
    assert recursive_approach([[1, 2], [0], [0], [4], [3]]) == [0, 1, 2, 3, 4]
    assert recursive_approach([[2, 3], [2], [0, 1], [0], [5], [4]]) == [0, 2, 1, 3, 4, 5]
