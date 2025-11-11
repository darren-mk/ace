from typing import List, Set

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen: Set[int] = set()
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False

def test():
    sol = Solution()
    assert sol.containsDuplicate([1,2,3,1]) == True
    assert sol.containsDuplicate([1,2,3,4]) == False
    assert sol.containsDuplicate([1,1,1,3,3,4,3,2,4,2]) == True