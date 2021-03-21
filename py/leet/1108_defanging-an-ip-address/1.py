# https://leetcode.com/problems/defanging-an-ip-address/

# trial 1
from typing import List, Dict, Tuple, Sequence
def determine(x):
    if x == '.': return "[.]"
    else: return x              
class Solution:
    def defangIPaddr(self, address: str) -> str:
        defanged = ''
        for s in address:
            defanged = defanged + determine(s)
        return defanged
t = Solution()
t.defangIPaddr("255.100.50.0")
