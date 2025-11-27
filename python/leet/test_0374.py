
class SolutionA:
    def __init__(self, pick):
        self.pick = pick
    def guess(self, num: int) -> int:
        if num > self.pick:
            return -1
        elif num < self.pick:
            return 1
        return 0
    def guessNumber(self, n: int) -> int:
        bottom = 1
        ceiling = n
        while bottom <= ceiling:
            mid = (bottom + ceiling) // 2
            guessed = self.guess(mid)
            if guessed == 0:
                return mid
            elif guessed == -1:
                ceiling = mid - 1
            else:
                bottom = mid + 1

def testA():
    sol = SolutionA(pick=6)
    assert sol.guessNumber(10) == 6
    sol = SolutionA(pick=1)
    assert sol.guessNumber(1) == 1
    sol = SolutionA(pick=1)
    assert sol.guessNumber(2) == 1

# runtime: 86.67%
# memory: 6.65%