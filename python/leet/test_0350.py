from typing import List

class SolutionA:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        acc = []
        memo = {}
        for x in nums1:
            memo[x] = memo.get(x, 0) + 1
        for y in nums2:
            if memo.get(y, 0) > 0:
                acc.append(y)
                memo[y] -= 1
        return acc

def testA():
    sol = SolutionA()
    assert sorted(sol.intersect([1, 2, 2, 1], [2, 2])) == [2, 2]
    assert sorted(sol.intersect([4, 9, 5], [9, 4, 9, 8, 4])) == [4, 9]

# runtime: 100.00%
# memory: 93.82%