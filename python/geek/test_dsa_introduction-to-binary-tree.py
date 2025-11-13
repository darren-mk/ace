# https://www.geeksforgeeks.org/dsa/introduction-to-binary-tree/

from typing import Optional

class Node:
    def __init__(self, val: int) -> None:
        self.val: int = val 
        self.left: Optional[Node] = None 
        self.right: Optional[Node] = None

# initialize nodes
firstNode = Node(2)
secondNode = Node(3)
thirdNode = Node(4)
fourthNode = Node(5)

# connect nodes
firstNode.left = secondNode
firstNode.right = thirdNode
secondNode.left = fourthNode