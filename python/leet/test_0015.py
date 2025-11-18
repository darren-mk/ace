# https://leetcode.com/problems/3sum

from typing import Dict, List, Set, Tuple

Val = int
Ind = int
Triple = Tuple[Val, Val, Val]
Acc = Set[Triple]
Res = List[List[Val]]

class Solution:
    def threeSum(self, nums: List[Val]) -> Res:
        n: int = len(nums)
        acc: Acc = set()
        for i in range(n):
            pool: Dict[Val, Ind] = {}
            target = nums[i] * -1
            for j in range(n):
                if i != j:
                    expv = target - nums[j]
                    if expv in pool and pool[expv] != j:
                        triple: Triple = tuple(sorted([nums[i], nums[j], expv])) # type: ignore
                        acc.add(triple)
                    pool[nums[j]] = j
        return [ list(triple) for triple in acc ]

# time limit exceeds