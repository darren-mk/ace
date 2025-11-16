# https://www.geeksforgeeks.org/dsa/window-sliding-technique/

from typing import List

def sum_arr(arr: List[int]):
    sum = 0
    for x in arr:
        sum += x
    return sum

def f(arr: List[int], k: int) -> int:
    candidate = sum_arr(arr[:k])
    for i in range(len(arr) - k):
        candidate = max(candidate, sum_arr(arr[i:i+k]))
    return candidate

def test():
    assert f([5, 2, -1, 0, 3], 3) == 6
    assert f([1, 4, 2, 10, 23, 3, 1, 0, 20], 4) == 39