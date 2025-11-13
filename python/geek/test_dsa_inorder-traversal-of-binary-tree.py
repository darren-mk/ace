# https://www.geeksforgeeks.org/dsa/inorder-traversal-of-binary-tree/

# Inorder Traversal is a method to traverse a tree such that for each node, 
# you first traverse its left subtree, then visit the node itself, 
# and finally traverse its right subtree.

from typing import Optional, List

class Node:
    def __init__(self, x:int) -> None:
        self.data = x
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None

def in_order(node: Optional[Node], res: List[int]):
    if node is None:
        return None
    in_order(node.left, res)
    res.append(node.data)
    in_order(node.right, res)

def test(): 
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    res: List[int] = []
    in_order(root, res)
    assert res == [4, 2, 5, 1, 3, 6]