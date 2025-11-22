from typing import List

class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        count = 0
        for pattern in patterns:
            if pattern in word:
                count += 1
        return count

def test():
    assert "bc" in "abc"
    assert "d" not in "abc"
    solution = Solution()
    assert solution.numOfStrings(["a","abc","bc","d"], "abc") == 3
    assert solution.numOfStrings(["a","b","c"], "aaaaabbbbb") == 2
    assert solution.numOfStrings(["a","a","a"], "ab") == 3