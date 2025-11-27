class SolutionA:
    def hammingWeight(self, n: int) -> int:
        return bin(n).count('1')

def testA():
    sol = SolutionA()
    assert sol.hammingWeight(11) == 3 # 1011
    assert sol.hammingWeight(128) == 1 # 10000000
    assert sol.hammingWeight(2147483645) == 30 # 111...1101

# runtime: 100.00%
# memory: 9.87%