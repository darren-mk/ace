from typing import List

class SolutionA:
    def findChampion(self, grid: List[List[int]]) -> int:
        champ = None
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i != j:
                    if grid[i][j] == 1:
                        champ = i
                    else:
                        champ = None
                        break
            if champ is not None:
                return champ

def testA():
    sol = SolutionA()
    assert sol.findChampion([[0,1],[0,0]]) == 0
    assert sol.findChampion([[0,0,1],
                             [1,0,1],
                             [0,0,0]]) == 1

# time: O(n^2)
# space: O(1)
# runtime: 43.97%
# memory: 75.89%

class SolutionB:
    def findChampion(self, grid: List[List[int]]) -> int:
        n = len(grid)
        cand = 0
        for i in range(1, n):
            if grid[i][cand] == 1:  # i beats cand
                cand = i
        return cand

def testB():
    sol = SolutionB()
    assert sol.findChampion([[0,1],[0,0]]) == 0
    assert sol.findChampion([[0,0,1],
                             [1,0,1],
                             [0,0,0]]) == 1

# time: O(n)
# space: O(1)
# runtime: 100.00%
# memory: 75.89%