from typing import List
class MyStack:

    def __init__(self):
        self.values: List[int] = []

    def push(self, x: int) -> None:
        self.values.append(x)

    def pop(self) -> int:
        return self.values.pop()

    def top(self) -> int:
        return self.values[-1]

    def empty(self) -> bool:
        return len(self.values) == 0
    
def test_my_stack():
    myStack = MyStack()
    myStack.push(1)
    myStack.push(2)
    assert myStack.top() == 2
    assert myStack.pop() == 2
    assert myStack.empty() == False