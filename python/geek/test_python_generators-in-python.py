# https://www.geeksforgeeks.org/python/generators-in-python/

from typing import List

def foo():
    yield 1
    yield 2
    yield 3
    
def test_yield():
    count = 0
    for v in foo():
        assert v == v
        count += 1
    assert count == 3

def test_generator_expression():
    sq = (x * x for x in range(3))
    acc: List[int] = []
    for x in sq:
        acc.append(x)
    assert acc == [0, 1, 4]