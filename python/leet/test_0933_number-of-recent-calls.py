class RecentCounter:

    def __init__(self):
        self.values = []

    def ping(self, t: int) -> int:
        self.values.append(t)
        if len(self.values) <= 1:
            return 1
        collection_count = 1
        while self.values[-collection_count] + 3000 < t and collection_count < len(self.values):
            collection_count += 1
        return collection_count
    ### NOT SOLVED

def test_recent_counter():
    recentCounter = RecentCounter()
    assert [1,2,3][-1] == 3
    assert recentCounter.ping(1) == 1 
    assert recentCounter.ping(100) == 2
    assert recentCounter.ping(3001) == 3
    assert recentCounter.ping(3002) == 3