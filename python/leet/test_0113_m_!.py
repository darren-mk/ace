from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionA:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        def go(node, path, acc):
            if node is None: return
            new_acc = acc + node.val
            new_path = path + [node.val]
            if node.left is None and node.right is None:
                if new_acc == targetSum:
                    res.append(new_path)
                    return
            go(node.left, new_path, new_acc)
            go(node.right, new_path, new_acc)
        go(root, [], 0)
        return res

# ai helped
# runtime: 44.50%
# memory: 19.77%