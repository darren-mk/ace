from typing import List
import copy

class SolutionA:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m = len(img)
        n = len(img[0])
        res = [[0] * n for _ in range(m)]
        def getAvg(i, j):
            s = 0
            cnt = 0
            for x in (i-1, i, i+1):
                for y in (j-1, j, j+1):
                    if 0 <= x < m and 0 <= y < n:
                        s += img[x][y]
                        cnt += 1
            return s // cnt
        for i in range(m):
            for j in range(n):
                res[i][j] = getAvg(i,j)
        return res

# ai helped write getAvg fn
# runtime: 67.42%
# memory: 29.50%