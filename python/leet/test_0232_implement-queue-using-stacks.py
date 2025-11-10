class MyQueue:

    def __init__(self):
        self.values = []  

    def push(self, x: int) -> None:
        self.values.append(x)

    def pop(self) -> int:
        temp = self.values[0]
        self.values = self.values[1:]
        return temp  

    def peek(self) -> int:
        return self.values[0]

    def empty(self) -> bool:
        return len(self.values) == 0

def test_myqueue():
    myQueue = MyQueue()
    myQueue.push(1) # queue is: [1]
    myQueue.push(2) # queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek() # return 1
    myQueue.pop() # return 1, queue is [2]
    myQueue.empty() #  return false