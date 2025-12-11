from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        def go(node: Optional[TreeNode], path: str):
            base = (path + "->") if path else ""
            if node is None: return
            new_path = base + str(node.val)
            if node.left is None and node.right is None:
                res.append(new_path)
            else:
                go(node.left, new_path)
                go(node.right, new_path)
        go(root, "")
        return res

def testA():
    assert "1" + "->" == "1->"
    sol = SolutionA()
    root1 = TreeNode(1, TreeNode(2, None, TreeNode(5)), TreeNode(3))
    assert sorted(sol.binaryTreePaths(root1)) == sorted(["1->2->5", "1->3"])
    root2 = TreeNode(1)
    out2 = sol.binaryTreePaths(root2)
    assert out2 == ["1"]

# time: O(N)
# space: O(N)
# runtime: 100.00%
# memory: 93.24%