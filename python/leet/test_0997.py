# https://leetcode.com/problems/find-the-town-judge

from typing import Dict, List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        does_trust: Dict[int, int] = {}
        is_trusted: Dict[int, int] = {}
        for u,v in trust:
            does_trust[u] = does_trust.get(u, 0) + 1
            is_trusted[v] = is_trusted.get(v, 0) + 1
        for person in range(1, n+1):
            if does_trust.get(person, 0) == 0 and is_trusted.get(person, 0) == n - 1:
                return person
        return -1

def test_a():
    s = Solution()
    assert s.findJudge(2, [[1,2]]) == 2
    assert s.findJudge(3, [[1,3],[2,3]]) == 3
    assert s.findJudge(3, [[1,3],[2,3],[3,1]]) == -1

# Runtime Beats 21.06%
# Memory Beats 41.50%