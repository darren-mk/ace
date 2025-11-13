from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        mx = 0
        while 0 <= left < right <= len(height) -1 :
            h = min(height[left], height[right])
            w = right - left
            area = h * w
            mx = max(mx, area)
            if height[left] < height[right]: left += 1
            else: right -= 1
        return mx
    
def test():
    sol = Solution()
    assert sol.maxArea([1,8,6,2,5,4,8,3,7]) == 49
    assert sol.maxArea([4,3,2,1,4]) == 16
    assert sol.maxArea([2,3,4,5,18,17,6]) == 17