# https://leetcode.com/problems/two-sum/

def two_sum(nums, target, pool):
    for index in range(len(nums)):
        val = nums[index]
        complement = target - val
        if complement in pool: 
            return [pool[complement], index]
        else: 
            pool[val] = index
            two_sum(nums, target, pool)
two_sum([3,2,4], 6, {})
