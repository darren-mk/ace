# https://leetcode.com/problems/two-sum/

from typing import Dict, List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        memo = {}
        for i in range(len(nums)):
            need = target - nums[i]
            if need in memo:
                return [i,memo[need]]
            memo[nums[i]] = i
        print(memo)

def test_a():
    memo = {}
    assert memo.get(0) == None
    assert 0 if None else 1 == 1
    memo[1] = 10
    assert memo.get(1) == 10
    sol = Solution()
    assert set(sol.twoSum([2,7,11,15], 9)) == set([0,1])
    assert set(sol.twoSum([3,2,4], 6)) == set([1,2])
    assert set(sol.twoSum([3,3], 6)) == set([0,1])