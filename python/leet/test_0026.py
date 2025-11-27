from typing import List

class SolutionA:
    def removeDuplicates(self, nums: List[int]) -> int:
        acc = []
        for num in nums:
            if not acc or acc[-1] != num:
                acc.append(num)
        for i, x in enumerate(acc):
            nums[i] = x
        return len(acc)

# runtime: 100.00%
# memory: 74.50%