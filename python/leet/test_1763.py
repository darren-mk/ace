class SolutionA:
    def longestNiceSubstring(self, s: str) -> str:
        if len(s) < 2:
            return ""
        st = set(s)
        for i, ch in enumerate(s):
            if ch.lower() not in st or ch.upper() not in st:
                left = self.longestNiceSubstring(s[:i])
                right = self.longestNiceSubstring(s[i+1:])
                return left if len(left) >= len(right) else right
        return s

def testA():
    assert ord('a') == 97
    assert ord('A') == 65
    assert 97 - 65 == 32
    assert len(set()) == 0
    sol = SolutionA()
    assert sol.longestNiceSubstring("YazaAay") == "aAa"
    assert sol.longestNiceSubstring("Bb") == "Bb"
    assert sol.longestNiceSubstring("c") == ""
    assert sol.longestNiceSubstring("cChH") == "cChH" # FAIL