# https://www.geeksforgeeks.org/dsa/row-wise-vs-column-wise-traversal-matrix/

def row_a(mat):
    res = []
    for row in mat:
        for item in row:
            res.append(item)
    return res

def test_row_a():
    assert row_a([[1,2,3],[4,5,6],[7,8,9]]) == [1,2,3,4,5,6,7,8,9]

def col_a(mat):
    res = []
    for i in range(len(mat[0])):
        for row in mat:
            res.append(row[i])
    return res

def test_col_a():
    assert col_a([[1,2,3],[4,5,6],[7,8,9]]) == [1,4,7,2,5,8,3,6,9]

def row_b(mat):
    res = []
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            res.append(mat[i][j])
    return res

def test_row_b():
    assert row_b([[1,2],[3,4],[5,6]]) == [1,2,3,4,5,6]

def col_b(mat):
    res = []
    for j in range(len(mat[0])):
        for i in range(len(mat)):
            res.append(mat[i][j])
    return res

def test_col_b():
    assert col_b([[1,2,3],[4,5,6],[7,8,9]]) == [1,4,7,2,5,8,3,6,9]