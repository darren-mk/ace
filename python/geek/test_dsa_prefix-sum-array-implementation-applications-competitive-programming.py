# https://www.geeksforgeeks.org/dsa/prefix-sum-array-implementation-applications-competitive-programming/

from typing import List

def f(arr: List[int]) -> List[int]:
    total: int = 0
    acc: List[int] = []
    for x in arr:
        total += x 
        acc.append(total)
    return acc

def test():
    assert f([10, 20, 10, 5, 15]) == [10, 30, 40, 45, 60]
    assert f([30, 10, 10, 5, 50]) == [30, 40, 50, 55, 105]