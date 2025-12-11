from typing import List

class SolutionA:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []
        def go(i, selected):
            if i == n:
                if not selected in res:
                    res.append(selected)
                return
            else:
                go(i+1, selected)
                go(i+1, selected + [nums[i]])
        go(0, [])
        print(len(res))
        return res

def testA():
    def normalize(subsets: List[List[int]]) -> List[List[int]]:
        return sorted([sorted(s) for s in subsets])
    sol = SolutionA()
    nums1 = [1, 2, 2]
    expected1 = [ [], [1], [2], [1,2], [2,2], [1,2,2] ]
    assert normalize(sol.subsetsWithDup(nums1)) == normalize(expected1)
    nums2 = [0]
    expected2 = [[], [0]]
    assert normalize(sol.subsetsWithDup(nums2)) == normalize(expected2)
    nums3 = [2,2,2]
    expected3 = [[], [2], [2,2], [2,2,2]]
    assert normalize(sol.subsetsWithDup(nums3)) == normalize(expected3)
    nums4 = [1,1,2]
    expected4 = [
        [], [1], [1,1], [2],
        [1,2], [1,1,2], ]
    assert normalize(sol.subsetsWithDup(nums4)) == normalize(expected4)

# runtime: 6.16%
# memory: 14.02%

class SolutionB:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []
        def go(start, path):
            res.append(path[:])
            for i in range(start, n):
                if i > start and nums[i-1] == nums[i]:
                    continue
                path.append(nums[i])
                go(i+1, path)
                path.pop()
        go(0, [])
        return res

def testB():
    def normalize(subsets: List[List[int]]) -> List[List[int]]:
        return sorted([sorted(s) for s in subsets])
    sol = SolutionB()
    nums1 = [1, 2, 2]
    expected1 = [ [], [1], [2], [1,2], [2,2], [1,2,2] ]
    assert normalize(sol.subsetsWithDup(nums1)) == normalize(expected1)
    nums2 = [0]
    expected2 = [[], [0]]
    assert normalize(sol.subsetsWithDup(nums2)) == normalize(expected2)
    nums3 = [2,2,2]
    expected3 = [[], [2], [2,2], [2,2,2]]
    assert normalize(sol.subsetsWithDup(nums3)) == normalize(expected3)
    nums4 = [1,1,2]
    expected4 = [
        [], [1], [1,1], [2],
        [1,2], [1,1,2], ]
    assert normalize(sol.subsetsWithDup(nums4)) == normalize(expected4)

# runtime: 100.00%
# memory: 14.02%