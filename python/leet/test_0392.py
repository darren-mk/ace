from typing import List

class SolutionA:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        cursor = list(s)
        for i in range(len(t)-1, -1, -1):
            if t[i] == cursor[-1]:
                cursor.pop()
                if not cursor:
                    return True
        return False

def test_a():
    abc = list("abc")
    assert abc == ['a', 'b', 'c']
    abc.pop()
    assert abc == ['a', 'b']

    res: List[int] = []
    for i in range(3,-1,-1):
        res.append(i)
    assert res == [3, 2, 1, 0]

    sol = SolutionA()
    assert sol.isSubsequence("a", "a") == True  
    assert sol.isSubsequence("a", "ab") == True  
    assert sol.isSubsequence("ab", "ab") == True
    assert sol.isSubsequence("", "ahbgdc") == True
    assert sol.isSubsequence("abc", "ahbgdc") == True
    assert sol.isSubsequence("axc", "ahbgdc") == False

# Runtime Beats 100.00%
# Memory Beats 91.73%