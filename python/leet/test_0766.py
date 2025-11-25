from typing import List

class SolutionA:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m-1):
            for j in range(n-1):
                if matrix[i][j] != matrix[i+1][j+1]:
                    return False
        return True

def testA():
   sol = SolutionA()
   assert sol.isToeplitzMatrix([[1,2,3,4],[5,1,2,3],[9,5,1,2]]) == True
   assert sol.isToeplitzMatrix([[1,2],[2,2]]) == False

# time: O(m * n)
# space: O(1)
# Runtime Beats 100.00%
# Memory Beats 76.31%