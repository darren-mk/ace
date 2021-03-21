# https://leetcode.com/problems/contains-duplicate/

# solution 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)
trial = Solution()
trial.containsDuplicate([1,2,3,1])
trial.containsDuplicate([1,2,3,4])
trial.containsDuplicate([1,1,1,3,3,4,3,2,4,2])
# Runtime: 116 ms, faster than 93.66% of Python3 online submissions for Contains Duplicate.
# Memory Usage: 19.6 MB, less than 33.88% of Python3 online submissions for Contains Duplicate.

# solution 2
from typing import List, Dict, Tuple, Sequence
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        pool = set()
        for i in nums:
            if i in pool: return True
            pool.add(i)
        return False
trial = Solution()
trial.containsDuplicate([1,2,3,1])
trial.containsDuplicate([1,2,3,4])
trial.containsDuplicate([1,1,1,3,3,4,3,2,4,2])
# Runtime: 116 ms, faster than 93.66% of Python3 online submissions for Contains Duplicate.
# Memory Usage: 19.6 MB, less than 35.68% of Python3 online submissions for Contains Duplicate.

# solution 3
from typing import List, Dict, Tuple, Sequence
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]: return True
        return False             
trial = Solution()
trial.containsDuplicate([1,2,3,1])
trial.containsDuplicate([1,2,3,4])
trial.containsDuplicate([1,1,1,3,3,4,3,2,4,2])
# Runtime: 120 ms, faster than 86.85% of Python3 online submissions for Contains Duplicate.
# Memory Usage: 19 MB, less than 87.97% of Python3 online submissions for Contains Duplicate.
