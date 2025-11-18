# https://www.geeksforgeeks.org/dsa/tribonacci-numbers/

def recursion(n):
    memo = {}
    def go(x):
        if x in [0,1]: return 0
        if x in [2,3]: return 1
        if x in memo: return memo[x]
        memo[x] = go(x-1) + go(x-2) + go(x-3)
        return memo[x]
    return go(n)

def test_recursion():
    assert [recursion(i) for i in range(5)] == [0, 0, 1, 1, 2]
    assert [recursion(i) for i in range(10)] == [0, 0, 1, 1, 2, 4, 7, 13, 24, 44]
    assert [recursion(i) for i in range(20)] == [0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513]

def tabulation(n):
    a = 0
    b = 0
    c = 1
    for _ in range(n):
        a, b, c = b, c, a + b + c
    return a

def test_tabulation():
    assert [tabulation(i) for i in range(5)] == [0, 0, 1, 1, 2]
    assert [tabulation(i) for i in range(10)] == [0, 0, 1, 1, 2, 4, 7, 13, 24, 44]
    assert [tabulation(i) for i in range(20)] == [0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513]