# Q6 — Combination Sum II
# You are given a list of candidates (some numbers may be duplicated) and a target value.
# Return all unique combinations where the chosen numbers sum to target.
# Rules:
# Each number may be used at most once.
# Input may contain duplicates, but output must NOT contain duplicate combinations.
# Order inside a combination doesn’t matter.
# Order of the returned list doesn’t matter.
# Example
# Input:
# candidates = [10,1,2,7,6,1,5]
# target = 8
# Output:
# [
#   [1,1,6],
#   [1,2,5],
#   [1,7],
#   [2,6]
# ]

def combination_sum2(nums, target):
    nums.sort()
    res = []
    def go(start, indices, remaining, acc):
        if remaining == 0:
            res.append(acc.copy())
            return
        if remaining < 0:
            return
        for i in range(start+1, len(nums)):
            v = nums[i]
            if v > remaining: break
            if i not in indices:
                indices.add(i)
                acc.append(v)
                go(start+1, indices, remaining-v, acc)
                indices.remove(i)
                acc.pop()
    go(0, set(), target, [])
    return res

combination_sum2([10,1,2,7,6,1,5], 8)

def test_combination_sum2():
    out = sorted([sorted(x) for x in combination_sum2([10,1,2,7,6,1,5], 8)])
    assert out == sorted([ [1,1,6], [1,2,5], [1,7], [2,6], ])
    out = sorted([sorted(x) for x in combination_sum2([2,2,2], 4)])
    assert out == sorted([[2,2]])
    out = combination_sum2([3,4,5], 2)
    assert out == []
    out = sorted([sorted(x) for x in combination_sum2([1,1,1,2], 3)])
    assert out == sorted([ [1,2], [1,1,1], ])