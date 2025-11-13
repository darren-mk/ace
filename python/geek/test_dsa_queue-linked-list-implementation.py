# https://www.geeksforgeeks.org/dsa/queue-linked-list-implementation/

from typing import Optional

class Node:
    def __init__(self, data: int) -> None:
        self.data: int = data
        self.next: Optional[Node] = None

class Queue:
    def __init__(self) -> None:
        self.front: Optional[Node] = None 
        self.rear: Optional[Node] = None
    def enqueue(self, data:int):
        new = Node(data)
        if self.is_empty() or self.rear is None:
            self.front = self.rear = new
        else:
            self.rear.next = new ### pylance is complaining about `next`
            self.rear = new
    def dequeue(self) -> Optional[int]:
        existing_front = self.front
        if existing_front is None:
            return None
        else:
            self.front = existing_front.next
            if self.front is None:
                self.rear = None
            return existing_front.data
    def is_empty(self):
        return self.front is None
    def get_front(self):
        if self.front is None:
            return None 
        else: 
            return self.front.data
    def get_size(self) -> int:
        count = 0
        cursor = self.front
        while cursor:
            count += 1
            cursor = cursor.next
        return count
        
def test():
    q = Queue()
    q.enqueue(10)
    q.enqueue(20)
    assert q.get_size() == 2
    assert q.dequeue() == 10
    assert q.get_size() == 1
    q.enqueue(30)
    assert q.get_size() == 2
    assert q.get_front() == 20
    assert not q.is_empty()
    assert q.dequeue() == 20
    assert q.dequeue() == 30
    assert q.is_empty()
    assert q.dequeue() is None
    assert q.get_size() == 0