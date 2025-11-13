# https://leetcode.com/problems/divide-two-integers

# 1
class Solution_01:
    def divide(self, dividend: int, divisor: int) -> int:
        # inner vars
        q = 0
        sign = 1 if 0 <= (dividend * divisor) else -1
        divd = abs(dividend)
        divs = abs(divisor)
        # iteration
        while 0 <= divd - divs:
            q += 1
            divd = divd - divs
        # result
        return q * sign
# time limit exceeded
