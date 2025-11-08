def test_iterator_next():
    it = iter([1, 2, 3])
    assert 1 == next(it)
    assert 2 == next(it)
    assert 3 == next(it)
    try:
        next(it)
        assert False, "Expected StopIteration"
    except StopIteration:
        pass