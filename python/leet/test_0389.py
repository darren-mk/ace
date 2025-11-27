class SolutionA:
    def findTheDifference(self, s: str, t: str) -> str:
        acc = 0
        for c in t:
            acc ^= ord(c)
        for c in s:
            acc ^= ord(c)
        return chr(acc)

def testA():
    assert ord('a') == 97
    assert chr(97) == 'a'
    sol = SolutionA()
    assert sol.findTheDifference("abcd", "abcde") == "e"
    assert sol.findTheDifference("", "y") == "y"
    assert sol.findTheDifference("a", "aa") == "a"
    assert sol.findTheDifference("ae", "aea") == "a"

# time: O(m+n)
# space: O(1)
# runtime: 100.00%
# memory: 69.61%