class SolutionA:
    def arrangeCoins(self, n: int) -> int:
        i = 1
        count = 0
        while n >= i:
            n -= i
            i += 1
            count += 1
        return count

def testA():
    sol = SolutionA()
    assert sol.arrangeCoins(5) == 2
    assert sol.arrangeCoins(8) == 3

# runtime: 13.93%
# memory: 52.59%