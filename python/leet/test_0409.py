class SolutionA:
    def longestPalindrome(self, s: str) -> int:
        memo = {}
        for c in s:
            if c in memo:
                memo[c] += 1
            else:
                memo[c] = 1
        pairs = 0
        single = 0
        for k, v in memo.items():
            pairs += v // 2
            if single == 0:
               single = v % 2
        return single + (pairs * 2)

def testA():
    sol = SolutionA()
    # examples from the problem
    assert sol.longestPalindrome("abccccdd") == 7
    assert sol.longestPalindrome("a") == 1
    # all same character
    assert sol.longestPalindrome("aaaa") == 4
    # no pair at all (all unique)
    assert sol.longestPalindrome("abc") == 1
    # mixed pairs + one odd
    assert sol.longestPalindrome("aaabbbb") == 7   # "babbabb" etc.
    # case sensitivity check
    assert sol.longestPalindrome("Aa") == 1        # cannot use both
    # multiple odds -> only one odd can be center
    # counts: a:3, b:3, c:2  -> 3+3+2 = 8, but longest palindrome is 7
    assert sol.longestPalindrome("aaabbbcc") == 7

# runtime: 100.00%
# memory: 94.54%