# https://www.geeksforgeeks.org/dsa/program-for-nth-fibonacci-number/

def recur_approach(n):
    memo = {}
    def go(n):
        if n <= 1: return n
        if n in memo: return memo[n]
        memo[n] = go(n-1) + go(n-2)
        return memo[n]
    return go(n)

def test_recur_approach():
    assert recur_approach(0) == 0
    assert recur_approach(1) == 1
    assert recur_approach(2) == 1
    assert recur_approach(5) == 5
    assert recur_approach(10) == 55

def tabula_approach(n):
    a = 0
    b = 1
    for _ in range(n):
        a, b = b, a + b
    return a

def test_tabula_approach():
    assert tabula_approach(0) == 0
    assert tabula_approach(1) == 1
    assert tabula_approach(2) == 1
    assert tabula_approach(5) == 5
    assert tabula_approach(10) ==  55