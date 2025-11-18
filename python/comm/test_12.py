
class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


### SEARCH ###

def search(node:TreeNode, desired_value):
    if node is None:
        return None
    elif node.value == desired_value:
        return node
    if desired_value < node.value:
        return search(node.left, desired_value)
    else:
        return search(node.right, desired_value)

def test_search():
    node = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), TreeNode(11)))
    assert search(node, 11)
    assert search(node, 4).value == 4


### INSERTION ###

def insert(node: TreeNode, new_value):
    if node is None:
        return TreeNode(new_value)
    if new_value < node.value:
        node.left = insert(node.left, new_value)
    else:
        node.right = insert(node.right, new_value)
    return node

def test_insert():
    node = TreeNode(6, TreeNode(4), TreeNode(9, TreeNode(7), TreeNode(11)))
    node = insert(node, 5)
    assert search(node, 5).value == 5


### DELETION ###

def delete(node: TreeNode, value):
    # reached bottom of the tree
    if node is None:
        return None
    # replace
    if value < node.value:
        node.left = delete(node.left, value)
    elif value > node.value:
        node.right = delete(node.right, value)
    elif value == node.value:
        if node.left is None and node.right is None:
            return None
        if node.left is None:
            return node.right
        if node.right is None:
            return node.left
        successor = node.right
        while successor.left:
            successor = successor.left
        node.value = successor.value
        node.right = delete(node.right, successor.value)
    return node

# helper: inorder traversal to check BST structure
def inorder(node: TreeNode):
    if node is None:
        return []
    return inorder(node.left) + [node.value] + inorder(node.right)

def test_delete_leaf_node():
    #       6
    #     /   \
    #    4     9
    #         / \
    #        7   11
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11))
    )
    # delete leaf 11
    root = delete(root, 11)
    assert inorder(root) == [4, 6, 7, 9]
    # 11 should be gone
    assert 11 not in inorder(root)

def test_delete_node_with_one_child():
    #       6
    #     /   \
    #    4     9
    #         /
    #        7
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), None))
    # delete 9 (has one child: 7)
    root = delete(root, 9)
    # 7 should be directly under 6 on the right
    assert root.value == 6
    assert root.right is not None
    assert root.right.value == 7
    assert inorder(root) == [4, 6, 7]


def test_delete_node_with_two_children():
    #       6
    #     /   \
    #    4     9
    #         / \
    #        7   11
    root = TreeNode(6,
        TreeNode(4),
        TreeNode(9, TreeNode(7), TreeNode(11)))
    # delete 9 (two children)
    root = delete(root, 9)
    # BST property still holds
    vals = inorder(root)
    assert vals == sorted(vals)
    # 9 should be gone
    assert 9 not in vals


def test_delete_root_leaf():
    root = TreeNode(5)
    root = delete(root, 5)
    assert root is None


def test_delete_root_with_one_child():
    #   5
    #    \
    #     7
    root = TreeNode(5, None, TreeNode(7))
    root = delete(root, 5)
    assert root is not None
    assert root.value == 7
    assert inorder(root) == [7]


def test_delete_root_with_two_children():
    #       5
    #     /   \
    #    3     8
    #         /
    #        7
    root = TreeNode(5,
        TreeNode(3),
        TreeNode(8, TreeNode(7), None)
    )
    root = delete(root, 5)
    vals = inorder(root)
    # still a valid sorted BST
    assert vals == sorted(vals)
    assert 5 not in vals
    # size decreased by 1
    assert len(vals) == 3

def test_delete_non_existing_key_keeps_tree():
    root = TreeNode(5,
        TreeNode(3),
        TreeNode(8)
    )
    before = inorder(root)
    root2 = delete(root, 42)
    after = inorder(root2)
    assert before == after    # nothing changed

def test_delete_all_nodes_to_empty():
    # build a small BST
    root = TreeNode(8,
        TreeNode(3,
            TreeNode(1),
            TreeNode(6)
        ),
        TreeNode(10,
            None,
            TreeNode(14)
        )
    )
    for key in [1, 3, 6, 8, 10, 14]:
        root = delete(root, key)

    assert root is None


### TRAVERSALS ###

sample_root = TreeNode(8,
                TreeNode(3,
                    TreeNode(1),
                    TreeNode(6)),
                TreeNode(10,
                    None,
                    TreeNode(14)))

def inorder_traverse(node:TreeNode):
    if node is None: return []
    return inorder_traverse(node.left) + [node.value] + inorder_traverse(node.right)

def test_inorder_traverse():
    assert inorder_traverse(sample_root) == [1,3,6,8,10,14]

def preorder_traverse(node:TreeNode):
    if node is None: return []
    return [node.value] + preorder_traverse(node.left) + preorder_traverse(node.right)

def test_preorder_traverse():
    assert preorder_traverse(sample_root) == [8,3,1,6,10,14]

def postorder_traverse(node:TreeNode):
    if node is None: return []
    return postorder_traverse(node.left) + postorder_traverse(node.right) + [node.value]

def test_postorder_traverse():
    assert postorder_traverse(sample_root) == [1,6, 3, 14, 10, 8]