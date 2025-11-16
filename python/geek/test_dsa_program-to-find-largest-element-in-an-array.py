# https://www.geeksforgeeks.org/dsa/program-to-find-largest-element-in-an-array/

from typing import List

def iterative(arr: List[int]) -> int:
    largest = arr[0]
    for x in arr:
        largest = max(largest, x)
    return largest

def test_iterative():
    assert iterative([10, 20, 4]) == 20
    assert iterative([20, 10, 20, 4, 100]) == 100
    assert iterative([-10, -20, -4, -2]) == -2
    assert iterative([5]) == 5
    assert iterative([1, 1, 1, 1]) == 1

def recursive(arr: List[int]) -> int:
    def f(i:int, largest:int) -> int:
        if len(arr) <= i:
            return largest 
        else: 
            return f(i+1, max(largest, arr[i]))
    return f(0, arr[0])

def test_recursive():
    assert recursive([10, 20, 4]) == 20
    assert recursive([20, 10, 20, 4, 100]) == 100
    assert recursive([-10, -20, -4, -2]) == -2
    assert recursive([5]) == 5
    assert recursive([1, 1, 1, 1]) == 1