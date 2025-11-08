def add_elem(l, x):
    l.append(x)

def test_basics():
    l = [1, 2, 3]
    add_elem(l, 4)
    assert [1, 2, 3, 4] == l

def test_empty():
    l = []
    add_elem(l, 'a')
    assert ['a'] == l