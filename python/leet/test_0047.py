from typing import Counter, List

class SolutionA:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        pile = []
        def go(acc, indices):
            if len(acc) == len(nums):
                pile.append(acc)
            else:
                for i, num in enumerate(nums):
                    if not i in indices:
                        go(acc + [num], indices + [i])
        go([], [])
        res = []
        for item in pile:
            if not item in res:
                res.append(item)
        return res

def testA():
    sol = SolutionA()
    assert sorted(sol.permuteUnique([1, 1, 2])) == sorted([
        [1, 1, 2], [1, 2, 1], [2, 1, 1]])
    assert sorted(sol.permuteUnique([1, 2, 3])) == sorted([
        [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ])

# runtime: 5.05%
# memory: 5.00%

class SolutionB:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        def go(acc: List[int], used_indices: List[int]):
            if len(acc) >= len(nums):
                if not acc in res:
                    res.append(acc)
                return
            else:
                for i, num in enumerate(nums):
                    if not i in used_indices:
                        go(acc + [num], used_indices + [i])
        go([], [])
        return res

def testB():
    sol = SolutionB()
    assert sorted(sol.permuteUnique([1,2])) == sorted([[1,2], [2,1]])
    assert sorted(sol.permuteUnique([1,2,3])) == sorted([
        [1,2,3], [2,1,3], [3,1,2], [3,2,1], [2,3,1], [1,3,2]])
    assert sorted(sol.permuteUnique([1, 1, 2])) == sorted([
        [1, 1, 2], [1, 2, 1], [2, 1, 1]])
    assert sorted(sol.permuteUnique([1, 2, 3])) == sorted([
        [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ])

# runtime: 5.05%
# memory: 52.70%

class SolutionC:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        def go(acc, counter):
            if len(acc) == len(nums):
                res.append(acc[:])
                return
            for x in counter:
                if counter[x] > 0:
                    acc.append(x)
                    counter[x] -= 1
                    go(acc, counter)
                    acc.pop()
                    counter[x] += 1
        go([],Counter(nums))
        return res

def testC():
    sol = SolutionC()
    assert sorted(sol.permuteUnique([1,2])) == sorted([[1,2], [2,1]])
    assert sorted(sol.permuteUnique([1,2,3])) == sorted([
        [1,2,3], [2,1,3], [3,1,2], [3,2,1], [2,3,1], [1,3,2]])
    assert sorted(sol.permuteUnique([1, 1, 2])) == sorted([
        [1, 1, 2], [1, 2, 1], [2, 1, 1]])
    assert sorted(sol.permuteUnique([1, 2, 3])) == sorted([
        [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ])

# runtime: 32.92%
# memory: 35.16%