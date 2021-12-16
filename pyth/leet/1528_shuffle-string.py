# https://leetcode.com/problems/shuffle-string/

from typing import List, Dict, Tuple, Sequence

# 1
class Solution_01:
    def restoreString(self, s: str, indices: List[int]) -> str:
        n = len(s)
        dic = {}
        new_s = ''
        for i in range(n): dic[indices[i]] = s[i]
        for i in range(n): new_s = new_s + dic[i]
        return new_s
Solution_01().restoreString("codeleet", [4,5,6,7,0,2,1,3])
