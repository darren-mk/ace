import collections
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def maxDepth(self, root: TreeNode) -> int:
        if root is None: return 0
        return (max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1)

class SolutionB:
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

class SolutionC:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def go(node, depth):
            if node is None: return 0
            depth += 1
            return max(depth, go(node.left, depth), go(node.right, depth))
        return go(root, 0)

def testC():
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20, TreeNode(15), TreeNode(7))
    sol = SolutionC()
    assert sol.maxDepth(root1) == 3
    root2 = TreeNode(1)
    root2.right = TreeNode(2)
    assert sol.maxDepth(root2) == 2
    assert sol.maxDepth(None) == 0

# runtime: 100.00%
# memory: 47.71%

class SolutionD:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def go(node, depth):
            if node is None:
                return depth
            return max(go(node.left, depth + 1), go(node.right, depth + 1))
        return go(root, 0)

def testD():
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20, TreeNode(15), TreeNode(7))
    sol = SolutionD()
    assert sol.maxDepth(root1) == 3
    root2 = TreeNode(1)
    root2.right = TreeNode(2)
    assert sol.maxDepth(root2) == 2
    assert sol.maxDepth(None) == 0

# runtime: 100.00%
# memory: 47.71%