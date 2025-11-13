from typing import Optional

class Node:
    def __init__(self, data: int) -> None:
        self.data = data
        self.next: Optional[Node] = None

def print_linked_list(node: Optional[Node]):
    while node:
        print(node.data)
        node = node.next