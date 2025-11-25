from typing import List

class SolutionA:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        memo = {}
        for i in range(len(nums)):
            if nums[i] in memo:
                indices = memo[nums[i]]
                max_idx = max(indices)
                if abs(i - max_idx) <= k:
                    return True
                else:
                    memo[nums[i]].append(i)
            else:
                memo[nums[i]] = [i]
        return False

def testA():
    sol = SolutionA()
    assert sol.containsNearbyDuplicate([1, 2, 3, 1], 3) is True
    assert sol.containsNearbyDuplicate([1, 0, 1, 1], 1) is True
    assert sol.containsNearbyDuplicate([1, 2, 3, 1, 2, 3], 2) is False
    assert sol.containsNearbyDuplicate([1, 2, 3, 4], 3) is False
    assert sol.containsNearbyDuplicate([1, 2, 3, 1], 2) is False
    assert sol.containsNearbyDuplicate([1, 1], 0) is False
    assert sol.containsNearbyDuplicate([99, 99], 1) is True
    assert sol.containsNearbyDuplicate([1, 2, 3, 1], 100) is True
    assert sol.containsNearbyDuplicate([42], 10) is False

# runtime: 12.77%
# memory: 6.44%