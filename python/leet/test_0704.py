from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid_ind = (left + right) // 2
            if nums[mid_ind] == target:
                return mid_ind
            if nums[left] == target:
                return left
            if nums[right] == target:
                return right
            if left == right or nums[right] < target or target < nums[left]:
                return -1
            if target < nums[mid_ind]:
                right = mid_ind - 1
            else:
                left = mid_ind + 1
        return -1

def test():
    assert [10,20,30,40][2:] == [30, 40]
    sol = Solution()
    assert sol.search([], 1) == -1
    assert sol.search([1], 1) == 0
    assert sol.search([1,2], 2) == 1
    assert sol.search([1,2,3], 2) == 1
    assert sol.search([1,2,3], 3) == 2
    assert sol.search([-1,0,3,5,9,12], 3) == 2
    assert sol.search([-1,0,3,5,9,12], -1) == 0
    assert sol.search([-1,0,3,5,9,12], 9) == 4
    assert sol.search([-1,0,3,5,9,12], 2) == -1