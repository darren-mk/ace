# https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        c = 0
        for n in nums:
            if len(str(n)) % 2 == 0: c += 1
        return c

# trial 2
from typing import List, Dict, Tuple, Sequence
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        lengths = list(map(lambda x: len(str(x)), nums))
        counts = len(list(filter(lambda x: x % 2 == 0, lengths)))
        return counts
