class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        k = 0
        while word * (k + 1) in sequence:
            k += 1
        return k
    
def test():
    assert "ababc"[0:2] == "ab"
    assert "abc" * 2 == "abcabc"
    sol = Solution()
    assert sol.maxRepeating("a", "a") == 1
    assert sol.maxRepeating("ababc", "ab") == 2
    assert sol.maxRepeating("ababc", "ba") == 1
    assert sol.maxRepeating("ababc", "ac") == 0
    assert sol.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba") == 5