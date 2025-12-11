from typing import List

class SolutionA:
    def combine(self, n: int, k: int) -> List[List[int]]:
        nums = list(range(1,n+1))
        res = []
        def go(start, acc):
            if len(acc) == k:
                res.append(acc.copy())
                return
            for i in range(start, n):
                acc.append(nums[i])
                go(i+1, acc)
                acc.pop()
        go(0,[])
        return res

def testA():
    sol = SolutionA()
    out1 = sol.combine(4, 2)
    expect1 = [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    assert sorted(out1) == sorted(expect1)
    out2 = sol.combine(1, 1)
    expect2 = [[1]]
    assert sorted(out2) == sorted(expect2)

# runtime: 49.98%
# memory: 27.13%