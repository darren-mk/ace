# https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

# trial 1
from typing import List, Dict, Tuple, Sequence
def divide_or_subtract(x):
    if x % 2 == 0: return x / 2
    else: return x - 1
class Solution:
    def numberOfSteps (self, num: int) -> int:
        count = 0 
        while num > 0:
            num = divide_or_subtract(num)
            count = count + 1
        return count 
