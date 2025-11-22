from typing import List, Set, Tuple

Ind = int
Val = int

class SolutionA:
    def fourSum(self, nums: List[Val], target: Val) -> List[List[Ind]]:
        nums.sort()
        n = len(nums)
        seen: Set[Tuple[Val, Val, Val, Val]] = set()
        res: List[List[Ind]] = []
        for i in range(n-2):
            for j in range(i + 1, n - 2):
                left = j + 1
                right = n - 1
                while left < right:
                    summed = nums[i] + nums[j] + nums[left] + nums[right]
                    if summed < target:
                        left += 1
                    elif summed > target:
                        right -= 1
                    else:
                        seen.add((nums[i], nums[j], nums[left], nums[right]))
                        left += 1
                        right -= 1
        for item in seen:
            res.append(list(item))
        return res

def test_a():
    l = [1,0,-1,0,-2,2]
    l.sort()
    assert l == [-2,-1,0,0,1,2]
    s = SolutionA()
    assert s.fourSum([1,0,-1,0,-2,2], 0) == [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    assert s.fourSum([2,2,2,2,2], 8) == [[2,2,2,2]]