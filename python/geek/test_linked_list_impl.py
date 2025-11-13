from typing import Optional

class Node:
    def __init__(self, x:int):
        self.data = x
        self.next: Optional[Node] = None

class Stack:
    def __init__(self):
        self.top: Optional[Node] = None
    def push(self, x:int):
        temp = Node(x)
        temp.next = self.top
        self.top = temp
    def pop(self) -> Optional[int]:
        if self.top is None:
            return None
        else: 
            temp: Node = self.top
            self.top = temp.next
            return temp.data
    def peek(self) -> Optional[int]:
        if self.top is None:
            return None
        else: 
            return self.top.data
    def is_empty(self):
        return self.top is None
    
def test_new_stack_is_empty():
    s = Stack()
    assert s.is_empty()
    assert s.peek() is None
    assert s.pop() is None

def test_push_and_peek():
    s = Stack()
    s.push(10)
    assert not s.is_empty()
    assert s.peek() == 10

def test_lifo_pop_order():
    s = Stack()
    for x in [1, 2, 3]:
        s.push(x)
    assert s.pop() == 3
    assert s.pop() == 2
    assert s.pop() == 1
    assert s.pop() is None  # empty now

def test_interleaved_ops():
    s = Stack()
    s.push(5)
    s.push(7)
    assert s.pop() == 7
    s.push(9)
    assert s.peek() == 9
    assert s.pop() == 9
    assert s.pop() == 5
    assert s.is_empty()