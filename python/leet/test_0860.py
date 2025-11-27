from typing import List

class SolutionA:
    def lemonadeChange(self, bills: List[int]) -> bool:
        memo = {}
        for bill in bills:
            if bill == 5:
                memo[5] = memo.get(5,0) + 1
            elif bill == 10:
                memo[10] = memo.get(10, 0) + 1
                memo[5] = memo.get(5, 0) - 1
                if memo[5] < 0:
                    return False
            elif bill == 20:
                memo[20] = memo.get(20, 0) + 1
                if memo.get(10, 0) >= 1 and memo.get(5, 0) >= 1:
                    memo[10] = memo.get(10, 0) - 1
                    memo[5] = memo.get(5, 0) - 1
                else:
                    memo[5] = memo.get(5, 0) - 3
                if memo.get(10, 0) < 0 or memo.get(5, 0) < 0:
                    return False
        return True

def testA():
    sol = SolutionA()
    assert sol.lemonadeChange([5,5,5,10,20]) is True
    assert sol.lemonadeChange([5,5,10,10,20]) is False

# runtime: 30.20%
# memory: 34.10%

class SolutionB:
    def lemonadeChange(self, bills: List[int]) -> bool:
        m = {5:0, 10:0, 20:0}
        for bill in bills:
            if bill == 5:
                m[5] += 1
            elif bill == 10:
                m[10] += 1
                m[5] -= 1
                if m[5] < 0:
                    return False
            elif bill == 20:
                m[20] += 1
                if m[10] >= 1 and m[5] >= 1:
                    m[10] -= 1
                    m[5] -= 1
                else:
                    m[5] -= 3
                if m[10] < 0 or m[5] < 0:
                    return False
        return True

def testB():
    sol = SolutionB()
    assert sol.lemonadeChange([5,5,5,10,20]) is True
    assert sol.lemonadeChange([5,5,10,10,20]) is False

# runtime: 30.20%
# memory: 34.10%