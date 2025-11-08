import datetime

def test_datetime_gen():
    dt = datetime.datetime(2024, 6, 15, 14, 30, 0)
    assert dt.year == 2024
    assert dt.month == 6
    assert dt.day == 15
    assert dt.hour == 14
    assert dt.minute == 30
    assert dt.second == 0