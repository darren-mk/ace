from typing import Optional, List

class TreeNode:
    def __init__(self, val:int=0, left:Optional[TreeNode]=None, right:Optional[TreeNode]=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res: List[int] = []
        def recur(node: Optional[TreeNode]):
            if node is None: return
            res.append(node.val)
            recur(node.left)
            recur(node.right)
        recur(root)
        return res
    
def test_a():
    s = SolutionA()
    node_c = TreeNode(3)
    node_b = TreeNode(2, node_c)
    node_a = TreeNode(1, None, node_b)
    assert s.preorderTraversal(node_a) == [1,2,3]
    assert s.preorderTraversal(None) == []

# Runtime Beats 100.00%
# Memory Beats 83.93%