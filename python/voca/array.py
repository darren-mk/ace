import array as ar

def test_declaration():
    a = ar.array('I', [1, 2, 3])
    assert a[0] == 1
    assert a[1] == 2