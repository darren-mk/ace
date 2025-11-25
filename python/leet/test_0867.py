from typing import List, Set

class SolutionA:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        res = []
        for j in range(len(matrix[0])):
            row = []
            for i in range(len(matrix)):
                row.append(matrix[i][j])
            res.append(row)
        return res

def testA():
    sol = SolutionA()
    assert sol.transpose([[1,2,3],[4,5,6],[7,8,9]]) == [[1,4,7],[2,5,8],[3,6,9]]
    assert sol.transpose([[1,2,3],[4,5,6]]) == [[1,4],[2,5],[3,6]]

# time: O(m * n)
# space: O(m * n)
# rumtime: 100.00%
# memory: 70.93%