# https://leetcode.com/problems/find-if-path-exists-in-graph

from collections import deque
from typing import Deque, Dict, List, Set

Edges = List[List[int]]
AdjsDict = Dict[int, Set[int]]
AdjsList = List[List[int]]

class SolutionA:
    
    def to_adjs(self, edges: Edges) -> AdjsDict:
        adjs: AdjsDict = dict()
        for u, v in edges:
            adjs.setdefault(u, set()).add(v)
            adjs.setdefault(v, set()).add(u)
        return adjs
    
    def validPath(self, n: int, edges: Edges, source: int, destination: int) -> bool:

        # declare
        adjs: AdjsDict = self.to_adjs(edges)
        visited: List[bool] = [False] * n
        q: Deque[int] = deque() 

        # init values
        q.append(source)
        visited[source] = True
        
        # iterate
        while q: 
            src = q.popleft()
            for dst in adjs.get(src, set()):
                if not visited[dst]:
                    q.append(dst)
                    visited[dst] = True

        # conclue
        return visited[destination]

def test_a():
    sol = SolutionA()
    assert sol.to_adjs([[0, 1], [1, 2], [2, 0]]) == {
        0: {1, 2},
        1: {0, 2},
        2: {0, 1}, }
    assert sol.validPath(3, [[0, 1], [1, 2], [2, 0]], 0, 2) is True
    assert sol.validPath(6, [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]], 0, 5) is False
    assert sol.validPath(1, [], 0, 0) is True
    assert sol.validPath(3, [], 0, 2) is False
    assert sol.validPath(5, [[0, 1], [1, 2], [2, 3], [3, 4]], 0, 4) is True
    assert sol.validPath(6, [[0, 1], [1, 2], [3, 4]], 0, 4) is False

# Runtime Beats 49.82%
# Memory Beats 46.88%

class SolutionB:
    
    def to_adjs(self, n: int, edges: Edges) -> AdjsList:
        adjs: AdjsList = [[] for _ in range(n)]
        for u, v in edges:
            adjs[u].append(v)
            adjs[v].append(u)
        return adjs
    
    def validPath(self, n: int, edges: Edges, source: int, destination: int) -> bool:

        # declare
        adjs: AdjsList = self.to_adjs(n, edges)
        visited: List[bool] = [False] * n
        q: Deque[int] = deque() 

        # init values
        q.append(source)
        visited[source] = True
        
        # iterate
        while q: 
            src: int = q.popleft()
            for dst in adjs[src]:
                if not visited[dst]:
                    q.append(dst)
                    visited[dst] = True

        # conclue
        return visited[destination]

def test_check_b():
    assert [[]] * 3 == [[],[],[]]

def test_b():
    sol = SolutionB()
    assert sol.to_adjs(3, [[0, 1], [1, 2], [2, 0]]) == [[1, 2], [0, 2], [1, 0]]
    assert sol.validPath(3, [[0, 1], [1, 2], [2, 0]], 0, 2) is True
    assert sol.validPath(6, [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]], 0, 5) is False
    assert sol.validPath(1, [], 0, 0) is True
    assert sol.validPath(3, [], 0, 2) is False
    assert sol.validPath(5, [[0, 1], [1, 2], [2, 3], [3, 4]], 0, 4) is True
    assert sol.validPath(6, [[0, 1], [1, 2], [3, 4]], 0, 4) is False

# Runtime Beats 67.06%
# Memory Beats 96.26%