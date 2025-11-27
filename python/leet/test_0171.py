class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        l = list(columnTitle)
        acc = 0
        decimal = 1
        UNIT = 26
        while l:
            cur = l.pop()
            acc += (ord(cur) - 64) * decimal
            decimal *= UNIT
        return acc

# runtime: 100.00%
# memory: 79.79%