# https://leetcode.com/problems/shuffle-string/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        n = len(s)
        dic = {}
        new_s = ''
        for i in range(n): dic[indices[i]] = s[i]
        for i in range(n): new_s = new_s + dic[i]
        return new_s
trial = Solution()
trial.restoreString("codeleet", [4,5,6,7,0,2,1,3])
