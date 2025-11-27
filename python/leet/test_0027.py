class Solution:
    def removeElement(self, nums, val):
        counter = 0
        for num in nums:
            if num != val:
                counter += 1
        return counter