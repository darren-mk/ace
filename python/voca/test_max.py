def test_max_default():
    assert 5 == max(1, 3, 5)
    assert 11 == max([3, 7, 11])

def max_a(*args):
    candidate = None 
    l = args[0] if len(args) == 1 else args
    for item in l: 
        if candidate is None or item > candidate:
            candidate = item
    return candidate

def test_max_a():
    assert 5 == max_a(1, 3, 5)
    assert 11 == max_a([3, 7, 11])