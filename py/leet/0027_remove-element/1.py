# https://leetcode.com/problems/remove-element/

class Solution:
    def removeElement(self, nums, val):
        counter = 0
        for num in nums:
            if num != val: counter += 1
        return counter

trial = Solution()
trial.removeElement([0,1,2,2,3,0,4,2], 2)
