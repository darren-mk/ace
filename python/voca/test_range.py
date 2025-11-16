def test_range_basics():
    r1 = range(3)
    assert list(r1) == [0, 1, 2]
    r2 = range(3, 7)
    assert list(r2) == [3, 4, 5, 6]
    r3 = range(5, 15, 3)
    assert list(r3) == [5, 8, 11, 14]
    assert list(range(9, 1, -2)) == [9, 7, 5, 3]