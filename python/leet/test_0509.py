from typing import Dict

class SolutionRecursion:
    def fib(self, n: int, memo: Dict[int, int] = {}) -> int:
        if n <= 1:
            return n
        elif memo.get(n):
            return memo[n]
        else:
            memo[n] = self.fib(n-1, memo) + self.fib(n-2, memo)
            return memo[n]

def test_solution_recursion():
    sol = SolutionRecursion()
    assert sol.fib(2) == 1
    assert sol.fib(3) == 2
    assert sol.fib(4) == 3
    assert sol.fib(1) == 1
    assert sol.fib(5) == 5
    assert sol.fib(6) == 8
    assert sol.fib(30) == 832040
    assert sol.fib(10) == 55

class SolutionTabula:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        a = 0
        b = 1
        for _ in range(2, n+1):
            a, b = b, a + b
        return b

def test_solution_tabula():
    sol = SolutionTabula()
    assert sol.fib(0) == 0
    assert sol.fib(2) == 1
    assert sol.fib(3) == 2
    assert sol.fib(4) == 3
    assert sol.fib(1) == 1
    assert sol.fib(5) == 5
    assert sol.fib(6) == 8
    assert sol.fib(30) == 832040
    assert sol.fib(10) == 55

class SolutionC:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        else: 
            a = 0
            b = 1
            for _ in range(2, n+1):
                a, b = b, a + b
            return b   

def test_c():
    sol = SolutionC()
    assert sol.fib(0) == 0
    assert sol.fib(1) == 1
    assert sol.fib(2) == 1
    assert sol.fib(3) == 2
    assert sol.fib(4) == 3
    assert sol.fib(5) == 5
    assert sol.fib(6) == 8
    assert sol.fib(10) == 55
    assert sol.fib(30) == 832040
    