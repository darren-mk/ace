# https://leetcode.com/problems/two-sum/

from typing import Dict, List

Val = int
Ind = int
class SolutionA:
    def twoSum(self, nums: List[Val], target: Val) -> List[Ind]:
        pool: Dict[Val, Ind] = {}
        res: List[Ind] = []
        for i in range(len(nums)):
            expv: Val = target - nums[i]           
            if expv in pool:
                res = [pool[expv], i]
                break
            pool[nums[i]] = i           
        return res
        
def test_a():
    sol = SolutionA()
    assert sol.twoSum([2,7,11,15], 9) == [0,1]
    assert sol.twoSum([3,2,4], 6) == [1,2]
    assert sol.twoSum([3,3], 6) == [0,1]