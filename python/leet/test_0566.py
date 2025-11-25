from collections import deque
from typing import List

class SolutionA:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        if m * n != r * c:
            return mat
        q = deque()
        for row in mat:
            for item in row:
                q.append(item)
        res = []
        for i in range(r):
            row = []
            for j in range(c):
                if q:
                    row.append(q.popleft())
            if row:
                res.append(row)
        return res

def testA():
    sol = SolutionA()
    assert sol.matrixReshape([[1,2],[3,4]], 1, 4) == [[1,2,3,4]]
    assert sol.matrixReshape([[1,2],[3,4]], 2, 4) == [[1,2],[3,4]]

# time: O(m * n)
# space: O(m * n)
# runtime: 100
# memory: 29.62