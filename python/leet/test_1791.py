# https://leetcode.com/problems/find-center-of-star-graph

from typing import Dict, List, Optional

Edges = List[List[int]]

class SolutionA:
    def findCenter(self, edges: Edges) -> Optional[int]:
        count: Dict[int, int] = dict()
        for src, dst in edges:
            count[src] = count.get(src, 0) + 1
            count[dst] = count.get(dst, 0) + 1
        for k, v in count.items():
            if v == len(edges):
                return k

def test_a():
    s = SolutionA()
    assert s.findCenter([[1,2],[2,3],[4,2]]) == 2
    assert s.findCenter([[1,2],[5,1],[1,3],[1,4]]) == 1

class SolutionB:
    def findCenter(self, edges: Edges) -> Optional[int]:
        a, b = edges[0]
        c, d = edges[1]
        return c if c in [a, b] else d

def test_b():
    s = SolutionB()
    assert s.findCenter([[1,2],[2,3],[4,2]]) == 2
    assert s.findCenter([[1,2],[5,1],[1,3],[1,4]]) == 1