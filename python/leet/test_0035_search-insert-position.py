from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l = 0 
        r = len(nums) - 1
        if target < nums[l]: 
            return 0
        if target > nums[r]:
            return r + 1
        while l <= r:
            if nums[l] == target:
                    return l
            if nums[r] == target:
                    return r
            if l == r:
                if target < nums[l]:
                    return l
                elif target > nums[r]:
                    return r + 1
            mid = int((l + r) / 2)
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                r = mid - 1
            elif target > nums[mid]:
                l = mid + 1

def test_solution():
    assert int(0.5) == 0
    sol = Solution()
    assert sol.searchInsert([1,2,3,4,5], 4) == 3
    assert sol.searchInsert([1,3,5,6], 5) == 2
    assert sol.searchInsert([1,3,5,6], 2) == 1
    assert sol.searchInsert([1,3,5,6], 7) == 4
    assert sol.searchInsert([1,3,5,6], 0) == 0
    assert sol.searchInsert([1,3], 2) == 1