class SolutionA:
    def xorOperation(self, n: int, start: int) -> int:
        acc = []
        for i in range(n):
            acc.append(start + i * 2)
        ans = acc[0]
        for x in acc[1:]:
            ans ^= x
        return ans

def testA():
    sol = SolutionA()
    assert sol.xorOperation(5, 0) == 8
    assert sol.xorOperation(4, 3) == 8

# runtime: 100.00%
# memory: 10.53%

class SolutionB:
    def xorOperation(self, n: int, start: int) -> int:
        ans = start
        for i in range(1, n):
            ans ^= start + (i * 2)
        return ans

def testB():
    sol = SolutionB()
    assert sol.xorOperation(5, 0) == 8
    assert sol.xorOperation(4, 3) == 8

# runtime: 100.00%
# memory: 96.63%