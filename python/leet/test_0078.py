from typing import List

class SolutionA:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        def go(i, selected):
            if i > n-1:
                res.append(selected)
            else:
                go(i+1, selected)
                go(i+1, selected + [nums[i]])
        go(0, [])
        return res

def testA():
    def normalize(subsets: List[List[int]]) -> List[List[int]]:
        return sorted([sorted(s) for s in subsets])
    sol = SolutionA()
    expected1 = [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    assert normalize(sol.subsets([1, 2, 3])) == normalize(expected1)
    expected2 = [[], [0]]
    assert normalize(sol.subsets([0])) == normalize(expected2)

# runtime: 100.00%
# memory: 64.66%