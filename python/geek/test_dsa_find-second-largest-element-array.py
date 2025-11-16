# https://www.geeksforgeeks.org/dsa/find-second-largest-element-array/

from typing import List

def sorting_approach(arr: List[int]) -> int:
    arr.sort()
    largest = arr[len(arr) - 1]
    for i in range(len(arr)-1, -1, -1):
        n = arr[i]
        if n < largest:
            return n
    return -1

def test_sorting_approach():
    arr = [2,3,1]
    arr.sort()
    assert arr == [1,2,3]
    assert sorting_approach([12, 35, 1, 10, 34, 1]) == 34
    assert sorting_approach([10, 5, 10]) == 5
    assert sorting_approach([10, 10, 10]) == -1

def one_pass_approach(arr: List[int]) -> int:
    firstly = None 
    secondly = None
    for x in arr:
        if firstly is None or x >= firstly:
            firstly = x
        elif secondly is None or x >= secondly:  
            secondly = x
    return secondly if secondly else -1

def test_one_pass_approach():
    assert one_pass_approach([12, 35, 1, 10, 34, 1]) == 34
    assert one_pass_approach([10, 5, 10]) == 5
    assert one_pass_approach([10, 10, 10]) == -1