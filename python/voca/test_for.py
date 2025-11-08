def test_for_basics():
    sum = 0
    for i in range(5):
        sum += i
    assert sum == 10