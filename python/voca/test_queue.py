class QueueWithList():
    def __init__(self):
        self.l = []
    def enqueue(self, value):
        self.l.append(value)
    def dequeue(self):
        if not self.is_empty(): 
            self.l.pop(0)
    def is_empty(self):
        return self.get_size() == 0
    def get_size(self):
        return len(self.l)
    
def test_queue_with_list():
    q = QueueWithList()
    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)
    assert q.get_size() == 3
    q.dequeue() 
    assert q.get_size() == 2

class Node:
    def __init__(self, v):
        self.value = v
        self.next = None

class QueueWithNodeClass():
    def __init__(self):
        self.front = None 
        self.rear = None
        self.size = 0
    def enq(self, v):
        new_node = Node(v)
        if self.is_empty(): 
            self.front = self.rear = new_node
        else: 
            self.rear.next = new_node
            self.rear = new_node
        self.size += 1
    def deq(self):
        if not self.is_empty():
            temp = self.front
            self.front = self.front.next
            self.size -= 1
            if self.front is None: 
                self.rear = None
                self.size = 0
            return temp.value
    def get_size(self):
        return self.size
    def is_empty(self):
        return self.get_size() == 0
    def traverse_values(self):
        values = []
        cursor = self.front
        while cursor:
            values.append(cursor.value)
            cursor = cursor.next
        return values

def test_queue_with_node_class():
    q = QueueWithNodeClass()
    assert q.get_size() == 0
    assert q.is_empty()
    q.enq(10)
    q.enq(20)
    q.enq(30)
    assert q.get_size() == 3
    q.deq()
    assert q.get_size() == 2
    assert q.traverse_values() == [20, 30] 