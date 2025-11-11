from typing import List, Optional

class TreeNode:
    def __init__(self, val:int=0, left:Optional[TreeNode]=None, right:Optional[TreeNode]=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None
        mid_ind: int = int(len(nums) / 2)
        val: int = nums[mid_ind]
        left: Optional[TreeNode] = self.sortedArrayToBST(nums[:mid_ind])
        right: Optional[TreeNode] = self.sortedArrayToBST(nums[mid_ind+1:])
        return TreeNode(val, left, right)