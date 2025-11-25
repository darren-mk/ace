# https://www.geeksforgeeks.org/dsa/program-addition-two-matrices/

def addA(A, B):
    res = []
    for i in range(len(A)):
        row = []
        for j in range(len(A[0])):
            row.append(A[i][j] + B[i][j])
        res.append(row)
    return res

def testA():
    A = [[1, 1, 1], [2, 2, 2], [3, 3, 3], [4, 4, 4]]
    B = [[1, 1, 1], [2, 2, 2], [3, 3, 3], [4, 4, 4]]
    assert addA(A, B) == [[2, 2, 2], [4, 4, 4], [6, 6, 6], [8, 8, 8]]