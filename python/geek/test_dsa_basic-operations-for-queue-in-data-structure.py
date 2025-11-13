# https://www.geeksforgeeks.org/dsa/basic-operations-for-queue-in-data-structure/

from collections import deque
from typing import Deque

class Node:
    def __init__(self) -> None:
        pass

def test():
    q: Deque[int] = deque()
    q.append(10)
    q.append(20)
    q.append(30)
    assert q.popleft() == 10
