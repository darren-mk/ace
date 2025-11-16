# https://www.geeksforgeeks.org/dsa/lucas-numbers/

def iteratively(n:int):
    a = 2
    b = 1
    match n:
        case 0:
            return a
        case 1:
            return b
        case _:
            pass
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b 

def test_iteratively():
    assert iteratively(0) == 2
    assert iteratively(1) == 1
    assert iteratively(5) == 11
    assert iteratively(10) == 123
    assert iteratively(15) == 1364