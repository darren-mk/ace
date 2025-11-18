# https://www.geeksforgeeks.org/dsa/insertion-in-a-binary-tree-in-level-order/

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(node, new_value):
    if node is None:
        return Node(new_value)
    elif new_value < node.value:
        node.left = insert(node.left, new_value)
    elif new_value > node.value:
        node.right = insert(node.right, new_value)
    return node

def test_insert():
    root = Node(10)

    # Insert right
    root = insert(root, 15)
    assert root.value == 10
    assert root.right.value == 15
    assert root.left is None

    # Insert left
    root = insert(root, 5)
    assert root.left.value == 5
    assert root.right.value == 15

    # Insert deeper: left-right
    root = insert(root, 7)
    assert root.left.right.value == 7

    # Insert deeper: right-left
    root = insert(root, 12)
    assert root.right.left.value == 12

    # Insert deeper: right-right
    root = insert(root, 20)
    assert root.right.right.value == 20

    # Duplicate should not change anything
    root = insert(root, 10)
    assert root.value == 10
    assert root.left.value == 5
    assert root.right.value == 15

    # Tree structure summary
    #          10
    #        /    \
    #       5      15
    #        \    /  \
    #         7  12   20

    assert root.left.value == 5
    assert root.left.right.value == 7
    assert root.right.left.value == 12
    assert root.right.right.value == 20
