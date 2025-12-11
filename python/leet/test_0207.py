from collections import deque
from typing import Dict, List

Adj = List[int]
Adjs = List[Adj]
PreReq = List[List[int]]

class SolutionA:
    def buildAdjs(self, numCourses: int, prerequisites: PreReq) -> Adjs:
        adjs = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            adjs[b].append(a)
        return adjs
    def canFinish(self, numCourses: int, prerequisites: PreReq) -> bool:
        pass

def testA():
    sol = SolutionA()
    assert sol.buildAdjs(2,[[1, 0]]) == [[1],[]]
    assert sol.canFinish(2,[[1, 0]]) is True
    assert sol.canFinish(2, [[1, 0], [0, 1]]) is False
    assert sol.canFinish(1, []) is True
    assert sol.canFinish(3, []) is True
    assert sol.canFinish(3, [[1, 0], [2, 1]]) is True
    assert sol.canFinish(3, [[1, 0], [2, 1], [0, 2]]) is False
    print(sol.buildAdjs(20, [[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]) )


def build_adj(n: int, edges: List[List[int]]) -> Dict[int, List[int]]:
    adj = {i:[] for i in range(n)}
    for a, b in edges:
        adj[a].append(b)
        adj[b].append(a)
    return adj

def test_build_adj():
    assert build_adj(3, []) == {0: [], 1: [], 2: []}
    out = build_adj(4, [[0,1],[1,2]])
    assert set(out[0]) == {1}
    assert set(out[1]) == {0,2}
    assert set(out[2]) == {1}
    assert set(out[3]) == set()
    out2 = build_adj(1, [])
    assert out2 == {0: []}

def bfs_traversal(n: int, edges: List[List[int]]) -> List[int]:
    adj = build_adj(n, edges)
    visited = [False for _ in range(n)]
    res = []
    q = deque()
    q.append(0)
    visited[0] = True
    while q:
        node = q.popleft()
        res.append(node)
        for neighbor in adj[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                q.append(neighbor)
    return res

def test_bfs():
    assert bfs_traversal(1, []) == [0]
    out = bfs_traversal(4, [[0,1],[1,2],[1,3]])
    assert out == [0,1,2,3] or out == [0,1,3,2]
    out2 = bfs_traversal(4, [[1,2],[2,3]])
    assert out2 == [0]  # 0 isolated
    out3 = bfs_traversal(5, [[0,1],[2,3]])
    assert out3 == [0,1]


def count_components(n: int, edges: List[List[int]]) -> int:
    adj = build_adj(n, edges)
    visited = [False for _ in range(n)]
    def go(start):
        visited[start] = True
        for neighbor in adj[start]:
            if not visited[neighbor]:
                go(neighbor)
    count = 0
    for node in range(n):
        if not visited[node]:
            count += 1
            go(node)
    return count

def test_components():
    assert count_components(1, []) == 1
    assert count_components(3, []) == 3
    assert count_components(4, [[0,1],[2,3]]) == 2
    assert count_components(5, [[0,1],[2,3]]) == 3
    assert count_components(4, [[0,1],[1,2],[2,3]]) == 1

def is_reachable(n: int, edges: List[List[int]], src: int, dst: int) -> bool:
    adj = build_adj(n, edges)
    visited = [False for _ in range(n)]
    found = False
    def go(start):
        nonlocal found
        if start == dst:
            found = True
            return
        visited[start] = True
        for neighbor in adj[start]:
            if not visited[neighbor]:
                visited[neighbor] = True
                go(neighbor)
    go(src)
    return found

def test_is_reachable():
    assert is_reachable(4, [[0,1],[1,2],[2,3]], 0, 3) is True
    assert is_reachable(4, [[1,2],[2,3]], 0, 3) is False
    assert is_reachable(5, [[0,1],[1,2],[3,4]], 3, 4) is True
    assert is_reachable(5, [[0,1],[1,2],[3,4]], 2, 4) is False
    assert is_reachable(1, [], 0, 0) is True

def find_path(n: int, edges: List[List[int]], src: int, dst: int) -> List[int]:
    adj = build_adj(n, edges)
    res = []
    visited = [False for _ in range(n)]
    def go(start, path):
        nonlocal res
        visited[start] = True
        if start == dst:
            res = path
            return
        for neighbor in adj[start]:
            if not visited[neighbor]:
                visited[neighbor] = True
                go(neighbor, path + [neighbor])
    go(src, [src])
    return res

def test_find_path():
    assert find_path(1, [], 0, 0) == [0]
    out1 = find_path(4, [[0,1],[1,2],[2,3]], 0, 3)
    assert out1 == [0,1,2,3]
    out2 = find_path(4, [[1,2],[2,3]], 0, 3)
    assert out2 == []
    out3 = find_path(5, [[0,1],[1,2],[2,3],[3,4]], 1, 3)
    assert out3 == [1,2,3]
    out4 = find_path(5, [[0,1],[0,2],[2,3],[3,4]], 0, 4)
    assert out4[0] == 0 and out4[-1] == 4

def has_cycle(n: int, edges: List[List[int]]) -> bool:
    adj = build_adj(n, edges)
    visited = [False for _ in range(n)]
    cycled = False
    def go(start, parent):
        nonlocal cycled
        visited[start] = True
        for neighbor in adj[start]:
            if visited[neighbor] and neighbor != parent:
                cycled = True
                return
            if not visited[neighbor]:
                go(neighbor, start)
    for node in range(n):
        if not visited[node]:
            go(node, None)
    return cycled

def test_has_cycle():
    assert has_cycle(3, [[0,1],[1,2]]) is False
    assert has_cycle(3, [[0,1],[1,2],[2,0]]) is True
    assert has_cycle(4, [[0,1],[1,2],[2,3],[3,0],[0,2]]) is True
    assert has_cycle(4, [[0,1],[2,3]]) is False
    assert has_cycle(1, []) is False

def build_adj_directed(n, edges):
    adj = {i: [] for i in range(n)}
    for a, b in edges:
        adj[a].append(b)   # only one direction
    return adj

def has_cycle_directed(n: int, edges: List[List[int]]) -> bool:
    adj = build_adj_directed(n, edges)
    visited = [None for _ in range(n)]
    cycled = False
    def go(start, flag):
        nonlocal cycled
        visited[start] = flag
        for neighbor in adj[start]:
            if visited[neighbor] == flag:
                cycled = True
                return
            if visited[neighbor] != flag:
                go(neighbor, flag)
    for node in range(n):
        if not visited[node]:
            go(node, node)
    return visited

def test_has_cycle_directed():
    # simple chain, no cycle: 0 -> 1 -> 2
    assert has_cycle_directed(3, [[0,1],[1,2]]) is False
    # simple directed cycle: 0 -> 1 -> 2 -> 0
    assert has_cycle_directed(3, [[0,1],[1,2],[2,0]]) is True
    # diamond shape, no cycle:
    # 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
    assert has_cycle_directed(4, [[0,1],[0,2],[1,3],[2,3]]) is False
    # # multiple components, one has cycle:
    # # component1: 0 -> 1 -> 2 -> 0  (cycle)
    # # component2: 3 -> 4 (no cycle)
    # assert has_cycle_directed(5, [[0,1],[1,2],[2,0],[3,4]]) is True
    # # single node, self-loop
    # assert has_cycle_directed(1, [[0,0]]) is True
    # # single node, no edges
    # assert has_cycle_directed(1, []) is False

