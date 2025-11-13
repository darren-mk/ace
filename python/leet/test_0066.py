# https://leetcode.com/problems/plus-one

from typing import List

# 1
# O(n^2)
class Solution_01:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits_in_str = ""
        for digit in digits:
            digits_in_str = digits_in_str + str(digit)
        digits_plus_1_list = []
        for c in str(int(digits_in_str) + 1):
            digits_plus_1_list.append(int(c))
        return digits_plus_1_list
Solution_01().plusOne([1,2,3,4]) # 1235
''' Runtime: 40 ms, faster than 18.71% of Python3 online submissions for Plus One.
Memory Usage: 14.3 MB, less than 48.01% of Python3 online submissions for Plus One. '''

# 2
# ref: https://leetcode.com/problems/plus-one/discuss/438791/Recursive-Python-solution-(98.87-Speed-100-Memory)
# time: O(n)
class Solution_02:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits[-1] == 9:
            if len(digits) == 1:
                return [1,0]
            else:
                return self.plusOne(digits[:-1]) + [0]
        else:
            return digits[:-1] + [(digits[-1] + 1)]
Solution_02().plusOne([1,2,3,4]) # 1235
Solution_02().plusOne([9,9]) # 1235
''' Runtime: 35 ms, faster than 35.80% of Python3 online submissions for Plus One.
Memory Usage: 14.3 MB, less than 48.01% of Python3 online submissions for Plus One. '''