from typing import List

class SolutionA:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        acc = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    top = grid[i-1][j] if i > 0 else 0
                    left = grid[i][j-1] if j > 0 else 0
                    right = grid[i][j+1] if j < n - 1 else 0
                    bottom = grid[i+1][j] if i < m - 1 else 0
                    delta = 4 - (top + left + right + bottom)
                    acc += delta
        return acc

def test_a():
    sol = SolutionA()
    assert sol.islandPerimeter([[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]) == 16

# time: O(m * n)
# space: O(1)
# runtime: 58.46%
# memory: 95.95%