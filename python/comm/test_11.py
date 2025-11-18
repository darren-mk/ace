from typing import Optional

class Node:
    def __init__(self, value:str, next: Optional[Node] = None) -> None:
        self.value = value
        self.next = next

def test_node():
    darren = Node("darren")
    kim = Node("kim", darren)
    assert darren.value == "darren"
    assert kim.value == "kim"
    assert kim.next.value if kim.next else "" == "darren"

class LinkedList:
    def __init__(self, first_node: Optional[Node]) -> None:
        self.first_node: Optional[Node] = first_node
    def read(self, index:int) -> Optional[str]:
        i = 0
        node = self.first_node
        while node:
            if i >= index:
                return node.value
            node = node.next
            i += 1
        return None
    def index_of(self, desired_value:str) -> Optional[int]:
        i = 0
        node = self.first_node
        while node:
            if node.value == desired_value:
                return i
            i += 1
            node = node.next
        return None
    def insert_at(self, desired_index:int, desired_value:str):
        i = 0
        node = self.first_node
        if desired_index == 0:
            self.first_node = Node(desired_value, node)
            return
        while node: 
            if i == desired_index - 1:
                node.next = Node(desired_value, node.next)
                return
            i += 1
            node = node.next
    def delete_at(self, desired_index:int):
        i = 0
        node = self.first_node
        if desired_index == 0:
            self.first_node = node.next
            return
        while node:
            if i == desired_index - 1:
                if node.next is None:
                    return 
                node.next = node.next.next
                return 
            i += 1
            node = node.next

def test_linked_list():
    ll = LinkedList(Node("darren", Node("kim", Node("minsoo"))))
    assert ll.read(0) == "darren"
    assert ll.read(1) == "kim"
    assert ll.read(2) == "minsoo"
    assert ll.read(3) == None
    assert ll.index_of("darren") == 0
    assert ll.index_of("kim") == 1
    assert ll.index_of("minsoo") == 2
    assert ll.index_of("yay") == None
    ll.insert_at(2, "coolguy")
    assert ll.read(2) == "coolguy"
    assert ll.read(3) == "minsoo"
    assert ll.read(4) == None

class DualNode:
    def __init__(self, value, previous=None, next=None) -> None:
        self.value = value 
        self.previous = previous
        self.next = next

class DoublyLinkedList:
    def __init__(self):
        self.first_node = None
        self.last_node = None
    def insert_at_end(self, value):
        last_node = self.last_node
        if last_node is None:
            new_node = DualNode(value)
            self.first_node = new_node
            self.last_node = new_node
        else: 
            new_node = DualNode(value, last_node)
            last_node.next = new_node
            self.last_node = new_node
    def read(self, desired_index):
        i = 0
        node = self.first_node
        while node:
            if i == desired_index:
                return node.value
            i += 1
            node = node.next
        return None
    def remove_from_front(self):
        first_node = self.first_node
        if first_node is None:
            return None
        second_node = self.first_node.next
        if second_node is None:
            self.first_node = None 
            self.last_node = None 
        else:     
            second_node.previous = None
            self.first_node = second_node
        return first_node.value

def test_doubly_linked_list():
    dll = DoublyLinkedList()
    dll.insert_at_end('darren')
    dll.insert_at_end('minsoo')
    dll.insert_at_end('kim')
    assert dll.read(0) == 'darren'
    assert dll.read(1) == 'minsoo'
    assert dll.read(2) == 'kim'
    dll.remove_from_front()
    assert dll.read(0) == 'minsoo'
    assert dll.read(1) == 'kim'

class Queue:
    def __init__(self):
        self.doubly_linked_list = DoublyLinkedList()
    def enque(self, value):
        self.doubly_linked_list.insert_at_end(value)
    def deque(self):
        return self.doubly_linked_list.remove_from_front()
    def read(self, index):
        return self.doubly_linked_list.read(index)
    def is_empty(self):
        return self.doubly_linked_list.first_node is None
    
def test_queue_basic_fifo():
    q = Queue()
    assert q.is_empty() is True
    q.enque('a')
    q.enque('b')
    q.enque('c')
    assert q.is_empty() is False
    assert q.deque() == 'a'
    assert q.deque() == 'b'
    assert q.deque() == 'c'
    assert q.is_empty() is True
    assert q.deque() is None  # dequeue from empty


def test_queue_interleaved():
    q = Queue()
    q.enque(1)
    q.enque(2)
    assert q.deque() == 1
    q.enque(3)
    q.enque(4)
    assert q.deque() == 2
    assert q.deque() == 3
    assert q.deque() == 4
    assert q.deque() is None
    assert q.is_empty() is True


def test_queue_read_helper():
    q = Queue()
    q.enque('x')
    q.enque('y')
    q.enque('z')
    assert q.read(0) == 'x'
    assert q.read(1) == 'y'
    assert q.read(2) == 'z'
    assert q.read(3) is None
    q.deque()
    assert q.read(0) == 'y'
    assert q.read(1) == 'z'
