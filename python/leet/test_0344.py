from typing import List

class SolutionA:
    def reverseString(self, s: List[str]) -> None:
        temp = ''
        n = len(s)
        half = n // 2
        for i in range(half):
            temp = s[i]
            s[i] = s[n-1-i]
            s[n-1-i] = temp

def testA():
    sol = SolutionA()
    s1 = ["h","e","l","l","o"]
    sol.reverseString(s1)
    assert s1 == ["o","l","l","e","h"]
    s2 = ["H","a","n","n","a","h"]
    sol.reverseString(s2)
    assert s2 == ["h","a","n","n","a","H"]
    s3 = ["a"]
    sol.reverseString(s3)
    assert s3 == ["a"]
    s4 = ["a","b","c","d"]
    sol.reverseString(s4)
    assert s4 == ["d","c","b","a"]
    s5 = ["x","y","z"]
    sol.reverseString(s5)
    assert s5 == ["z","y","x"]
    s6 = ["a","a","a"]
    sol.reverseString(s6)
    assert s6 == ["a","a","a"]

# runtime: 100.00%
# memory: 82.61%