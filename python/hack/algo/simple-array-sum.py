# https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true

from functools import reduce

# 1
def f1(ar):
    def add_both(a, b): return a + b
    return reduce(add_both, ar)
f1([1, 2, 3, 4, 10, 11]) == 31
