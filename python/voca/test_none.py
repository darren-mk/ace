def test_none_boolean():
    assert None is None
    assert not None 
    assert (None == False) is False
    assert (None == True) is False
    assert bool(None) is False