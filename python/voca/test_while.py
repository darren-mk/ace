def test_while_basics():
    sum = 0
    i = 0 
    while i < 3:
        i += 1
        sum += i * 10 
    assert sum == 60
    