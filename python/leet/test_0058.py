class SolutionA:
    def lengthOfLastWord(self, s: str) -> int:
        l = s.split(' ')
        while l:
            cur = l.pop()
            if len(cur) > 0:
                return len(cur)

def testA():
    sol = SolutionA()
    assert sol.lengthOfLastWord("Hello World") == 5
    assert sol.lengthOfLastWord("   fly me   to   the moon  ") == 4
    assert sol.lengthOfLastWord("luffy is still joyboy") == 6
    assert sol.lengthOfLastWord("a") == 1
    assert sol.lengthOfLastWord("a ") == 1
    assert sol.lengthOfLastWord(" day") == 3

# runtime: 100.00%
# memory: 60.60%