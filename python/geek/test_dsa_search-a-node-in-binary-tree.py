# https://www.geeksforgeeks.org/dsa/search-a-node-in-binary-tree/

class Node:
    def __init__(self, x):
        self.value = x
        self.left = None
        self.right = None

def f(node, desired_value):
    found = False
    def go(node):
        nonlocal found
        if node is None or found: return
        if node.value == desired_value:
            found = True
            return
        go(node.left)
        go(node.right)
    go(node)
    return found

def test():
    root = Node(0)
    root.left = Node(1)
    root.left.left = Node(3)
    root.left.left.left = Node(7)
    root.left.right = Node(4)
    root.left.right.left = Node(8)
    root.left.right.right = Node(9)
    root.right = Node(2)
    root.right.left = Node(5)
    root.right.right = Node(6)
    assert f(root, 4)
    assert not f(root, 100)