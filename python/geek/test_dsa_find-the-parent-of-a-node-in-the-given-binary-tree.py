# https://www.geeksforgeeks.org/dsa/find-the-parent-of-a-node-in-the-given-binary-tree/

class Node:
    def __init__(self, x):
        self.value = x
        self.left = None
        self.right = None

def f(node, key):
    parent = None
    def go(node):
        nonlocal parent
        if node is None or parent is not None:
            return
        if (node.left and node.left.value == key) or \
            (node.right and node.right.value == key):
            parent = node.value
            return
        go(node.left)
        go(node.right)
    go(node)
    return parent

def test():
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    assert f(root, 3) == 1
    assert f(root, 5) == 2