class SolutionA:
    def isPalindrome(self, s: str) -> bool:
        trimmed = []
        for c in s:
            if c.isalpha() or c.isnumeric():
                trimmed.append(c.lower())
        return trimmed == trimmed[::-1]

def testA():
    assert 'a'.isalpha() == True
    sol = SolutionA()
    assert sol.isPalindrome("A man, a plan, a canal: Panama") == True
    assert sol.isPalindrome("race a car") == False
    assert sol.isPalindrome(" ") == True
    assert sol.isPalindrome("0P") == False

# Runtime Beats 36.10%
# Memory Beats 5.12%