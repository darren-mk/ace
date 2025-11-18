# https://www.geeksforgeeks.org/dsa/find-the-maximum-depth-or-height-of-a-tree/

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def height(node):
    max_level = 0
    def go(node, level=0):
        nonlocal max_level
        if node is None: return
        max_level = max(max_level, level)
        go(node.left, level + 1)
        go(node.right, level + 1)
    go(node)
    return max_level + 1

def test():
    root = Node(12)
    root.left = Node(8)
    root.right = Node(18)
    root.left.left = Node(5)
    root.left.right = Node(11)
    assert height(root) == 3
