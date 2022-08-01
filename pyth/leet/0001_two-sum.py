# https://leetcode.com/problems/two-sum/

from typing import List

# 1
class Solution_01:
    def twoSum(self, nums: List[int], target: int):
        pool = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in pool: return [pool[complement], i]
            else: pool[nums[i]] = i

# 2
class Solution_02:
    def twoSum(self, nums: List[int], target: int):
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in nums:
                if nums.index(complement) != i:
                    return [i, nums.index(complement)]       

# 3
class Solution_03:
    def twoSum(self, nums: List[int], target: int):
        mirror = {}
        for i in range(len(nums)):
            compl = target - nums[i]
            if nums[i] in mirror:
                return [mirror[nums[i]], i]
            else:
                mirror[compl] = i
''' Runtime: 116 ms, faster than 41.54% 
Memory Usage: 15.6 MB, less than 12.80% '''

# 4
class Solution_04:
    def twoSum(self, nums: List[int], target: int):
        mirror = dict()
        for i in range(len(nums)):
            compl = target - nums[i]
            if nums[i] not in mirror:
                mirror[compl] = i
            else:
                return [mirror[nums[i]], i]
''' Runtime: 99 ms, faster than 44.71%
Memory Usage: 15.7 MB, less than 8.79% '''
