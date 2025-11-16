# https://www.geeksforgeeks.org/dsa/introduction-to-matrix-or-grid-data-structure-and-algorithms-tutorial/

from typing import List

def test_matrix_declaration():
    rows, cols = (3, 3)
    mat = [[0] * rows] * cols
    assert mat == [[0,0,0], [0,0,0], [0,0,0]]

def test_accessing_elements():
    arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    # first element of first row
    assert arr[0][0] == 1
    # third element of second row 
    assert arr[1][2] == 6
    # second element of third row
    assert arr[2][1] == 8

def test_traverse():
    mat = [[1,2,3],[4,5,6],[7,8,9]]
    acc: List[int] = []
    for row in mat:
        for item in row:
            acc.append(item)
    assert acc == [x for x in range(1, 10)]

def search(matrix: List[List[int]], target: int) -> bool:
    for row in matrix:
        for item in row:
            if item == target:
                return True
    return False

def test_search():
    mat : List[List[int]] = [[0, 6, 8, 9, 11],
                             [20, 22, 28, 29, 31],
                             [36, 38, 50, 61, 63],
                             [64, 66, 100, 122, 128]]
    assert search(mat, 8) == True
    assert search(mat, 7) == False