from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        memo = {}
        deepest_level = 1
        def go(node, level):
            nonlocal deepest_level
            if node is None:
                return
            memo[level] = memo.get(level, 0) + node.val
            deepest_level = max(deepest_level, level)
            go(node.left, level+1)
            go(node.right, level+1)
        go(root, 1)
        return memo[deepest_level]

# runtime: 12.10%
# memory: 99.45%