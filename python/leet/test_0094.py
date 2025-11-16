
from typing import List, Optional

class TreeNode:
    def __init__(self, val:int=0, left:Optional[TreeNode]=None, right:Optional[TreeNode]=None):
        self.val: int = val
        self.left: Optional[TreeNode] = left
        self.right: Optional[TreeNode] = right

class SolutionA:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res: List[int] = []
        def recur(root: Optional[TreeNode]):
            if root is None: return
            recur(root.left)
            res.append(root.val)
            recur(root.right)
        recur(root)
        return res
    
def test_a():
    node_c = TreeNode(3)
    node_b = TreeNode(2, node_c)
    node_a = TreeNode(1, None, node_b)
    sol = SolutionA()
    assert sol.inorderTraversal(node_a) == [1,3,2]
