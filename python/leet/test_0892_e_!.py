from typing import List, Set

class SolutionA:
    def baseSurfaceArea(self, height):
        if height == 0: return 0
        return 2 + (height * 4)
    def surfaceArea(self, grid: List[List[int]]) -> int:
        m, n, s = len(grid), len(grid[0]), 0
        for i in range(m):
            for j in range(n):
                v = grid[i][j]
                s += self.baseSurfaceArea(v)
                if 0 < i: s -= min(v, grid[i-1][j])
                if i < m - 1: s -= min(v, grid[i+1][j])
                if 0 < j: s -= min(v, grid[i][j-1])
                if j < n - 1: s -= min(v, grid[i][j+1])
        return s

# runtime: 22.27%
# memory: 63.34%