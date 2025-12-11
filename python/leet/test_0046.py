from typing import List

class SolutionA:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def go(acc: List[int]):
            if len(acc) == len(nums):
                res.append(acc)
            else:
                for num in nums:
                    if not num in acc:
                        go(acc + [num])
        go([])
        return res

def testA():
    sol = SolutionA()
    assert sorted(sol.permute([1, 2, 3])) == sorted([
        [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1] ])
    assert sorted(sol.permute([0, 1])) == sorted([
        [0,1],[1,0] ])
    assert sol.permute([1]) == [[1]]

# time: O(N^2 * N!)
# space: O(N * N!)
# runtime: 100.00%
# memory: 95.58%

class SolutionB:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def go(comb):
            if len(comb) == len(nums):
                res.append(comb[:])
                return
            for num in nums:
                if num not in comb:
                    comb.append(num)
                    go(comb)
                    comb.pop()
        go([])
        return res

def testB():
    sol = SolutionB()
    assert sorted(sol.permute([1, 2, 3])) == sorted([
        [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]])
    assert sorted(sol.permute([0, 1])) == sorted([[0,1],[1,0]])
    assert sol.permute([1]) == [[1]]

class SolutionC:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def go(acc):
            if len(acc) == len(nums):
                res.append(acc[:])
                return
            for num in nums:
                if num not in acc:
                    acc.append(num)
                    go(acc)
                    acc.pop()
        go([])
        return res

def testC():
    sol = SolutionC()
    assert sorted(sol.permute([1, 2, 3])) == sorted([
        [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]])
    assert sorted(sol.permute([0, 1])) == sorted([[0,1],[1,0]])
    assert sol.permute([1]) == [[1]]

# runtime: 32.88%
# memory: 58.88%