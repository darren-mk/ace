# https://www.geeksforgeeks.org/dsa/print-alternate-elements-of-an-array/

from typing import List

def f(l: List[int]):
    acc: List[int] = []
    toggle = True 
    for x in l:
        if toggle:
            acc.append(x)
        toggle = not toggle
    return acc

def test():
    assert f([10, 20, 30, 40, 50]) == [10, 30, 50]
    assert f([-5, 1, 4, 2, 12]) == [-5, 4, 12]