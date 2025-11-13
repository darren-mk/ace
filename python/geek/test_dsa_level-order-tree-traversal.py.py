# https://www.geeksforgeeks.org/dsa/level-order-tree-traversal/

# Level Order Traversal technique is a method to traverse 
# a Tree such that all nodes present in the same level are 
# traversed completely before traversing the next level.

from typing import Optional, List

class Node:
    def __init__(self, data:int) -> None:
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None
        self.data = data

def impl_traverse_rec(root: Optional[Node], level: int, res: List[List[int]]):
    if root is None:
        return None
    if len(res) <= level:
        res.append([])
    res[level].append(root.data)
    impl_traverse_rec(root.left, level + 1, res)
    impl_traverse_rec(root.right, level + 1, res)

def traverse_rec(root: Optional[Node]) -> List[List[int]]:
    res: List[List[int]] = []
    impl_traverse_rec(root, 0, res)
    return res

def test():
    root = Node(5)
    root.left = Node(12)
    root.right = Node(13)
    root.left.left = Node(7)
    root.left.right = Node(14)
    root.right.right = Node(2)
    root.left.left.left = Node(17)
    root.left.left.right = Node(23)
    root.left.right.left = Node(27)
    root.left.right.right = Node(3)
    root.right.right.left = Node(8)
    root.right.right.right = Node(11)
    res = traverse_rec(root)
    assert res == [
        [5],
        [12, 13],
        [7, 14, 2],
        [17, 23, 27, 3, 8, 11]]
    
def traverse_iter(root: Node):
    pass 