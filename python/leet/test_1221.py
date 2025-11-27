class SolutionA:
    def balancedStringSplit(self, s: str) -> int:
        count = 0
        L = 0
        R = 0
        for c in s:
            if c == 'L':
                L += 1
            elif c == 'R':
                R += 1
            if L == R:
                count += 1
        return count

def testA():
    sol = SolutionA()
    assert sol.balancedStringSplit("RLRRLLRLRL") == 4
    assert sol.balancedStringSplit("RLRRRLLRLL") == 2
    assert sol.balancedStringSplit("LLLLRRRR") == 1

# time: O(N)
# space: O(1)
# runtime: 16.61%
# memory: 48.46%