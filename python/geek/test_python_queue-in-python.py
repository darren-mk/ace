# https://www.geeksforgeeks.org/python/queue-in-python/

from typing import List

def test_impl_using_list():
    q: List[int] = []
    q.append(1)
    q.append(2)
    q.append(3)
    assert q == [1, 2, 3]
    q.pop(0)
    assert q == [2, 3]