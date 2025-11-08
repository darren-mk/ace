def test_min_default():
    assert 1 == min(1, 3, 5)
    assert 3 == min([3, 7, 11])

def min_a(*args):
    candidate = None
    l = args[0] if len(args) == 1 else args
    for item in l:
        if candidate is None or item < candidate:
            candidate = item
    return candidate

def test_min_a():
    assert 1 == min_a(1, 3, 5)
    assert 3 == min_a([3, 7, 11])