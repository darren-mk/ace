class BinaryTree:
    def __init__(self, val, left = None, right = None) -> None:
        self.val = val
        self.left = left
        self.right = right

b = BinaryTree(100)
c = BinaryTree(300)
a = BinaryTree(200, b, c)
print(a.left.val)
print(a.right.val)

def search_in_binary_tree(val, node):
    if node == None: return node
    if node.val == val: return node
    if node.val < val:
        return search_in_binary_tree(val, node.right)
    else:
        return search_in_binary_tree(val, node.left)

search_in_binary_tree(300, a).val
