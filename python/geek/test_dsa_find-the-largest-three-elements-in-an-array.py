# https://www.geeksforgeeks.org/dsa/find-the-largest-three-elements-in-an-array/

from typing import List, Optional

def one_traversal(arr: List[int]) -> List[int]:
    fst: Optional[int] = None  
    snd: Optional[int] = None 
    thd: Optional[int] = None
    for x in arr:
        if x == fst or x == snd or x == thd:
            pass
        elif fst is None or x >= fst:
            thd = snd 
            snd = fst
            fst = x
        elif snd is None or x >= snd:
            thd = snd
            snd = x
        elif thd is None or x >= thd:
            thd = x
        else: 
            pass 
    acc: List[int] = []
    for item in [fst, snd, thd]:
        if item:
            acc.append(item)
    return acc

def test_one_traversal():
    assert one_traversal([10, 4, 3, 50, 23, 90]) == [90, 50, 23]
    assert one_traversal([10, 9, 9]) == [10, 9]
    assert one_traversal([10, 10, 10]) == [10]
    assert one_traversal([]) == []