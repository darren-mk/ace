from typing import List, Optional

class TreeNode:
    def __init__(self, val:int=0, left:Optional[TreeNode]=None, right:Optional[TreeNode]=None):
        self.val = val
        self.left = left
        self.right = right
        
class SolutionA:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res: List[int] = []
        def recur(node: Optional[TreeNode]):
            if node is None: return
            recur(node.left)
            recur(node.right)
            res.append(node.val)
        recur(root)
        return res 

def test_a():
    node_c = TreeNode(3)
    node_b = TreeNode(2, node_c)
    node_a = TreeNode(1, None, node_b)
    sol = SolutionA()
    assert sol.postorderTraversal(node_a) == [3,2,1]

# Runtime Beats 100.00%
# Memory Beats 84.57%