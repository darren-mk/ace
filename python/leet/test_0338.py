from typing import List

class SolutionA:
    def countBits(self, n: int) -> List[int]:
        res = []
        for i in range(n+1):
            res.append(bin(i).count('1'))
        return res

def testA():
    assert bin(3) == "0b11"
    assert "0b11".count('1') == 2
    sol = SolutionA()
    assert sol.countBits(2) == [0, 1, 1]
    assert sol.countBits(5) == [0, 1, 1, 2, 1, 2]

# time: O(N)
# space: O(N * Log N)
# runtime: 50.88%
# memory: 21.37%