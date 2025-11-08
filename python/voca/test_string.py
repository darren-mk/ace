def test_string_reference():
    assert 'b' == 'abc'[1]
    assert 'e' == ['abc', 'def'][1][1]

def test_string_formatting():
    name = "Darren"
    txt = f"Hello, {name}"
    assert txt == "Hello, Darren"

def test_string_slicing():
    s = "Hello, World!"
    assert s[0:5] == "Hello"
    assert s[7:] == "World!"
    assert s[-6:-1] == "World"