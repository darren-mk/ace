# https://www.geeksforgeeks.org/dsa/preorder-traversal-of-binary-tree/

# Preorder Traversal is a method to traverse a tree such that for each node, 
# you first visit the node itself, then traverse its left subtree, 
# and finally traverse its right subtree.

from typing import Optional, List

class Node:
    def __init__(self, x:int) -> None:
        self.value = x
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None

def f(node: Optional[Node]):
    res = []
    def go(node):
        if node is None: return 
        res.append(node.value)
        go(node.left)
        go(node.right)
    go(node)
    return res

def test(): 
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    assert f(root) == [1, 2, 4, 5, 3, 6]