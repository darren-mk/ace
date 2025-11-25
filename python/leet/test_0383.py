class SolutionA:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        memo = {}
        for c in magazine:
            if c in memo:
                memo[c] += 1
            else:
                memo[c] = 1
        for c in ransomNote:
            if c in memo:
                if memo[c] == 0:
                    return False
                else:
                    memo[c] -= 1
            else:
                return False
        return True

def testA():
    sol = SolutionA()
    assert sol.canConstruct("a", "b") is False
    assert sol.canConstruct("aa", "ab") is False
    assert sol.canConstruct("aa", "aab") is True

# time: O(m+n)
# space: O(1)
# Runtime Beats 24.43%
# Memory Beats 81.84%

class SolutionB:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        memo = {}
        for c in magazine:
            memo[c] = memo.get(c,0) + 1
        for c in ransomNote:
            if memo.get(c, 0) == 0:
                return False
            memo[c] -= 1
        return True

def testB():
    sol = SolutionB()
    assert sol.canConstruct("a", "b") is False
    assert sol.canConstruct("aa", "ab") is False
    assert sol.canConstruct("aa", "aab") is True

# time: O(m+n)
# space: O(1)
# Runtime Beats 46.69%
# Memory Beats 13.09%