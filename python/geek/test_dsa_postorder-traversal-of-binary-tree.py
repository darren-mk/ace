# https://www.geeksforgeeks.org/dsa/postorder-traversal-of-binary-tree/

# Postorder Traversal is a method to traverse a tree such that for each node, 
# you first traverse its left subtree, then its right subtree, and finally visit the node itself.

from typing import Optional, List

class Node:
    def __init__(self, value:int) -> None:
        self.value = value
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None

def post_order(node: Optional[Node]):
    res = []
    def go(node):
        if node is None: return 
        go(node.left)
        go(node.right)
        res.append(node.value)
    go(node)
    return res

def test():
    # given example
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    assert post_order(root) == [4, 5, 2, 6, 3, 1]
    # empty tree
    assert post_order(None) == []
    # single node
    n1 = Node(10)
    assert post_order(n1) == [10]
    # skewed left
    n = Node(1)
    n.left = Node(2)
    n.left.left = Node(3)
    assert post_order(n) == [3, 2, 1]
    # skewed right
    m = Node(1)
    m.right = Node(2)
    m.right.right = Node(3)
    assert post_order(m) == [3, 2, 1]