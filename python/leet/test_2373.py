from typing import List

class SolutionA:
    def findMaxVal(self, grid:List[List[int]]) -> int:
        cand = grid[0][0]
        for row in grid:
            for x in row:
                cand = max(cand, x)
        return cand
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        res = []
        for i in range(n-2):
            row = []
            for j in range(n-2):
                window = [r[j:j+3] for r in grid[i:i+3]]
                row.append(self.findMaxVal(window))
            res.append(row)
        return res

def testA():
    sol = SolutionA()
    grid1 = [
        [9, 9, 8, 1],
        [5, 6, 2, 6],
        [8, 2, 6, 4],
        [6, 2, 2, 2], ]
    assert sol.largestLocal(grid1) == [
        [9, 9],
        [8, 6], ]
    grid2 = [
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 2, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1], ]
    assert sol.largestLocal(grid2) == [
        [2, 2, 2],
        [2, 2, 2],
        [2, 2, 2], ]
    grid3 = [
        [1, 2, 3],
        [5, 6, 7],
        [9, 8, 4], ]
    assert sol.largestLocal(grid3) == [[9]]
    grid4 = [
        [5, 5, 5, 5],
        [5, 5, 5, 5],
        [5, 5, 5, 5],
        [5, 5, 5, 5], ]
    assert sol.largestLocal(grid4) == [
        [5, 5],
        [5, 5], ]

# runtime: 16.74%
# memory: 96.85%