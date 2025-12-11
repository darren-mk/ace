# Q1 — Generate all binary strings of length n
# Problem:
# Given an integer n, generate all binary strings of length n (each position is either '0' or '1').
# Example:
# Input: n = 2
# Output: ["00", "01", "10", "11"]
# Goal:
# Write a backtracking function go(pos, acc) that fills each position with '0' and '1'.

def f(n):
    res = []
    def go(pos=0, acc=''):
        if pos == n:
            res.append(acc[:])
            return
        go(pos+1, acc+str('0'))
        go(pos+1, acc+str('1'))
    go()
    return res