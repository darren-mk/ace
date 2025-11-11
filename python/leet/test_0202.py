from typing import List

class Solution:
    def detach(self, n: int) -> List[int]:
            s = str(n)
            nums = []
            for c in s:
                nums.append(int(c))
            return nums
    def product(self, nums) -> int:
        sum = 0
        for num in nums:
            sum += num * num
        return sum
    def process(self, n:int) -> int:
        return self.product(self.detach(n))
    def isHappy(self, n: int) -> bool:
        seen = set()
        cursor = n
        while cursor != 1 and cursor not in seen:
            seen.add(cursor)
            cursor = self.process(cursor)
        return cursor == 1
            
def test_0202():
    assert str(123) == '123'
    sol = Solution()
    assert sol.detach(123) == [1,2,3]
    assert sol.product([1,2,3]) == 14
    assert sol.process(123) == 14
    assert sol.process(19) == 82
    assert sol.process(82) == 68
    assert sol.process(68) == 100
    assert sol.process(100) == 1
    assert sol.isHappy(1) == True
    assert sol.isHappy(100) == True
    assert sol.isHappy(68) == True
    assert sol.isHappy(2) == False