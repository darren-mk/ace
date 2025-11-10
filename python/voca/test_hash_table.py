def test_ord():
    assert ord('a') == 97

def hash(s, population):
    sum_of_chars = 0
    for c in s:
        sum_of_chars += ord(c)
    return sum_of_chars % population

def test_hash():
    assert hash('abc', 5) == 4

class Pair():
    def __init__(k, v):
        pass

class HashTable():
    def __init__(self, size):
        self.size = size
        self.l = []
        for _ in range(size):
            self.l.append(None)
    def add(self, s):
        i = hash(s, self.size)
        self.l[i] = s
    
def test_hash_table():
    ht = HashTable(5)
    ht.add('Darren')
    assert ht.size == 5
    assert ht.l == [ None, None, None, None, 'Darren' ]
    ht.add('Jack')

# unfinished