# https://www.geeksforgeeks.org/dsa/find-the-missing-number/

from typing import List

def sum_n_terms_approach(arr: List[int]) -> int:
    n = len(arr) + 1
    exp = (n * (n+1)) // 2
    return exp - sum(arr)

def test_sum_n_terms_approach():
    assert sum_n_terms_approach([8, 2, 4, 5, 3, 7, 1]) == 6
    assert sum_n_terms_approach([1, 2, 3, 5]) == 4
    assert sum_n_terms_approach([2, 3, 4, 5, 6]) == 1
    assert sum_n_terms_approach([1]) == 2
    assert sum_n_terms_approach([]) == 1