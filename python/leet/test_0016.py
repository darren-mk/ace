from typing import List, Optional

Ind = int
Val = int

class SolutionA:
    def threeSumClosest(self, nums: List[Ind], target: Val) -> Val:
        nums.sort()
        n = len(nums)
        if n == 3: return sum(nums)
        closest: Optional[Val] = None
        for i in range(n):
            left: Ind = i + 1
            right: Ind = n - 1
            while left < right:
                # record if better
                cur_sum: Val = nums[i] + nums[left] + nums[right]
                if closest is None or abs(cur_sum - target) < abs(closest - target):
                    closest = cur_sum
                    continue
                # determine next direction
                left_up_diff = abs(nums[i] + nums[left+1] + nums[right] - target)
                right_down_diff = abs(nums[i] + nums[left] + nums[right-1] - target)
                if left_up_diff < right_down_diff:
                    left += 1
                else:
                    right -= 1
        return -1 if closest is None else closest

def test_a():
    sol = SolutionA()
    assert sol.threeSumClosest([-1,2,1,-4], 1) == 2
    assert sol.threeSumClosest([0,0,0], 1) == 0
    assert sol.threeSumClosest([-20,-19,41,1], 1) == 2
    assert sol.threeSumClosest([-84,92,26,19,-7,9,42,-51,8,30,-100,-13,-38], 78) == 77
    assert sol.threeSumClosest([1,1,1,1], 0) == 3
    assert sol.threeSumClosest([-4,2,2,3,3,3], 0) == 0