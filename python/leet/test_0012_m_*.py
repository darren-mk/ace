import math
from typing import List

class SolutionA:
    def intToList(self, num:int):
        digits_rev = []
        x = num
        while x > 0:
            digits_rev.append(x % 10)
            x = x // 10
        return digits_rev[::-1]
    def intToRoman(self, num: int) -> str:
        m = {1: 'I',
             5: 'V',
             10: 'X',
             50: 'L',
             100: 'C',
             500: 'D',
             1000: 'M'}
        res = ''
        digits = self.intToList(num)
        n = len(digits)
        for i in range(n):
            raw = digits[i]
            decimal = int(math.pow(10, n - i - 1))
            if raw == 5:
                res = res + m[5 * decimal]
                continue
            if raw == 4:
                res = res + m[decimal] + m[5 * decimal]
                continue
            if raw == 9:
                res = res + m[decimal] + m[10 * decimal]
                continue
            if raw > 5:
                res = res + m[5 * decimal]
                raw -= 5
            c = m[decimal]
            for i in range(1, raw+1):
                res = res + c
        return res

def testA():
    sol = SolutionA()
    assert sol.intToList(135) == [1,3,5]
    assert sol.intToRoman(3749) == "MMMDCCXLIX"
    assert sol.intToRoman(58) == "LVIII"

# runtime: 18.22%
# memory: 5.71%