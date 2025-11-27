# https://www.geeksforgeeks.org/python/python-bitwise-operators/

def test_and():
    assert 3 & 2 == 2
    assert 2 & 1 == 0

def test_or():
    assert 3 | 2 == 3
    assert 3 | 1 == 3
    assert 2 | 1 == 3

def test_xor():
    assert 3 ^ 2 == 1
    assert 3 ^ 3 == 0

def test_not():
    a = 4
    b = - 5
    assert ~a == b
    assert ~b == a

def test_shift():
    a = 2
    assert a >> 1 == 1
    assert a == 2
    assert a << 1 == 4
    assert a << 2 == 8