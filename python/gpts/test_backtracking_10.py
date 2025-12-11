# Backtracking Exercise A4
# Function name: generate_combinations
# Problem:
# Given two integers n and k,
# return all combinations of size k chosen from numbers 1..n
# (no repetition, order inside each combo doesn’t matter).
# Example:
# Input:
# n = 4
# k = 2
# Output (order doesn’t matter):
# [
#   [1,2],
#   [1,3],
#   [1,4],
#   [2,3],
#   [2,4],
#   [3,4],
# ]

def generate_combinations(n, k):
    res = []
    def go(start, begining, acc):
        if len(acc) == k:
            res.append(acc.copy())
            return
        for num in range(start, n+1):
            if begining or start < num:
                acc.append(num)
                go(num, False, acc)
                acc.pop()
    go(1, True, [])
    return res

generate_combinations(4, 2)

def generate_combinations_2(n, k):
    res = []
    def go(start, acc):
        if len(acc) == k:
            res.append(acc[:])
            return
        for num in range(start, n + 1):
            acc.append(num)
            go(num + 1, acc)
            acc.pop()
    go(1, [])
    return res

generate_combinations_2(4, 2)
