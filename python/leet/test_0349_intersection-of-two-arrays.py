from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return list(set(nums1).intersection(set(nums2)))
    
def test_solution_a():
    sol = Solution()
    assert sol.intersection([1,2,2,1], [2,2]) == [2]
    assert sol.intersection([4,9,5], [9,4,9,8,4]) == [9, 4]