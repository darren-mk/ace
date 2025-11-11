from typing import List

class Solution:
    def synth(self, nums: List[int]) -> List[int]: 
        mids: List[int] = []
        for i in range(len(nums)-1):
            mids.append(nums[i] + nums[i+1])
        return [nums[0]] + mids + [nums[len(nums)-1]]
    def generate(self, numRows: int) -> List[List[int]]:
        result: List[List[int]] = []
        last_item: List[int] = []
        for n in range(numRows):
            if n == 0:
                last_item = [1]
            else: 
                last_item = self.synth(last_item)
            result.append(last_item)
        return result

def test():
    sol = Solution()
    assert sol.synth([1]) == [1,1]
    assert sol.synth([1,1]) == [1,2,1]
    assert sol.synth([1,2,1]) == [1,3,3,1]
    assert sol.generate(5) == [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]