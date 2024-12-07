# https://leetcode.com/problems/maximum-depth-of-binary-tree/

# solution 1
import typing
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root is None: return 0
        return (max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1)
sample = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(7, TreeNode(8)))
trial = Solution()
trial.maxDepth(sample) #3
# Runtime: 44 ms, faster than 55.97% of Python3 online submissions for Maximum Depth of Binary Tree.
# Memory Usage: 15.8 MB, less than 19.01% of Python3 online submissions for Maximum Depth of Binary Tree.

# solution 2
import typing
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        dq, dpth = collections.deque(), 0
        if root: dq.append(root)
        while dq:
            for _ in range(len(dq)):
                node = dq.popleft()
                if node.left: dq.append(node.left)
                if node.right: dq.append(node.right)
            dpth = dpth + 1
        return dpth
    
            
sample = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(7, TreeNode(8)))
trial = Solution()
trial.maxDepth(sample) #3
