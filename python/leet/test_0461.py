class SolutionA:
    def hammingDistance(self, x: int, y: int) -> int:
        return bin(x ^ y).count('1')

def testA():
    assert 1 ^ 4 == 5
    assert 5 % 2 == 1
    assert bin(5) == "0b101"
    assert "0b101"[2:] == "101"
    sol = SolutionA()
    assert sol.hammingDistance(1, 4) == 2
    assert sol.hammingDistance(3, 1) == 1
    assert sol.hammingDistance(0, 0) == 0
    assert sol.hammingDistance(0, 7) == 3
    assert sol.hammingDistance(8, 8) == 0

# time: O(1)
# space: O(1)
# runtime: 100.00%
# memory: 82.49%