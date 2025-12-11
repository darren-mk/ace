from typing import List

class SolutionA:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        def go(i, j):
            if i < 0 or j < 0 or i > m-1 or j > n-1 or grid[i][j] != "1":
                return
            grid[i][j] = "$"
            go(i-1, j)
            go(i, j-1)
            go(i+1, j)
            go(i, j+1)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    go(i,j)
                    count += 1
        return count

def testA():
    sol = SolutionA()
    grid1 = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"], ]
    assert sol.numIslands(grid1) == 1
    grid2 = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"], ]
    assert sol.numIslands(grid2) == 3

# O(m * n)
# O(1)
# runtime: 76.47%
# memory: 95.35%