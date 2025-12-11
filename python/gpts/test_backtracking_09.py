# Backtracking Exercise A3
# Function name: generate_non_decreasing_sequences
# Problem:
# Given:
# an integer k
# an integer n
# Generate all non-decreasing sequences of length n,
# where each element is from 1 to k.
# “Non-decreasing” means:
# a[i] <= a[i+1]
# Example:
# Input:
# k = 3
# n = 2
# Output (order doesn’t matter):
# [1,1]
# [1,2]
# [1,3]
# [2,2]
# [2,3]
# [3,3]
# Notice sequences like [2,1], [3,1], [3,2] do NOT appear.

def generate_non_decreasing_sequences(k, n):
    res = []
    def go(start, acc):
            if len(acc) == n:
                res.append(acc[:])
                return
            for num in range(start, k + 1):
                acc.append(num)
                go(num, acc)
                acc.pop()
    go(1, [])
    return res

generate_non_decreasing_sequences(3,2)