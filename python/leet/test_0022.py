from typing import List

class SolutionA:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def go(s, open, close):
            if open < close or n < open:
                return
            elif n == open and open == close:
                res.append(s)
                return
            else:
                go(s + ')', open, close + 1)
                go(s + '(', open + 1, close)
        go("(", 1, 0)
        return res

def testA():
    sol = SolutionA()
    assert sorted(sol.generateParenthesis(1)) == ["()"]
    assert sorted(sol.generateParenthesis(3)) == sorted([
        "((()))", "(()())", "(())()",
        "()(())", "()()()", ])

# time:  O(C_n * n)  where C_n is the nth Catalan number (~ 4^n / (n^(3/2)))
# space: O(C_n * n) for results, O(n) recursion stack
# runtime: 43.03%
# memory: 26.27%