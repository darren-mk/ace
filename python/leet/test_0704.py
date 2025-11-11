from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums: 
            return -1
        mid_ind = 0
        left_ind = 0
        right_ind = len(nums) - 1
        while left_ind < right_ind:
            print("@@@@")
            mid_ind = int(left_ind + (right_ind - left_ind) / 2)
            mid = nums[mid_ind]
            if mid == target:
                return mid_ind
            elif nums[left_ind] == target:
                return left_ind
            elif nums[right_ind] == target:
                return right_ind
            elif mid < target:
                right_ind = mid_ind
            else:
                left_ind = mid_ind
        return -1

def test():
    assert [10,20,30,40][2:] == [30, 40]
    sol = Solution()
    assert sol.search([1], 1) == 0
    # assert sol.search([1,2], 2) == 1
    # assert sol.search([1,2,3], 2) == 1
    # assert sol.search([1,2,3], 3) == 2
    # assert sol.search([-1,0,3,5,9,12], 9) == 4
    # assert sol.search(nums, 2) == -1
