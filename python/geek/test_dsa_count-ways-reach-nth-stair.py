# https://www.geeksforgeeks.org/dsa/count-ways-reach-nth-stair/

from typing import Dict


def topdown(n: int) -> int:
    memo: Dict[int, int] = dict()
    def recur(x: int) -> int:
        if x == 0 or x == 1:
            return 1
        one_step: int = memo[x-1] or recur(x-1)
        two_step: int = memo[x-2] or recur(x-2)
        return one_step + two_step
    return recur(n)

def test_topdown():
    assert topdown(1) == 1
    assert topdown(2) == 2
    assert topdown(4) == 5
    assert topdown(5) == 8
    assert topdown(10) == 89