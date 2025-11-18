# https://leetcode.com/problems/all-paths-from-source-to-target

from typing import List

Adjs = List[List[int]]

class SolutionA:
    def allPathsSourceTarget(self, graph: Adjs) -> List[List[int]]:
        n = len(graph)    
        target = n - 1
        res: List[List[int]] = []
        path: List[int] = [0]

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

def test_a():
    sol = SolutionA()
    # example 1
    graph: Adjs = [[1, 2], [3], [3], []]
    expected = [[0, 1, 3], [0, 2, 3]]
    #assert sol.allPathsSourceTarget(graph) == expected
    # example 2
    graph = [[4, 3, 1], [3, 2, 4], [3], [4], []]
    expected = [
        [0, 4],
        [0, 3, 4],
        [0, 1, 3, 4],
        [0, 1, 2, 3, 4],
        [0, 1, 4],
    ]
    assert sol.allPathsSourceTarget(graph) == expected

    # # direct edge
    # graph = [[1], []]
    # expected = [[0, 1]]
    # assert norm(sol.allPathsSourceTarget(graph)) == norm(expected)

    # # single chain path
    # graph = [[1], [2], [3], []]
    # expected = [[0, 1, 2, 3]]
    # assert norm(sol.allPathsSourceTarget(graph)) == norm(expected)

    # # branch with dead end
    # graph = [[1, 2], [3], [], []]
    # expected = [[0, 1, 3]]
    # assert norm(sol.allPathsSourceTarget(graph)) == norm(expected)