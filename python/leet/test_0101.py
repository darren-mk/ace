from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def compare(self, a: Optional[TreeNode], b: Optional[TreeNode]) -> bool:
        if a is None and b is None: return True
        if a is None or b is None: return False
        return a.val == b.val and self.compare(a.right, b.left) and self.compare(a.left, b.right)
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.compare(root.left, root.right)

def testA():
    sol = SolutionA()
    # Example 1: root = [1,2,2,3,4,4,3] -> True
    root1 = TreeNode(
        1,
        left=TreeNode(2, TreeNode(3), TreeNode(4)),
        right=TreeNode(2, TreeNode(4), TreeNode(3)), )
    assert sol.isSymmetric(root1) is True
    # Example 2: root = [1,2,2,null,3,null,3] -> False
    root2 = TreeNode(
        1,
        left=TreeNode(2, None, TreeNode(3)),
        right=TreeNode(2, None, TreeNode(3)), )
    assert sol.isSymmetric(root2) is False
    # Single node: [1] -> True
    root3 = TreeNode(1)
    assert sol.isSymmetric(root3) is True
    # Asymmetric deeper structure:
    #     1
    #    / \
    #   2   2
    #  /     \
    # 3       3
    root4 = TreeNode(
        1,
        left=TreeNode(2, TreeNode(3), None),
        right=TreeNode(2, None, TreeNode(3)), )
    assert sol.isSymmetric(root4) is True

# runtime: 100.00%
# memory: 33.88%