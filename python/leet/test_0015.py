# https://leetcode.com/problems/3sum

from typing import List

Ind = int
Val = int

class Solution:
    def threeSum(self, nums: List[Val]) -> List[List[Val]]:
        n: Ind = len(nums)
        res: List[List[Val]] = []
        nums.sort()
        for i in range(n-2):
            if i > 0 and nums[i] == nums[i - 1]: continue
            left: Ind = i + 1
            right: Ind = n - 1
            while left < right:
                summed: Val = nums[i] + nums[left] + nums[right]
                if summed < 0: left += 1
                elif summed > 0: right -= 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
        return res

def test():
    sol = Solution()
    a = sol.threeSum([-1,0,1,2,-1,-4])
    assert len(a) == 2
    assert a == [[-1,-1,2],[-1,0,1]]
    assert sol.threeSum([0,1,1]) == []
    assert sol.threeSum([0,0,0]) == [[0,0,0]]
    b = [2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10]
    c = [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
    assert sol.threeSum(b) == c
