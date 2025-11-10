class StackByBuiltInList: 
    def __init__(self, initial=[]):
        self.data = initial 
    def push(self, item):
        self.data.append(item)
    def pop(self):
        self.data.pop()
    def size(self):
        return len(self.data)
    def is_empty(self):
        return len(self.data) == 0

def test_stackbuiltinlist_push():
    s1 = StackByBuiltInList()  
    assert s1.is_empty() is True
    s1.push(10)
    s1.push(20)
    assert len(s1.data) == 2
    assert s1.size() == 2
    assert s1.data[0] == 10
    s1.pop()
    assert len(s1.data) == 1
    assert s1.size() == 1
    assert s1.data[0] == 10

class Node():
    def __init__(self, value):
        self.value = value
        self.connected = None

class StackByCustomListNode():
    def __init__(self):
        self.top = None
        self._size = 0
    def push(self, value):
        new_node = Node(value)
        if self.top:
            new_node.connected = self.top
        self.top = new_node
        self._size += 1
    def pop(self):
        if self.is_empty():
            return "stack is empty"
        popped_node = self.top
        self.top = popped_node.connected
        self._size -= 1
        return popped_node.value
    def peek(self):
        return self.top.value
    def get_size(self):
        return self._size
    def is_empty(self):
        return self._size == 0
    def traverse_values(self):
        l = []
        cursor = self.top
        while cursor:
            l.append(cursor.value)
            cursor = cursor.connected
        return l[::-1]

def test_stackbuiltinlist_push():
    s = StackByCustomListNode()
    assert s.is_empty()
    s.push(10)
    s.push(20)
    s.push(30)
    assert s.is_empty() == False
    assert s.get_size() == 3
    assert s.traverse_values() == [10, 20, 30]
    s.pop()
    assert s.get_size() == 2
    assert s.traverse_values() == [10, 20]