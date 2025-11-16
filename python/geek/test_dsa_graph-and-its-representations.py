# https://www.geeksforgeeks.org/dsa/graph-and-its-representations/

from typing import List

def create_undirected(v: int, edges: List[List[int]]):
    mat = [[0 for _ in range(v)] for _ in range(v)]
    for edge in edges:
        [origin, destination] = edge
        mat[origin][destination] = 1
        mat[destination][origin] = 1
    return mat

def test_undirected():
    [a, b] = [1, 2]
    assert a == 1
    assert b == 2
    assert create_undirected(3, [[0,1],[0,2],[1,2]]) == [[0,1,1],[1,0,1],[1,1,0]]

def create_directed(v:int, edges: List[List[int]]):
    mat = [[0 for _ in range(v)] for _ in range(v)]
    for edge in edges:
        [origin,destination] = edge
        mat[origin][destination] = 1
    return mat

def test_directed():
    assert create_directed(3, [[1,0],[2,0],[1,2]]) == [[0,0,0],[1,0,1],[1,0,0]]