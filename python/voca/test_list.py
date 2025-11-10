def test_list_append():
    l = [1, 2, 3]
    l.append(4)
    assert l == [1, 2, 3, 4]

def test_list_pop():
    l = [1, 2, 3]
    l.pop()
    assert l == [1, 2]
    l.pop(0)
    assert l == [2]

def test_list_length(): 
    l = [10, 20, 30]
    assert len(l) == 3