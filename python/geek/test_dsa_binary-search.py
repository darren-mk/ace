# https://www.geeksforgeeks.org/dsa/binary-search/

from typing import List

def iterative(arr: List[int], target: int):
    low = 0 
    high = len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

def test_iterative():
    assert iterative([2, 3, 4, 10, 40], 10) == 3
    assert iterative([2, 5, 8, 12, 16, 23, 38, 56, 72, 91], 23) == 5
    assert iterative([1, 2, 3, 4, 5], 6) == -1
    assert iterative([], 1) == -1
    assert iterative([1], 1) == 0

def recursive(arr: List[int], target: int) -> int:
    def inner(low:int, high:int) -> int:
        if low <= high:
            mid = (low + high) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                return inner(mid+1, high)
            else:
                return inner(low, mid-1)
        else: 
            return -1
    return inner(0, len(arr)-1)

def test_recursive():
    assert recursive([2, 3, 4, 10, 40], 10) == 3
    assert recursive([2, 5, 8, 12, 16, 23, 38, 56, 72, 91], 23) == 5
    assert recursive([1, 2, 3, 4, 5], 6) == -1
    assert recursive([], 1) == -1
    assert recursive([1], 1) == 0