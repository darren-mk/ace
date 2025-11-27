from typing import List

class SolutionA:
    def searchInsert(self, nums: List[int], target: int) -> int:
        for i, num in enumerate(nums):
            if target <= num:
                return i
        return len(nums)

def testA():
    assert int(0.5) == 0
    sol = SolutionA()
    assert sol.searchInsert([1,2,3,4,5], 4) == 3
    assert sol.searchInsert([1,3,5,6], 5) == 2
    assert sol.searchInsert([1,3,5,6], 2) == 1
    assert sol.searchInsert([1,3,5,6], 7) == 4
    assert sol.searchInsert([1,3,5,6], 0) == 0
    assert sol.searchInsert([1,3], 2) == 1
    assert sol.searchInsert([3,5,7,9,10],8) == 3

# time: O(n)
# space: O(1)
# runtime: 100.00%
# memory: 26.21%

class SolutionB:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == nums[mid]:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left

def testB():
    sol = SolutionB()
    assert sol.searchInsert([1,2,3,4,5], 4) == 3
    assert sol.searchInsert([1,3,5,6], 5) == 2
    assert sol.searchInsert([1,3,5,6], 2) == 1
    assert sol.searchInsert([1,3,5,6], 7) == 4
    assert sol.searchInsert([1,3,5,6], 0) == 0
    assert sol.searchInsert([1,3], 2) == 1
    assert sol.searchInsert([3,5,7,9,10],8) == 3

# time: O(n)
# space: O(1)
# runtime: 100.00%
# memory: 26.21%