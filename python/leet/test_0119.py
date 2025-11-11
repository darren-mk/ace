from typing import List

class Solution:
    def synth(self, nums: List[int]) -> List[int]: 
        l: List[int] = nums[:1]
        for i in range(len(nums)-1):
            l.append(nums[i] + nums[i+1])
        l.append(nums[len(nums)-1])
        return l
    def getRow(self, rowIndex: int) -> List[int]:
        cursor: List[int] = []
        for i in range(rowIndex + 1):
            if i == 0:
                cursor = [1]
            else:
                cursor = self.synth(cursor)
        return cursor

def test():
    sol = Solution()
    assert sol.synth([1]) == [1,1]
    assert sol.synth([1,1]) == [1,2,1]
    assert sol.synth([1,2,1]) == [1,3,3,1]
    assert sol.getRow(3) == [1,3,3,1]