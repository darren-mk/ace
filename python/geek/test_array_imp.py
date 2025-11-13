class Stack:
    def __init__(self, cap: int) -> None:
        self.cap = cap
        self.arr = [0] * cap
        self.top = -1
    def push(self, x: int):
        if self.top >= self.cap - 1:
            return "stack overflow" 
        self.top += 1
        self.arr[self.top] = x
    def pop(self):
        if self.top < 0:
            return "stack underflow"
        temp = self.arr[self.top]
        self.top -= 1
        return temp
    def peek(self):
        return self.arr[self.top]
    def is_empty(self):
        return self.top < 0