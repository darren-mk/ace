# https://www.geeksforgeeks.org/dsa/program-subtraction-matices/

def subtractA(m1, m2):
    res = []
    for i in range(len(m1)):
        row = []
        for j in range(len(m1[0])):
            row.append(m1[i][j] - m2[i][j])
        res.append(row)
    return res

def testA():
    A = [[1,2],[3,4]]
    B = [[4,3],[2,1]]
    assert subtractA(A, B) == [[-3, -1], [1, 3]]
    assert A == [[1,2],[3,4]]
    assert B == [[4,3],[2,1]]
    assert subtractA([[3, 3, 3], [3, 3, 3]], [[2, 2, 2], [1, 1, 1]]) == [[1, 1, 1], [2, 2, 2]]