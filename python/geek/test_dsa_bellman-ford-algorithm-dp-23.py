# https://www.geeksforgeeks.org/dsa/bellman-ford-algorithm-dp-23/

import sys
from typing import List

def f_a(V:int, edges:List[List[int]], src:int) -> List[int]:
    return [src, V]

def test_a():
    assert [ sys.maxsize for _ in range(3) ] == [ sys.maxsize ] * 3
    V = 5
    edges = [[1, 3, 2], [4, 3, -1], [2, 4, 1], [1, 2, 1], [0, 1, 5]]
    src = 0
    assert f_a(V, edges, src) == [0, 5, 6, 6, 7]