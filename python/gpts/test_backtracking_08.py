# Backtracking Exercise A2
# Function name: generate_sequences
# Problem:
# Given:
# an integer k
# an integer n
# Return all sequences of length n where each element is an integer from 1 to k.
# Example
# Input:
# k = 3
# n = 2
# Output (order doesn’t matter):
# [
#   [1,1],
#   [1,2],
#   [1,3],
#   [2,1],
#   [2,2],
#   [2,3],
#   [3,1],
#   [3,2],
#   [3,3]
# ]

def generate_sequences(k, n):
    nums = list(range(1, k+1))
    res = []
    def go(start, acc):
        if start == n:
            res.append(acc[:])
            return
        for num in nums:
            acc.append(num)
            go(start+1, acc)
            acc.pop()
    go(0, [])
    return res

generate_sequences(3,2)