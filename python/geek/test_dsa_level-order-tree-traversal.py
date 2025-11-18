# https://www.geeksforgeeks.org/dsa/level-order-tree-traversal/

# Level Order Traversal technique is a method to traverse 
# a Tree such that all nodes present in the same level are 
# traversed completely before traversing the next level.

from typing import Optional, List

class Node:
    def __init__(self, value:int) -> None:
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None
        self.value = value

def level_order(node: Optional[Node]):
    res = []
    def go(node, level=0):
        if node is None: return 
        if len(res) <= level:
            res.append([])
        res[level].append(node.value)
        go(node.left, level+1)
        go(node.right, level+1)
    go(node)
    return res

def test():
    # helper to build nodes quickly
    def N(v, l=None, r=None): 
        n = Node(v)
        n.left = l
        n.right = r
        return n
    root = N(5,
             N(12,
               N(7, N(17), N(23)),
               N(14, N(27), N(3))),
             N(13,
               None,
               N(2, N(8), N(11))))
    assert level_order(root) == [
        [5],
        [12, 13],
        [7, 14, 2],
        [17, 23, 27, 3, 8, 11],]