from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        acc = 0
        def go(node):
            nonlocal acc
            if node is None: return
            v = node.val
            if low <= v and v <= high:
                acc += v
            go(node.left)
            go(node.right)
        go(root)
        return acc

# Runtime Beats 23.53%
# Memory Beats 22.25%

class SolutionB:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def go(node):
            if node is None: return 0
            v = node.val
            this = v if low <= v and v <= high else 0
            return this + go(node.left) + go(node.right)
        return go(root)

# Runtime Beats 23.53%
# Memory Beats 5.42%
