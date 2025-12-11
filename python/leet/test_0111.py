import sys
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None: return 0
        return self.calc(root)
    def calc(self, node: Optional[TreeNode]) -> int:
        if node is None: return sys.maxsize
        if not node.left and not node.right: return 1
        return 1 + min(self.calc(node.left), self.calc(node.right))

def testA():
    sol = SolutionA()
    # Example 1: root = [3,9,20,null,null,15,7], min depth = 2
    root1 = TreeNode( 3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)), )
    assert sol.minDepth(root1) == 2
    # Example 2: root = [2,null,3,null,4,null,5,null,6], min depth = 5
    root2 = TreeNode(2, None, TreeNode(3, None, TreeNode(4, None, TreeNode(5, None, TreeNode(6)))))
    # f(6) = 1
    # f(5) = 1
    assert sol.minDepth(root2) == 5
    # extra: empty tree -> 0
    assert sol.minDepth(None) == 0
    # extra: single node -> 1
    root3 = TreeNode(1)
    assert sol.minDepth(root3) == 1
    # extra: only left children: 1->2->3, depth = 3
    root4 = TreeNode(1, TreeNode(2, TreeNode(3)), None)
    assert sol.minDepth(root4) == 3

# runtime: 17.38%
# memory: 9.42%