from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# https://leetcode.com/problems/balanced-binary-tree/solutions/2428871/very-easy-100-fully-explained-c-java-pyt-v508
class SolutionA:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return (self.Height(root) >= 0)
    def Height(self, root):
        if root is None: return 0
        l, r = self.Height(root.left), self.Height(root.right)
        if l < 0 or r < 0 or abs(l - r) > 1: return -1
        return max(l, r) + 1

def testA():
    sol = SolutionA()
    # Example 1: Balanced
    #       3
    #      / \
    #     9   20
    #         / \
    #        15  7
    root1 = TreeNode(3,
                 TreeNode(9),
                 TreeNode(20, TreeNode(15), TreeNode(7)))
    assert sol.isBalanced(root1) is True

    # Example 2: Not balanced
    #       1
    #      / \
    #     2   2
    #    / \
    #   3   3
    #  / \
    # 4   4
    root2 = TreeNode(1,
                 TreeNode(2,
                      TreeNode(3, TreeNode(4), TreeNode(4)),
                      TreeNode(3)),
                 TreeNode(2))
    assert sol.isBalanced(root2) is False
