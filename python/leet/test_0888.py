from typing import List, Set

class Solution:
    def sumNums(self, nums: List[int]) -> int:
        sum = 0
        for num in nums:
            sum += num
        return sum
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        alice_sum = self.sumNums(aliceSizes)
        bob_sum = self.sumNums(bobSizes)
        target: int = (alice_sum + bob_sum) // 2
        alice_sizes: Set[int] = set(aliceSizes)
        result = []
        for bob_size in bobSizes:
            expected = bob_sum - target - bob_size
            if expected * -1 in alice_sizes:
                result = [ expected * -1, bob_size]
                break
        return result

def test():
    assert set([1,2,3]) == {1,2,3}
    solution = Solution()
    assert solution.fairCandySwap([1,1], [2,2]) == [1,2]
    assert solution.fairCandySwap([1,2], [2,3]) == [1,2]
    assert solution.fairCandySwap([2], [1,3]) == [2,3]
    assert solution.fairCandySwap([2,3], [3,4]) == [2,3]