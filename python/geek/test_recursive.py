from typing import Optional

class Node:
    def __init__(self, data: int) -> None:
        self.data = data
        self.next: Optional[Node] = None

def print_linked_list(node: Optional[Node]):
    if node is None:
        return
    else:
        print(node.data)
        print_linked_list(node.next)