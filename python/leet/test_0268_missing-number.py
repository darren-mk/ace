from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums) + 1
        complete = list(range(n))
        given_set = set(nums)
        for item in complete:
            if item not in given_set:
                return item

def test_solution():
    sol = Solution()
    assert set(range(4)) == {0, 1, 2, 3}
    assert sol.missingNumber([3,0,1]) == 2
    assert sol.missingNumber([0,1]) == 2
    assert sol.missingNumber([9,6,4,2,3,5,7,0,1]) == 8