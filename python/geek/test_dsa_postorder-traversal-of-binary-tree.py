# https://www.geeksforgeeks.org/dsa/postorder-traversal-of-binary-tree/

# Postorder Traversal is a method to traverse a tree such that for each node, 
# you first traverse its left subtree, then its right subtree, and finally visit the node itself.

from typing import Optional, List

class Node:
    def __init__(self, x:int) -> None:
        self.data = x
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None

def post_order(node: Optional[Node], res: List[int]):
    if node is None:
        return None
    post_order(node.left, res)
    post_order(node.right, res)
    res.append(node.data)

def test(): 
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    res: List[int] = []
    post_order(root, res)
    assert res == [4, 5, 2, 6, 3, 1]