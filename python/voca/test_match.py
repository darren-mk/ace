def test_basics():
    fav_num = 3
    result = None
    match fav_num:
        case 0 | 1:
            result = "zero or one"
        case 2:
            result = "two"
        case 3:
            result = "three"
        case _:
            result = "unknown"
    assert "three" == result