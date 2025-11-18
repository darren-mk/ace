from typing import List, Optional

class HashTable:
    def __init__(self, size:int) -> None:
        self.size = size
        self.table: List[Optional[str]] = [None] * size
    def hash(self, k:str) -> int:
        chars = list(k)
        acc: int = 1
        for char in chars:
            acc += (ord(char) - 96)
        return acc % self.size
    def add(self, k:str, v:str) -> None:
        self.table[self.hash(k)] = v
    def show(self) -> List[Optional[str]]:
        return self.table
    def get(self, k:str) -> Optional[str]:
        return self.table[self.hash(k)]

def test():
    assert list("abc") == ['a', 'b', 'c']
    assert ord('a') == 97
    ht = HashTable(5)
    assert ht.hash('ab') == 4
    ht.add('ab', 'c')
    assert ht.get('ab') == 'c'
    assert ht.show() == [None, None, None, None, 'c']