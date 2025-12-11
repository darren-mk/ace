# Backtracking Exercise #2 (Beginner)
# Q2 — Generate all subsets (the power set)
# Given an array of distinct integers nums, return all possible subsets.
# Example:
# Input:
# [1, 2]
# Output (order does NOT matter):
# [[], [1], [2], [1,2]]

def subsets(nums):
    n = len(nums)
    res = []
    def go(pos, acc):
        if pos == n:
            res.append(acc[:])
            return
        go(pos+1, acc)
        acc.append(nums[pos])
        go(pos+1, acc)
        acc.pop()
    go(0, [])
    return res

def test_subsets():
    assert sorted(subsets([1])) == sorted([[], [1]])
    assert sorted(subsets([1,2])) == sorted([[], [1], [2], [1,2] ])
    assert sorted(subsets([1,2,3])) == sorted([
        [], [1], [2], [3],
        [1,2], [1,3], [2,3],
        [1,2,3] ])