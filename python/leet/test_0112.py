from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def go(node, acc):
            if node is None:
                return False
            new_acc = acc + node.val
            if node.left is None and node.right is None:
                return new_acc == targetSum
            return go(node.left, new_acc) or go(node.right, new_acc)
        return go(root, 0) if root else False

def testA():
    sol = SolutionA()
    assert sol.hasPathSum(None, 0) == False
    assert sol.hasPathSum(TreeNode(1, TreeNode(2, None, None), None), 1) == False
    assert sol.hasPathSum(TreeNode(5,
                                   TreeNode(4,
                                            TreeNode(11, TreeNode(7), TreeNode(2)),
                                            None),
                                   TreeNode(8,
                                            TreeNode(13),
                                            TreeNode(4, None, TreeNode(1)))),
                          22) == True

# Runtime Beats 100.00%
# Memory Beats 42.66%