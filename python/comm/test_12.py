
class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

### TRAVERSAL ###

def inorder(node):
    res = []
    def go(node):
        if node is None: return
        go(node.left)
        res.append(node.value)
        go(node.right)
    go(node)
    return res

def test_inorder():
    assert inorder(None) == []
    root = TreeNode(5)
    assert inorder(root) == [5]
    root = TreeNode(5,
        TreeNode(3, TreeNode(1), TreeNode(4)),
        TreeNode(8, TreeNode(7), TreeNode(10)))
    assert inorder(root) == [1, 3, 4, 5, 7, 8, 10]
    root = TreeNode(5, TreeNode(3, TreeNode(1), None), None)
    assert inorder(root) == [1, 3, 5]
    root = TreeNode(5, None, TreeNode(7, None, TreeNode(9)))
    assert inorder(root) == [5, 7, 9]
    root = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), None))
    assert inorder(root) == [4, 6, 7, 9]

def preorder(node):
    res = []
    def go(node):
        if node is None: return
        res.append(node.value)
        go(node.left)
        go(node.right)
    go(node)
    return res

def test_preorder():
    assert preorder(None) == []
    root = TreeNode(5)
    assert preorder(root) == [5]
    root = TreeNode(5,
        TreeNode(3, TreeNode(1), TreeNode(4)),
        TreeNode(8, TreeNode(7), TreeNode(10)))
    assert preorder(root) == [5, 3, 1, 4, 8, 7, 10]
    root = TreeNode(5, TreeNode(3, TreeNode(1), None), None)
    assert preorder(root) == [5, 3, 1]
    root = TreeNode(5, None, TreeNode(7, None, TreeNode(9)))
    assert preorder(root) == [5, 7, 9]
    root = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), None))
    assert preorder(root) == [6, 4, 9, 7]

def postorder(node):
    res = []
    def go(node):
        if not node: return
        go(node.left)
        go(node.right)
        res.append(node.value)
    go(node)
    return res

def test_postorder():
    assert postorder(None) == []
    assert postorder(TreeNode(5)) == [5]
    root = TreeNode(5,
        TreeNode(3, TreeNode(1), TreeNode(4)),
        TreeNode(8, TreeNode(7), TreeNode(10)))
    assert postorder(root) == [1, 4, 3, 7, 10, 8, 5]
    root = TreeNode(5, TreeNode(3, TreeNode(1), None), None)
    assert postorder(root) == [1, 3, 5]
    root = TreeNode(5, None, TreeNode(7, None, TreeNode(9)))
    assert postorder(root) == [9, 7, 5]
    root = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), None))
    assert postorder(root) == [4, 7, 9, 6]


### SEARCH ###

def search(node:TreeNode, desired_value):
    if node is None: return None
    if node.value == desired_value:
        return node
    if desired_value < node.value:
        return search(node.left, desired_value)
    if node.value < desired_value:
        return search(node.right, desired_value)

def test_search():
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11)))
    assert search(root, 11).value == 11
    assert search(root, 4).value == 4
    assert search(root, 7).value == 7
    assert search(root, 100) is None
    assert search(root, 5) is None


### INSERTION ###

def insert(node: TreeNode, new_value):
    if node is None:
        return TreeNode(new_value)
    if node.value == new_value:
        return node
    elif new_value < node.value:
        node.left = insert(node.left, new_value)
    else:
        node.right = insert(node.right, new_value)
    return node

def test_insert():
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11)))
    # insert new values
    root = insert(root, 5)
    root = insert(root, 10)
    root = insert(root, 3)
    assert search(root, 5).value == 5
    assert search(root, 10).value == 10
    assert search(root, 3).value == 3
    # insert existing value — should do nothing
    before = search(root, 4)
    root = insert(root, 4)
    after = search(root, 4)
    assert before is after

def levelorder(node):
    res = []
    def go(node, level=0):
        if not node: return
        if len(res) <= level:
            res.append([])
        res[level].append(node.value)
        go(node.left, level+1)
        go(node.right, level+1)
    go(node)
    return res

def test_levelorder():
    assert levelorder(None) == []
    root = TreeNode(5)
    assert levelorder(root) == [[5]]
    root = TreeNode(5,
        TreeNode(3, TreeNode(1), TreeNode(4)),
        TreeNode(8, TreeNode(7), TreeNode(10)))
    assert levelorder(root) == [[5], [3, 8], [1, 4, 7, 10]]
    root = TreeNode(5, TreeNode(3, TreeNode(1), None), None)
    assert levelorder(root) == [[5], [3], [1]]
    root = TreeNode(5, None, TreeNode(7, None, TreeNode(9)))
    assert levelorder(root) == [[5], [7], [9]]
    root = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), None))
    assert levelorder(root) == [[6], [4, 9], [7]]


### DELETION ###

def delete(node: TreeNode, key):
    if not node:
        return None
    # replace
    if key < node.value:
        node.left = delete(node.left, key)
    elif node.value < key:
        node.right = delete(node.right, key)
    elif key == node.value:
        # return
        if not node.left and not node.right:
            return None
        elif not node.left:
            return node.right
        elif not node.right:
            return node.left
        else:
            successor = node.right
            while successor.left:
                successor = successor.left
            node.value = successor.value
            node.right = delete(node.right, successor.value)
    return node

def test_delete():
    # 1) delete leaf node
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11)))
    root = delete(root, 11)
    assert inorder(root) == [4, 6, 7, 9]
    assert 11 not in inorder(root)
    # 2) delete node with one child (non-root)
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), None))
    root = delete(root, 9)
    assert root.value == 6
    assert root.right is not None
    assert root.right.value == 7
    assert inorder(root) == [4, 6, 7]
    # 3) delete node with two children (non-root)
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11)))
    root = delete(root, 9)
    vals = inorder(root)
    assert vals == sorted(vals)
    assert 9 not in vals
    # 4) delete root leaf
    root = TreeNode(5)
    root = delete(root, 5)
    assert root is None
    # 5) delete root with one child
    root = TreeNode(5, None, TreeNode(7))
    root = delete(root, 5)
    assert root is not None
    assert root.value == 7
    assert inorder(root) == [7]
    # 6) delete root with two children
    root = TreeNode(5,
        TreeNode(3),
        TreeNode(8, TreeNode(7), None))
    root = delete(root, 5)
    vals = inorder(root)
    assert vals == sorted(vals)
    assert 5 not in vals
    assert len(vals) == 3
    # 7) delete non-existing key keeps tree
    root = TreeNode(5,
        TreeNode(3),
        TreeNode(8))
    before = inorder(root)
    root2 = delete(root, 42)
    after = inorder(root2)
    assert before == after
    # 8) delete all nodes to empty
    root = TreeNode(8,
        TreeNode(3,
            TreeNode(1),
            TreeNode(6)),
        TreeNode(10,
            None,
            TreeNode(14)))
    for key in [1, 3, 6, 8, 10, 14]:
        root = delete(root, key)
    assert root is None