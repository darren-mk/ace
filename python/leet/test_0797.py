# https://leetcode.com/problems/all-paths-from-source-to-target

from typing import List

Ind = int
Adj = List[List[Ind]]
Path = List[Ind]
Paths = List[Path]

class SolutionA:
    def allPathsSourceTarget(self, graph: Adj) -> Paths:
        n = len(graph)
        target = n - 1
        res: Paths = []
        path: Path = [0]

        def dfs(node: int):
            if node == target:
                res.append(path.copy())
                return
            for dst in graph[node]:
                path.append(dst)
                dfs(dst)
                path.pop()

        dfs(0)
        return res

def testA():
    sol = SolutionA()
    graph: Adj = [[1, 2], [3], [3], []]
    expected = [[0, 1, 3], [0, 2, 3]]
    assert sol.allPathsSourceTarget(graph) == expected
    graph = [[4, 3, 1], [3, 2, 4], [3], [4], []]
    expected = [
        [0, 4],
        [0, 3, 4],
        [0, 1, 3, 4],
        [0, 1, 2, 3, 4],
        [0, 1, 4], ]
    assert sol.allPathsSourceTarget(graph) == expected

# Runtime Beats 66.22%
# Memory Beats 33.01%

class SolutionB:
    def allPathsSourceTarget(self, graph: Adj) -> Paths:
        return [[1]]

def testB():
    sol = SolutionB()
    graph: Adj = [[4, 3, 1], [3, 2, 4], [3], [4], []]
    expected = [
        [0, 4],
        [0, 3, 4],
        [0, 1, 3, 4],
        [0, 1, 2, 3, 4],
        [0, 1, 4], ]
    assert sol.allPathsSourceTarget(graph) == expected