from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        unival = root.val
        def go(node):
            if node is None: return True
            return node.val == unival and go(node.left) and go(node.right)
        return go(root)

def build_tree(values: List[Optional[int]]) -> Optional[TreeNode]:
    """Builds a binary tree from a level-order list (LeetCode style)."""
    if not values:
        return None

    def helper(i: int) -> Optional[TreeNode]:
        if i >= len(values) or values[i] is None:
            return None
        node = TreeNode(values[i])
        node.left = helper(2 * i + 1)
        node.right = helper(2 * i + 2)
        return node

    return helper(0)

def test_isUnivalTree():
    sol = SolutionA()
    # Example 1: [1,1,1,1,1,null,1] -> True
    root1 = build_tree([1, 1, 1, 1, 1, None, 1])
    assert sol.isUnivalTree(root1) is True
    # Example 2: [2,2,2,5,2] -> False
    root2 = build_tree([2, 2, 2, 5, 2])
    assert sol.isUnivalTree(root2) is False
    # Single node: [5] -> True
    root3 = build_tree([5])
    assert sol.isUnivalTree(root3) is True
    # Non-unival where leaf differs
    #       1
    #      / \
    #     1   1
    #        /
    #       2
    root4 = build_tree([1, 1, 1, None, None, 2])
    assert sol.isUnivalTree(root4) is False
    # All equal in a skewed-ish tree: [3,3,3,None,3]
    root5 = build_tree([3, 3, 3, None, 3])
    assert sol.isUnivalTree(root5) is True

# Runtime Beats 100.00%
# Memory Beats 16.68%