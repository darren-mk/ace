# https://www.geeksforgeeks.org/dsa/inorder-traversal-of-binary-tree/

# Inorder Traversal is a method to traverse a tree such that for each node, 
# you first traverse its left subtree, then visit the node itself, 
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
        go(node.left)
        res.append(node.value)
        go(node.right)
    go(node)
    return res

def test():
    # empty
    assert f(None) == []
    # single node
    root = Node(10)
    assert f(root) == [10]
    # bigger tree
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    assert f(root) == [4, 2, 5, 1, 3, 6]