# Q3 — Given an array of distinct integers, return all permutations
# Example:
# Input:
# [1, 2, 3]
# Output (order does NOT matter):
# [
#   [1,2,3],
#   [1,3,2],
#   [2,1,3],
#   [2,3,1],
#   [3,1,2],
#   [3,2,1]
# ]
# Requirements
# Use backtracking.
# Each number must appear exactly once per permutation.
# No duplicates (input numbers are distinct).

def permutate(nums):
    n = len(nums)
    res = []
    def go(indices, acc):
        if len(acc) == n:
            res.append(acc[:])
            return
        for i in range(n):
            if not i in indices:
                indices.append(i)
                acc.append(nums[i])
                go(indices, acc)
                indices.pop()
                acc.pop()
    go([], [])
    return res