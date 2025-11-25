# https://www.geeksforgeeks.org/dsa/search-in-a-matrix-or-2d-array/

def matrixSearchA(mat, x):
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if mat[i][j] == x:
                return True
    return False

def testA():
    assert matrixSearchA([[10, 51, 9],
                          [14, 20, 21],
                          [30, 24, 43]], 14) == True
    assert matrixSearchA([[31, 5, 9, 11],
                          [14, 7, 21, 26],
                          [30, 4, 43, 50]], 42) == False