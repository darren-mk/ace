# Q5 — Combination Sum
# Given a list of distinct integers candidates and a target number,
# return all unique combinations of candidates where the chosen numbers sum to target.
# You may use the same number multiple times.
# Order inside a combination does NOT matter.
# Order of returned combinations does NOT matter.
# Example:
# Input:
# candidates = [2,3,6,7]
# target = 7
# Output:
# [ [2,2,3], [7] ]

def combination_sum(nums, target):
    res = []
    def go(acc):
        x = sum(acc)
        if x == target:
            v = sorted(acc.copy())
            if not v in res:
                res.append(v)
            return
        if x > target:
            return
        for num in nums:
            acc.append(num)
            go(acc)
            acc.pop()
    go([])
    return res

combination_sum([2,3,6,7], 7)
combination_sum([2,3], 8)
x = []

x.append(1)


def test_combination_sum():
    out = sorted([sorted(x) for x in combination_sum([2,3,6,7], 7)])
    assert out == sorted([sorted([2,2,3]), sorted([7])])
    out = sorted([sorted(x) for x in combination_sum([2,3,5], 8)])
    assert out == sorted([
        [3,5],
        [2,3,3],
        [2,2,2,2], ])
    out = combination_sum([4,5], 3)
    assert out == []