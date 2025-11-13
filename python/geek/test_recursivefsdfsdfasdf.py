from typing import Optional

class Node:
    def __init__(self, data: int) -> None:
        self.data = data
        self.next: Optional[Node] = None

def count_nodes(head: Optional[Node]) -> int:
    if head is None:
        return 0
    else: 
        return 1 + count_nodes(head.next)

def test():
    head = Node(1)
    head.next = Node(3)
    head.next.next = Node(1)
    head.next.next.next = Node(2)
    head.next.next.next.next = Node(1)
    assert count_nodes(head) == 5