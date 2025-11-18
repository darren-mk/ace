# https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/

from typing import List
from collections import deque

AdjacencyList = List[List[int]]
    
def bfs(adjl: AdjacencyList):
    V = len(adjl)
    visited = [False] * V
    res = []
    def go(src):
        q = deque()
        q.append(src)
        visited[src] = True
        while q:
            cur = q.popleft()
            res.append(cur)
            for dst in adjl[cur]:
                if not visited[dst]:                    
                    visited[dst] = True
                    q.append(dst)
    for src in range(V):
        if not visited[src]:
            go(src)
    return res

def test_bfs():
    # given tests
    assert bfs([[2,3],[2],[0,1],[0],[5],[4]]) == [0,2,3,1,4,5]
    assert bfs([[1,2],[3],[3],[]]) == [0,1,2,3]
    # 1. empty graph
    assert bfs([]) == []
    # 2. single node, no edges
    assert bfs([[]]) == [0]
    # 3. two isolated nodes
    assert bfs([[], []]) == [0, 1]
    # 4. simple line: 0 - 1 - 2
    assert bfs([[1], [0, 2], [1]]) == [0, 1, 2]
    # 5. star graph centered at 0: 0 - 1, 0 - 2, 0 - 3
    assert bfs([[1, 2, 3], [0], [0], [0]]) == [0, 1, 2, 3]
    # 6. simple cycle: 0 - 1 - 2 - 0
    assert bfs([[1, 2], [0, 2], [0, 1]]) == [0, 1, 2]
    # 7. multiple components, including isolated node
    # component 1: 0 - 1
    # component 2: {2} alone
    # component 3: 3 - 4
    assert bfs([[1], [0], [], [4], [3]]) == [0, 1, 2, 3, 4]