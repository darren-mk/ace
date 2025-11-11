from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        result: List[int] = []
        zeroes: List[int] = []
        for num in nums:
            if num == 0:
                zeroes.append(num)
            else:
                result.append(num)
        nums[:] = result + zeroes
    
def test():
    sol = Solution()
    nums = [0,1,0,3,12]
    sol.moveZeroes(nums)
    assert nums == [1,3,12,0,0] # FAIL